import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class GameSession {

        int errors = 0;
        String hiddenWord = "";
        String unhideenWord = "";
        String usedChar = "";

        void convencedWord() {
            //***
            try {
                File file = new File("src\\vocabular.txt");
                Scanner scanner = new Scanner(file);
                Random random = new Random();
                int randWordNumber = random.nextInt(949);
                for (int i = 0; scanner.hasNextLine(); i++) {
                    String line = scanner.nextLine();
                    if (i == randWordNumber) hiddenWord = line.toUpperCase();
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        void generateUnhiddenWord() {
            for (int i = 0; i < hiddenWord.length(); i++) {
                unhideenWord += '*';
            }
        }

    }
