import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class GameSession {

        int errors = 0;
        String hiddenWord = "";
        String unhideenWord = "";
        String usedChar = "";
        StringBuilder avalibleChars = new StringBuilder("АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ") ;

        void convencedWord() {
            //***
            try {
                File temp = new File("resources\\vocabular.txt");
                String path = temp.getAbsolutePath();
                String path1 = "";
                for(int i=0; i<path.length();i++){
                    if (path.charAt(i) == '/'){ path1 += '\\'; }
                    else{path1+=path.charAt(i);}
                }

                File file = new File("C:\\Users\\дим\\Java_code\\gallow\\resources\\vocabular.txt");
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
