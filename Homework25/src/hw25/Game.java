package hw25;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Player[] players;
    private int currentGameNumber;
    private final int totalGames;
    private int level;

    public Game(Player[] players, int totalGames) {
        this.players = players;
        this.totalGames = totalGames;
        this.level = 1;
    }
    public void startGame() {
        this.level = this.getGameLevel();
        while (this.currentGameNumber < 6) {
            for (Player p : players) {
                int choice;
                if (p.getName().equals("Human")) {
                    choice = this.getUserInput();
                } else {
                    choice = new Random().nextInt(this.getTypeLength()) + 1;
                }
                Type type = getTypeByNumber(choice);
                p.setCurrentChoice(type, this.currentGameNumber);
                System.out.println("Game-" + (this.currentGameNumber + 1) + " - " + p.getName() +
                        " has chosen: " + p.getCurrentChoice());
            }
            this.currentGameNumber++;
        }
    }
    public int getTypeLength() {
        return this.level == 1 ? 3 : 5;
    }
    public int getGameLevel() {
        int level = 0;
        Scanner scanner = new Scanner(System.in);
        while(level < 1 || level > 2) {
            String gameLevelMenu = "Choose the game level(1 - easy or 2 - hard): ";
            System.out.print(gameLevelMenu);
            try {
                String s = scanner.nextLine();
                if (isAPositiveIntegerWithinRange(s, 1, 2)) level = Integer.parseInt(s);
                else {
                    throw new Exception("The number is invalid!");
                }
            } catch (Exception e) {
                System.out.println("Input error! Enter 1 or 2 only " + " - " + e.getMessage());
            }
        }
        return level;
    }
    public void printGameResults(Player human, Player comp) {
        if (human.getWinRate() > comp.getWinRate()) {
            System.out.println("\n\nThe human has won!!!");
            human.printPlayerStatus();
        } else if (human.getWinRate() < comp.getWinRate()) {
            System.out.println("\n\nThe computer has won!!!");
            comp.printPlayerStatus();
        } else {
            System.out.println("\n\nIts a tie game!!!");
            human.printPlayerStatus();
            comp.printPlayerStatus();
        }
        System.out.println("\nThese are the choices of players: ");
        human.printChoices();
        comp.printChoices();
    }
    public void checkScore(Player human, Player comp) {
        Type[] humanChoices = human.getChoices();
        Type[] compChoices = comp.getChoices();
        for (int i = 0; i < this.totalGames; i++) {
            if (humanChoices[i].equals(compChoices[i])) {
                human.increaseDrawCount();
                comp.increaseDrawCount();
            } else if (
                    // Бумага - побеждает камень и Спока
                    humanChoices[i].equals(Type.PAPER) && compChoices[i].equals(Type.ROCK) ||
                    humanChoices[i].equals(Type.PAPER) && compChoices[i].equals(Type.SPOCK) ||
                            // Камень - побеждает ящерицу и ножницы
                    humanChoices[i].equals(Type.ROCK) && compChoices[i].equals(Type.LIZARD) ||
                    humanChoices[i].equals(Type.ROCK) && compChoices[i].equals(Type.SCISSORS) ||
                            // Ножницы - побеждают бумагу и ящерицу
                    humanChoices[i].equals(Type.SCISSORS) && compChoices[i].equals(Type.PAPER) ||
                    humanChoices[i].equals(Type.SCISSORS) && compChoices[i].equals(Type.LIZARD) ||
                            // Ящерица - побеждает Спока и бумагу
                    humanChoices[i].equals(Type.LIZARD) && compChoices[i].equals(Type.SPOCK) ||
                    humanChoices[i].equals(Type.LIZARD) && compChoices[i].equals(Type.PAPER) ||
                            // Спок - побеждает ножницы и камень
                    humanChoices[i].equals(Type.SPOCK) && compChoices[i].equals(Type.SCISSORS) ||
                    humanChoices[i].equals(Type.SPOCK) && compChoices[i].equals(Type.ROCK)
            ) {
                human.increaseWinCount();
                comp.increaseLoseCount();
            } else {
                human.increaseLoseCount();
                comp.increaseWinCount();
            }
        }
    }
    public Type getTypeByNumber(int number) {
        Type type;
        switch (number) {
            case 1 -> type = Type.ROCK;
            case 2 -> type = Type.PAPER;
            case 3 -> type = Type.SCISSORS;
            case 4 -> type = Type.LIZARD;
            case 5 -> type = Type.SPOCK;
            default -> {
                System.out.println("No such choice.");
                type = null;
            }
        }
        return type;
    }
    public void showMenu() {
        String menu1 = """
                Choose your option(1-3)
                1. Rock
                2. Papers
                3. Scissors
                """;
        String menu2 = """
                Choose your option(1-5)
                1. Rock
                2. Papers
                3. Scissors
                4. Lizard
                5. Spock
                """;
        System.out.print(this.level == 1 ? menu1 : menu2);
    }
    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int option = 0, lower = 1;
        int upper = this.getTypeLength();
        while(!(option >= lower && option <= upper)) {
            this.showMenu();
            System.out.print("Your choice: ");
            try {
                String s = scanner.nextLine();
                if (isAPositiveIntegerWithinRange(s, lower, upper)) {
                    option = Integer.parseInt(s);
                } else throw new Exception("The number is invalid!");
            } catch (Exception e) {
                System.out.println("Input error! Enter a number between 1 and " + upper + " - " + e.getMessage());
            }
        }

        return option;
    }
    public static boolean isAPositiveIntegerWithinRange(String str, int start, int end) {
        if(str.matches("\\d+")) {
            int n = Integer.parseInt(str);
            return n >= start && n <= end;
        } else return false;
    }
}
