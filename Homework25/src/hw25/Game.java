package hw25;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Player[] players;
    private int currentGameNumber;
    private final int totalGames;

    public Game(Player[] players, int totalGames) {
        this.players = players;
        this.totalGames = totalGames;
    }
    public void startGame() {
        while (this.currentGameNumber < 6) {
            for (Player p : players) {
                int choice;
                if (p.getName().equals("Human")) {
                    choice = this.getUserInput();
                } else {
                    choice = new Random().nextInt(5) + 1;
                }
                Type type = getTypeByNumber(choice);
                p.setCurrentChoice(type, this.currentGameNumber);
                System.out.println("Game-" + (this.currentGameNumber + 1) + " - " + p.getName() +
                        " has chosen: " + p.getCurrentChoice());
            }
            this.currentGameNumber++;
        }
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
        System.out.print(menu2);
    }
    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int option = 0, lower = 1, upper = 5;
        while(!(option >= lower && option <= upper)) {
            this.showMenu();
            System.out.print("Your choice: ");
            try {
                option = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]", ""));
            } catch (Exception e) {
                System.out.println("Input error! Enter a number between 1 and " + upper + " - " + e.getMessage());
            }
        }

        return option;
    }
}
