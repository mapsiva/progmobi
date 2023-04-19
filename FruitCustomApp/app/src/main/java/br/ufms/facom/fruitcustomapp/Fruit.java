package br.ufms.facom.fruitcustomapp;

public class Fruit {
    private String name;
    private String description;
    private int drawableId;

    public Fruit (){

    }
    public Fruit (String name, String description, int drawableId){
        this.name = name;
        this.description = description;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }
}
