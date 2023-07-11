package fr.amexio.ecm_as_a_service.controller;

import fr.amexio.ecm_as_a_service.model.Container;
import fr.amexio.ecm_as_a_service.model.Group;
import fr.amexio.ecm_as_a_service.model.User;
import fr.amexio.ecm_as_a_service.service.ContainerService;
import fr.amexio.ecm_as_a_service.service.GroupService;
import fr.amexio.ecm_as_a_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="groups")
@RequestMapping("v1/groups")
public class GroupController {

    @Autowired
    GroupService groupService;
    @Autowired
    UserService userService;

    @Autowired
    ContainerService containerService;

    /**
     * Création du groupe
     * @param group
     */
    @Operation(summary = "Create a group")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Le groupe a bien été crée")
    })
    @PostMapping
    public void createGroup(@RequestBody Group group){
        groupService.addGroup(group);
    }

    /**
     * Recupère tous les groupes
     * @return
     */
    @Operation(summary = "Get all groups")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les groupes ont bien été trouvés")
    })
    @GetMapping
    public List<Group> getAllGroups(){
        return groupService.findAll();
    }

    /**
     * Renvoie un groupe selon son id
     * @param groupId
     * @return
     */
    @Operation(summary = "Get a group")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le groupe a bien été trouvé")
    })
    @GetMapping("/{groupId}")
    public Group getAGroup(int groupId){
        return groupService.findById(groupId);
    }

    /**
     * Supprime un groupe selon son id
     * @param groupId
     * @return
     */
    @Operation(summary = "Delete a group")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le groupe a bien été supprimé")
    })
    @DeleteMapping("/{groupId}")
    public ResponseEntity<Void> deleteGroup(int groupId){
        Group group = groupService.deleteById(groupId);
        if(group != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Ajoute un utilisateur à un groupe
     * @param user
     * @param groupId
     */
    @Operation(summary = "Add a user to a group")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'utilisateur fait partie du groupe")
    })
    @PutMapping("/{groupId}/{user}")
    public void addMembership(User user, int groupId){
        groupService.addMembership(groupId,user);
    }
    @Operation(summary = "Remove a user from a group")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'utilisateur a bien été supprimé du groupe")
    })
    @DeleteMapping("/{groupId}/{user}")
    public void deleteMembership(User user, int groupId){
        groupService.removeMembership(groupId, user);
    }

    /**
     * Donne aux membres d'un groupe l'accès à un conteneur
     * @param groupId
     * @param containerId
     */
    @Operation(summary = "Give all group members access to a container")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les membres du groupes ont bien le conteneur")
    })
    @PostMapping("/{groupId}/{containerId}")
    public void giveGroupContainerAccess(int groupId, int containerId){
        if(containerService.findById(containerId).isValide()){
            groupService.giveAllMemberContainer(groupId, containerService.findById(containerId));
            Container container = containerService.findById(containerId);
            for(User user : groupService.findById(groupId).getMemberList()){
                userService.addUserContainer(user.getId(), container.getId(),container.getName(), container.getType(), container.isValide());
            }
        }
    }
}
