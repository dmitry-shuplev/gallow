class Show {
    private static final String[][] PICTURES = {
            {
           "_",
           "|",
           "|",
           "|",
           "|",
           "----------"},
            { "_____",
            "|",
            "|",
            "|",
            "|",
            "----------"},
            { "__________",
            "|",
            "|",
            "|",
            "|",
            "----------"},
            { "__________",
            "|        |",
            "|",
            "|",
            "|",
            "----------"},
            {"__________",
            "|        |",
            "|        O",
            "|",
            "|",
            "----------"},
            { "__________",
            "|        |",
            "|        O",
            "|       /I\\",
            "|",
            "----------"},
            {       "__________",
                    "|        |",
                    "|        O",
                    "|       /I\\",
                    "|       / \\ ",
                    "----------"}
    };

    public static void showGallow(GameSession game) {
        for (int i = 0; i < 6; i++) {
            System.out.println(PICTURES[game.errors][i]);
        }
        System.out.println("Уже были использованы буквы:" + game.usedChar);
        System.out.println("Возможные варианты:" + game.avalibleChars);
        //эта строка используется при тестировании при игре ее нужо удалить
        System.out.println(game.hiddenWord);
        System.out.println(game.unhideenWord);
    }

public static void winGame(GameSession game){
    System.out.println("Вы угадали слово: " +  game.hiddenWord);
}
public static void loseGame(GameSession game){
    System.out.println("Вы проиграли!");
    System.out.println( "было загадно слово: " + game.hiddenWord);
}

public static void charError(){
    System.out.println("Вы ввели некорректный символ. Допустимы только символы из списка.");
}

}
