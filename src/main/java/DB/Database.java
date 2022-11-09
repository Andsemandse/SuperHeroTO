package DB;

import java.util.ArrayList;
import java.util.Scanner;
import Shero.Superhero;
import Ui.UserInterface;
import DB.Database;


public class Database {

    private String superheroName;
    private String realName;
    private String yearCreated;
    private int yearCreatedInt;
    private String superPowers;
    private boolean isHuman;
    private double strengthDouble;
    private String strength;
    private String isHumanChar;
    private Scanner sc = new Scanner(System.in);

    private ArrayList<Superhero> database = new ArrayList<>();

    public void addSuperhero(String superheroName, String realName, int yearCreated, String superPowers, boolean isHuman, double strength) {
        Superhero superhero = new Superhero(superheroName, realName, yearCreated, superPowers, isHuman, strength);
        database.add(superhero);
    }

    public String getArrayList(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println("Nr. " + (i + 1) + ":");
            System.out.println(database.get(i));
        }
        return " ";
    }

    public String searchSuperhero(String searchQuery) {
        boolean isPresent = false;
        for (Superhero hero : database) {
            if (hero.getSuperheroName().contains(searchQuery)) {
                System.out.println(hero);
                isPresent = true;
            }
        }
        if (!isPresent) {
            System.out.println("Der findes ikke en superhelt i databasen med det navn.");
        }
        return " ";
    }

    public Superhero getSuperhero(int x){
        return database.get(x - 1);
    }
    public void editSuperhero(Superhero hero) {
        System.out.println("Indtast ønskede superheltenavn(Tast Enter, hvis det skal forblive uændret): ");
        superheroName = sc.nextLine();
        if(!superheroName.isEmpty()) {
            hero.setSuperheroName(superheroName);
        }
        System.out.println("Indtast ønskede rigtige navn(Tast Enter, hvis det skal forblive uændret): ");
        realName = sc.nextLine();
        if(!realName.isEmpty()) {
            hero.setRealName(realName);
        }
        System.out.println("Indtast ønskede skabelsesår(Tast Enter, hvis det skal forblive uændret): ");
        yearCreated = sc.nextLine();
        if(!yearCreated.isEmpty()) {
            yearCreatedInt = Integer.parseInt(yearCreated);
            hero.setYearCreated(yearCreatedInt);
        }
        System.out.println("Indtast ønskede superkræfter(Tast Enter, hvis det skal forblive uændret): ");
        superPowers = sc.nextLine();
        if(!superPowers.isEmpty()) {
            hero.setSuperPowers(superPowers);
        }
        System.out.println("Indtast om superhelten er menneske eller ej, 'j' ller 'n'(Tast Enter, hvis det skal forblive uændret): ");
        isHumanChar = sc.nextLine();
        if(isHumanChar == "j"){
            hero.setHuman(true);
        }else if(isHumanChar == "n"){
            hero.setHuman(false);
        }
        System.out.println("Indtast ønskede styrke(Tast Enter, hvis det skal forblive uændret): ");
        strength = sc.nextLine();
        if(!strength.isEmpty()) {
            strengthDouble = Double.parseDouble(strength);
            hero.setStrength(strengthDouble);
        }
        System.out.println("Superhelten er blevet redigeret!\n");
    }

    //methods for test purposes
    public ArrayList<Superhero> getSuperheroes() {
        return database;
    }

    public int getSize() {
        return database.size();
    }

    public void removeSuperhero() {
        database.remove(UserInterface.removeNumber - 1);
        System.out.println("Fjernet superhelt nummer " + UserInterface.removeNumber + " fra databasen:");
    }

}