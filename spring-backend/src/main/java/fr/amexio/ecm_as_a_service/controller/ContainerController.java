package fr.amexio.ecm_as_a_service.controller;

import fr.amexio.ecm_as_a_service.model.Container;
import fr.amexio.ecm_as_a_service.service.ContainerService;
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


/**
 * Classe décrivant les appels Rest en relation avec les conteneurs
 */
@RestController
@Tag(name="containers")
@RequestMapping("/v1/containers")
public class ContainerController {
    @Autowired
    private ContainerService containerService;

    @Autowired
    private UserService userService;

    /**
     * Retourne tous les conteneurs existant ou ceux en attente de validation selon le paramètre
     * @param status
     * @return
     */
    @Operation(summary = "Get all containers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tous les conteneurs",
                    content = { @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Pas de conteneur trouvés ",
                    content = @Content) })
    @GetMapping
    public List<Container> getAllContainers(@RequestParam(required = false,value = "waiting")String status) {
        if(status == null) {
            return containerService.findAll();
        }
        else {
            return containerService.findWaitingContainers();
        }
    }

    /**
     * @param container
     * Requête Rest en POST permettant la création d'un conteneur mis en paramètre
     */
    @Operation(summary = "Create a container")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Création réussie d'un conteneur",
                    content = @Content)
    })
    @PostMapping
    public void createContainer(@RequestBody Container container){
        containerService.addContainer(container);
    }

    /**
     * Suppression d'un conteneur
     * @param id
     * @return
     */
    @Operation(summary = "Delete a container")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suppression réussie d'un conteneur"),
            @ApiResponse(responseCode = "204", description = "Suppression réussie d'un conteneur"),
            @ApiResponse(responseCode = "404", description = "Ce conteneur n'existe pas")
    })
    @DeleteMapping("/{containerId}")
    public ResponseEntity<Void> deleteContainer(int id){

        Container container = containerService.deleteById(id);

        if(container != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Retourne les infos d'un conteneur précis
     * @param id
     * @return
     */
    @Operation(summary = "Get a container")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Récupération d'un conteneur existant",
                    content = { @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Le conteneur n'est pas trouvé ",
                    content = @Content)
    })
    @GetMapping("/{containerId}")
    public Container getContainer(int id){
        return containerService.findById(id);
    }

    /**
     * Retourne tous les conteneurs "détenus" par un utilisateur précis
     * @param userId
     * @return
     */
    @Operation(summary = "Get a user containers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les conteneurs existant de l'utilisateur"),
            @ApiResponse(responseCode = "404", description = "Cet utilisateur n'existe pas")
    })
    @GetMapping("/{userId}/containers")
    public List<Container> getUserContainers(int userId){
        return  userService.userContainers(userId);
    }

    /**
     * Crée un conteneur pour un utilisateur
     * @param userId
     * @param id
     * @param name
     * @param type
     */
    @Operation(summary = "Create a container and ask for validation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La création/demande a bien été faite")
    })
    @PostMapping("/{userId}/containers")
    public void requestContainerValidation(int userId, int id, String name, String type){
        userService.addUserContainer(userId,id,name,type,false);
        containerService.addContainer(userService.findUserContainer(id,userId));
    }

    /**
     * Passe l'attribut valide à true pour un conteneur en demande
     * @param containerId
     * @param userId
     * @return
     */
    @Operation(summary = "Validate a precise container")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le conteneur a bien été validé")
    })
    @PutMapping("/{userId}/{containerId}")
    public void validateContainer(int containerId, int userId){
        containerService.findById(containerId).setValide(true);
        userService.findUserContainer(containerId, userId).setValide(true);
    }

    /**
     * Refuse la demande et supprime le conteneur
     * @param userId
     * @param containerId
     * @return
     */
    @Operation(summary = "Refuse validation and delete container")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "La suppression du container est effective")
    })
    @DeleteMapping("/{userId}/{containerId}")
    public ResponseEntity<Void> refuseContainerValidation(int userId, int containerId){
        Container deletedContainer = containerService.findById(containerId);
        if(!deletedContainer.isValide()) {
            userService.deleteUserContainerById(userId, containerId);
            Container container = containerService.deleteById(containerId);
            if (container != null) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }


}
