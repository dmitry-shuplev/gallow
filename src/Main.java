import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Gallow gallow1 = new Gallow();
        gallow1.convencedWord();
        gallow1.generateUnhiddenWord();

        while (true) {
            interfase(gallow1);
            compareResult(gallow1);
            char inputedChar = getChar();
            compareChars(gallow1, inputedChar);
        }
    }

    static void compareResult(Gallow gallow1) {
        if (gallow1.hiddenWord.equals(gallow1.unhideenWord)) {
            System.out.println("Вы угадали слово.");
            System.exit(0);
        }
        if (gallow1.errors == 6) {
            System.out.println("Вы проиграли.");
            System.out.println("Было загадано слово:" + gallow1.hiddenWord);
            System.exit(0);
        }
    }

    static char getChar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву: ");
        char curentChar = scanner.nextLine().toUpperCase().charAt(0);
        return curentChar;
    }

    static void compareChars(Gallow gallow1, char inputedChar) {
        int matchCounter = 0;
        String unhiddentWord = "";
        for (int i = 0; i < gallow1.hiddenWord.length(); i++) {
            if (gallow1.hiddenWord.charAt(i) == inputedChar) {
                unhiddentWord += inputedChar;
                matchCounter++;
            } else {
                unhiddentWord += gallow1.unhideenWord.charAt(i);
            }
        }
        if (matchCounter == 0) gallow1.errors++;
        gallow1.unhideenWord = unhiddentWord;
        gallow1.usedChar += inputedChar;
    }

    static void interfase(Gallow gallow1) {

        switch (gallow1.errors) {
            case 0:
                System.out.println("______");
                break;
            case 1:
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("______");
                break;
            case 2:
                System.out.println("+-----+");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("______");
                break;
            case 3:
                System.out.println("+-----+");
                System.out.println("|     |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("______");
                break;
            case 4:
                System.out.println("+-----+");
                System.out.println("|     |");
                System.out.println("|     O");
                System.out.println("|");
                System.out.println("|");
                System.out.println("______");
                break;
            case 5:
                System.out.println("+-----+");
                System.out.println("|     |");
                System.out.println("|     O");
                System.out.println("|    /-\\");
                System.out.println("|");
                System.out.println("______");

                break;
            case 6:
                System.out.println("Вы проиграли.");
                System.out.println("+-----+");
                System.out.println("|     |");
                System.out.println("|     O");
                System.out.println("|    /-\\");
                System.out.println("|     |");
                System.out.println("______");
                break;
        }
        System.out.println("Загадано слово:" + gallow1.unhideenWord);
        System.out.println("Вы уже использовали: " + gallow1.usedChar);
    }

//end Main
}


class Gallow {
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


    //


    //
//end Gallow
}


