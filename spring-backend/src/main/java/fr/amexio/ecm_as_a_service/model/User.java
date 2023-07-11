package fr.amexio.ecm_as_a_service.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private boolean admin;
    private List<Container> containerList;

    public User(int id, String nom, String prenom, String mail) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.containerList = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Container> getContainerList() {
        return containerList;
    }
    public void setContainerList(List<Container> containerList) {
        this.containerList = containerList;
    }
    public void addUserContainer(Container container){
        this.containerList.add(container);
    }
    public Container getContainer(int id){
        for(Container container : containerList){
            if(container.getId() == id ){
                return container;
            }
        }
        return null;
    }
}
