import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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
            //if (!isCharCorrect(game, inputedChar)) {
            //    Show.charError();
            //    continue;
            //}
            procesedGameSession(game, inputedChar);
        }
    }

    static void compareResult(GameSession game) {
        if (game.hiddenWord.equals(game.unhideenWord)) {
            Show.winGame(game);
            System.exit(0);
        }
        if (game.errors == 6) {
            Show.loseGame(game);
            System.exit(0);
        }
    }

    static char getChar() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.print("Введите букву: ");
        char curentChar = scanner.nextLine().toUpperCase().charAt(0);
        return curentChar;
    }

    static void procesedGameSession(GameSession game, char inputedChar) {
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
        if (matchCounter == 0) {
            game.errors++;
        }
        for (int i = 0; i < game.avalibleChars.length(); i++) {
            if (game.avalibleChars.charAt(i) == inputedChar) {
                game.avalibleChars.deleteCharAt(i);
            }
        }
        game.unhideenWord = unhiddentWord;
        game.usedChar += inputedChar;
    }

    static boolean isCharCorrect(GameSession game, char currenChar) {
        //Не работающаяя после компиляции версия кода
        for (int i = 0; i < game.avalibleChars.length(); i++) {
            if (game.avalibleChars.charAt(i) == currenChar) {
                return true;
            }
        }
        return false;

        //Можно избежать двойного вызова провеки наличия символа если возвращать не булево значение,
        // а int с номером символа.
        //В случае если символа нет возвращать некорректное значение, -1. Но поскольку мне делались замечания
        // по чистоте кода делаю так. Если не прав поправьте.
    }

}






