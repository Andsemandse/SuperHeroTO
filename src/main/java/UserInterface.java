import java.util.Scanner;

public class UserInterface {
    private final Database database = new Database();
    private int numberOfSuperheroes = 0;
    Scanner sc = new Scanner(System.in);

    public void startProgram() {
        int brugerValg = 0;
        do {
            System.out.println("""
                    VELKOMMEN TIL SUPERHERO-UNIVERSET!
                    1. Opret superhelt
                    2. Se alle superhelte
                    3. Find superhelt
                    4. Rediger superhelt
                    5. Slet superhelt
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
                System.out.println("Indtast superkrafter: ");
                String superPowers = sc.nextLine();
                System.out.println("Er et menneske? j/n: ");
                boolean isHuman = checkBoolean();
                System.out.println("Indtast styrke (tal med decimaler): ");
                double strength = readDouble();
                database.addSuperhero(superheroName, realName, yearCreated, superPowers, isHuman, strength);
                numberOfSuperheroes++;
            } else if (brugerValg == 2) {
                System.out.println("Liste af superhelte:\n");
                System.out.println(database.getArrayList(numberOfSuperheroes));
            } else if (brugerValg == 3) {
                System.out.println("Tast navnet. eller del af navnet, på den superhelt, du vil finde:");
                String searchQuery = sc.next();
                database.searchSuperhero(searchQuery);
            } else if (brugerValg == 4) {
                System.out.println("Liste af superhelte:\n");
                System.out.println(database.getArrayList(numberOfSuperheroes));
                System.out.println("\n Hvilken superhelt vil du ændre? Tast venligst nummer: ");
                database.editSuperhero(sc.nextInt());
            } else if(brugerValg == 5) {

            } else if (brugerValg == 9) {
                System.exit(1);
            }
        }while(brugerValg != 9);
    }

    public int readInteger(){
        while (!sc.hasNextInt()){
            String text = sc.next();
            System.out.println("Du må ikke indtaste '" + text + "' , det skal være et helt tal, uden decimaler.");
        }
        return sc.nextInt();
    }

    public double readDouble(){
        while (!sc.hasNextDouble()){
            String text = sc.next();
            System.out.println("Du må ikke indtaste '" + text + "' , det skal være et tal, med eller uden decimaler.");
        }
        return sc.nextDouble();
    }

    public boolean checkBoolean(){
        boolean shouldContinue = true;
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
        }while (shouldContinue);
        return isHuman;
    }
}