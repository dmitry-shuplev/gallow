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
        System.out.println(game.usedChar);
        System.out.println(game.hiddenWord);
        System.out.println(game.unhideenWord);
    }


}
