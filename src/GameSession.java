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
    StringBuilder avalibleChars = new StringBuilder("АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");

    void convencedWord() {
        try {
            String currentDir = System.getProperty("user.dir");
            String getAbsolutePath = "";
            for (int i = 0; i < currentDir.length(); i++) {
                if (currentDir.charAt(i) == '\\') {
                    getAbsolutePath += '/';
                } else {
                    getAbsolutePath += currentDir.charAt(i);
                }
            }
            //раскоментировать cледующую строку при компиляции на своем сомпьютере
            //getAbsolutePath = getAbsolutePath.substring(0, getAbsolutePath.length()-3);
            getAbsolutePath += "/resources/vocabular.txt";

            File file = new File(getAbsolutePath);
            Scanner scanner = new Scanner(file);
            Random random = new Random();
            int lineCounter = -1;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCounter++;
            }
            scanner = new Scanner(file);

            int randWordNumber = random.nextInt(lineCounter);
            System.out.println(randWordNumber);
            for (int i = 0; scanner.hasNextLine(); i++) {
                String line = scanner.nextLine();
                if (i == randWordNumber) {
                    hiddenWord = line.toUpperCase();
                }
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
