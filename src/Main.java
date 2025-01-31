import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        GameSession game = new GameSession();
        game.convencedWord();
        game.generateUnhiddenWord();

        while (true) {
            Show.showGallow(game);
            compareResult(game);
            char inputedChar = getChar();
            compareChars(game, inputedChar);
        }
    }

    static void compareResult(GameSession game) {
        if (game.hiddenWord.equals(game.unhideenWord)) {
            System.out.println("Вы угадали слово.");
            System.exit(0);
        }
        if (game.errors == 6) {
            System.out.println("Вы проиграли.");
            System.out.println("Было загадано слово:" + game.hiddenWord);
            System.exit(0);
        }
    }

    static char getChar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву: ");
        char curentChar = scanner.nextLine().toUpperCase().charAt(0);
        return curentChar;
    }

    static void compareChars(GameSession game, char inputedChar) {
        int matchCounter = 0;
        String unhiddentWord = "";
        for (int i = 0; i < game.hiddenWord.length(); i++) {
            if (game.hiddenWord.charAt(i) == inputedChar) {
                unhiddentWord += inputedChar;
                matchCounter++;
            } else {
                unhiddentWord += game.unhideenWord.charAt(i);
            }
        }
        if (matchCounter == 0) game.errors++;
        game.unhideenWord = unhiddentWord;
        game.usedChar += inputedChar;
    }

}






