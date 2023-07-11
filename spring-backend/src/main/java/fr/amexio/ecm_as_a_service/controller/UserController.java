package fr.amexio.ecm_as_a_service.controller;

import fr.amexio.ecm_as_a_service.model.Container;
import fr.amexio.ecm_as_a_service.model.Group;
import fr.amexio.ecm_as_a_service.model.User;
import fr.amexio.ecm_as_a_service.service.ContainerService;
import fr.amexio.ecm_as_a_service.service.GroupService;
import fr.amexio.ecm_as_a_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="users")
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ContainerService containerService;

    @Autowired
    private GroupService groupService;

    /**
     * Récupère l'intégralité des utilisateurs
     * @return
     */
    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tous les utilisateurs",
                    content = { @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Pas d'utilisateurs trouvés ")
    })
    @GetMapping
    public List<User> getAllUser(){
        return userService.findAll();
    }

    /**
     * Créer un nouvel utilisateur
     * @param user
     */
    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Un nouvel utilisateur a bien été crée")
    })
    @PostMapping
    public void createUser(@RequestBody User user){
         userService.addUser(user);
    }

    /**
     * supprime un utilisateur
     * @param id
     * @return
     */
    @Operation(summary = "Delete a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'utilisateur a bien été supprimé")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteUser(int id){

        User user = userService.deleteById(id);

        if(user != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Retourne les informations d'un utilisateur précis
     * @param id
     * @return
     */
    @Operation(summary = "Get a user informations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'utilisateur a bien été retrouvé"),
            @ApiResponse(responseCode = "404", description = "L'utilisateur n'a pas été retrouvé ")
    })
    @GetMapping("/{userId}")
    public User getUser(@PathVariable int id){
        return userService.findById(id);
    }


    /**
     * Donne accès à un conteneur à un autre utilisateur
     * @param receiverId
     * @param containerId
     */
    @Operation(summary = "Give container access to another user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le conteneur est bien acquis par l'utilisateur")
    })
    @PutMapping("/{userId}/{containerId}")
    public void giveContainerAccess(int receiverId, int containerId){
        if(containerService.findById(containerId).isValide()) {
            userService.findById(receiverId).addUserContainer(containerService.findById(containerId));
        }
    }

}
