package Ui;

import DB.Database;

import java.io.*;
import java.util.Scanner;

import Shero.Superhero;
import Controller.Controller;

public class UserInterface {
    private final Database database = new Database();
    private int numberOfSuperheroes = 0;
    Scanner sc = new Scanner(System.in);
    public static int removeNumber;

    public void startProgram() throws Exception {
        int index = 0;
        File file = new File("superheroes.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream fi = new FileInputStream("superheroes.txt");
        ObjectInputStream oi = new ObjectInputStream(fi);
        boolean shouldContinue = true;
        Object obj = null;
        while (shouldContinue) {
            if (fi.available() != 0) {
                obj = (Superhero) oi.readObject();
                database.addHeroToDatabase((Superhero) obj);
                numberOfSuperheroes++;
            } else {
                shouldContinue = false;
            }
        }
        fi.close();
        oi.close();

        int brugerValg = 0;
        do {

            System.out.println("""
                    VELKOMMEN TIL SUPERHERO-UNIVERSET!
                    1. Opret superhelt
                    2. Vis alle superhelte
                    3. Vis alle superhelte sorteret
                    4. Find superhelt
                    5. Rediger superhelt
                    6. Slet superhelt
                    9. Afslut programmet
                        """);
            brugerValg = sc.nextInt();
            sc.nextLine();

            if (brugerValg == 1) {
                System.out.println("Indtast superheltenavn: ");
                String superheroName = sc.nextLine();
                System.out.println("Indtast rigtige navn: ");
                String realName = sc.nextLine();
                System.out.println("Indtast år skabt: ");
                int yearCreated = readInteger();
                sc.nextLine();
                System.out.println("Indtast superkræfter: ");
                String superPowers = sc.nextLine();
                System.out.println("Er et menneske? j/n: ");
                boolean isHuman = checkBoolean();
                System.out.println("Indtast styrke (tal med decimaler): ");
                double strength = readDouble();
                database.addSuperhero(superheroName, realName, yearCreated, superPowers, isHuman, strength);
                numberOfSuperheroes++;
            } else if (brugerValg == 2) {
                if (!database.getSuperheroes().isEmpty()) {
                    System.out.println("Liste af superhelte:\n");
                    System.out.println(database.getArrayList(numberOfSuperheroes));
                } else System.out.println("Der findes ingen superhelte i databasen.\n");
            } else if (brugerValg == 3) {
                caseSortSuperheroes(); //TODO
            } else if (brugerValg == 4) {
                System.out.println("Tast navnet. eller del af navnet, på den superhelt, du vil finde:");
                String searchQuery = sc.next();
                database.searchSuperhero(searchQuery);
            } else if (brugerValg == 5) {
                if (!database.getSuperheroes().isEmpty()) {
                    System.out.println("Liste af superhelte:\n");
                    System.out.println(database.getArrayList(numberOfSuperheroes));
                    System.out.println("Hvilken superhelt vil du ændre? Tast venligst nummer: ");
                    int superheroNumber = sc.nextInt();
                    if (database.getSize() + 1 > superheroNumber) {
                        database.editSuperhero(database.getSuperhero(superheroNumber));
                    } else System.out.println("Tast venligst et nummer indenfor antallet af superhelte.");
                }
            } else if (brugerValg == 6) {
                System.out.println("Fjern en superhelt fra din database: \n");
                database.getArrayList(numberOfSuperheroes);
                System.out.print("Angiv nummeret på superhelten, som ønskes fjernet: ");
                removeNumber = Integer.parseInt(sc.nextLine());
                database.removeSuperhero();
                numberOfSuperheroes--;
            } else if (brugerValg == 9) {
                try {
                    index = 0;
                    FileOutputStream f = new FileOutputStream("superheroes.txt");
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    if (!database.getSuperheroes().isEmpty()) {
                        while (index < database.getSize()) {
                            o.writeObject(database.get(index));
                            index++;
                        }
                    }
                    f.close();
                    o.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.exit(1);
            }
        } while (brugerValg != 9);
    }

    public int readInteger() {
        while (!sc.hasNextInt()) {
            String text = sc.next();
            System.out.println("Du må ikke indtaste '" + text + "' , det skal være et helt tal, uden decimaler.");
        }
        return sc.nextInt();
    }

    public double readDouble() {
        while (!sc.hasNextDouble()) {
            String text = sc.next();
            System.out.println("Du må ikke indtaste '" + text + "' , det skal være et tal, med eller uden decimaler.");
        }
        return sc.nextDouble();
    }

    public boolean checkBoolean() {
        boolean shouldContinue;
        boolean isHuman = true;
        String isHumanQ;
        do {
            isHumanQ = sc.nextLine();

            if (isHumanQ.equalsIgnoreCase("j")) {
                isHuman = true;
                shouldContinue = false;
            } else if (isHumanQ.equalsIgnoreCase("n")) {
                isHuman = false;
                shouldContinue = false;
            } else {
                System.out.println("Tast venligst 'j' eller 'n'.");
                shouldContinue = true;
            }
        } while (shouldContinue);
        return isHuman;
    }

    public void caseSortSuperheroes() {
        System.out.println("Sorter efter et af følgende kriterier:");
        System.out.println("""
                1. Rigtige navn
                2. Helte navn
                3. Superheltens årstal
                4. Superkraft
                5. Menneske eller ej
                6. Styrke
                """);

        int sortChoice = readInteger();

        switch (sortChoice) {
            case 1:
                Controller.sortByrealName();
                numberOfSuperheroes();
                break;

            case 2:
                Controller.sortBysuperheroName();
                numberOfSuperheroes();
                break;

            case 3:
                Controller.sortByyearCreated();
                numberOfSuperheroes();
                break;

            case 4:
                Controller.sortBysuperPowers();
                numberOfSuperheroes();
                break;

            case 5:
                Superhero.sortByisHuman();
                numberOfSuperheroes();
                break;

            case 6:
                Controller.sortBystrength();
                numberOfSuperheroes();
                break;
            default:
                System.out.println("Vælg venligst et nummer mellem 1 og 6.");
        }
    }

    private void numberOfSuperheroes() {
    }
}