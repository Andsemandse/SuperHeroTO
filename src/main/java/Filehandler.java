import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Filehandler {
        private final File file = new File("demo.txt");
        PrintStream printStream = new PrintStream(file);

        public Filehandler() throws FileNotFoundException {
        }
        public void savedata(){
            printStream.println("冷天空加油" +
                    " ");
        }


    }


