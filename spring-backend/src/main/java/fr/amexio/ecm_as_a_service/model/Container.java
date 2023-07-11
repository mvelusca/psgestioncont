package fr.amexio.ecm_as_a_service.model;

public class Container {

    private int id;
    private String name;
    private String type;
    private boolean valide;

    public Container(int id, String name, String type, boolean valide) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.valide = valide;
    }
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public int setType(int id) {
        return this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

}
