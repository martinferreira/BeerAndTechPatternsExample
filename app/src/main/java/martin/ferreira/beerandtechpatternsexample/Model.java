package martin.ferreira.beerandtechpatternsexample;

public class Model {
    private String name = "Martin";
    private String surname = "Ferreira";

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}