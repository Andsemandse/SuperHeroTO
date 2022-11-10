package Shero;
import java.io.Serializable;
public class Superhero implements Serializable {

    //Attributer
    private String superheroName;
    private String realName;
    private int yearCreated;
    private String superPowers;
    private boolean isHuman;
    private double strength;

    //Konstruktør
    public Superhero(String superheroName, String realName, int yearCreated, String superPowers, boolean isHuman, double strength){
        this.superheroName = superheroName;
        this.realName = realName;
        this.yearCreated = yearCreated;
        this.superPowers = superPowers;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    public static void sortByisHuman() {
    }

    //getter metoder
    public String getSuperheroName(){
        return superheroName;
    }
    public String getRealName(){
        return realName;
    }
    public int getYearCreated(){
        return yearCreated;
    }
    public boolean getIsHuman() {

        return isHuman;
    }
    public String getSuperPowers(){
        return superPowers;
    }
    public double getStrength(){
        return strength;
    }

    //setter metoder
    public void setSuperheroName(String superheroName){
        this.superheroName = superheroName;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public void setYearCreated(int yearCreated){
        this.yearCreated = yearCreated;
    }
    public void setHuman(boolean isHuman){
        this.isHuman = isHuman;
    }
    public void setStrength(double strength){
        this.strength = strength;
    }
    public void setSuperPowers(String superPowers){
        this.superPowers = superPowers;
    }

    //custom toString metode
    @Override
    public String toString(){
        String isHumanString = "";
        if (isHuman == true){
            isHumanString = "JA";
        } else if (isHuman == false) {
            isHumanString = "NEJ";
        }
        return "Superheltenavn: " + superheroName + "\nRigtige navn: " + realName + "\nÅr skabt: " + yearCreated + "\nSuperkræfter: " + superPowers + "\nEr menneske: " + isHumanString + "\nStyrke: " + strength + "\n";
    }

}