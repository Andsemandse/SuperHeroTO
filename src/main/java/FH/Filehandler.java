package FH;

import java.io.*;

import Shero.Superhero;

public class Filehandler {
        /*private final File file = new File("demo.txt");
        PrintStream printStream = new PrintStream(file);

        public Filehandler() throws FileNotFoundException {
        }
        public void savedata(){
            printStream.println("冷天空加油" +
                    " ");
        }*/

    public void writeToFile() throws IOException {

        try {
            FileOutputStream f = new FileOutputStream(new File("superheroes.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public void readFromFile() throws FileNotFoundException {
        try {
            FileInputStream fi = new FileInputStream(new File("superheroes.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /*public void removeFromFile() throws FileNotFoundException {
        try {

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }*/
}