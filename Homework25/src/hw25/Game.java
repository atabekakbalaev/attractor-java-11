package hw25;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player[] players;
    private int currentGameNumber;
    private int totalGames;

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
                    choice = new Random().nextInt(3) + 1;
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
                    humanChoices[i].equals(Type.PAPER) && compChoices[i].equals(Type.ROCK) ||
                    humanChoices[i].equals(Type.ROCK) && compChoices[i].equals(Type.SCISSORS) ||
                    humanChoices[i].equals(Type.SCISSORS) && compChoices[i].equals(Type.PAPER)) {
                human.increaseWinCount();
                comp.increaseLoseCount();
            } else {
                human.increaseLoseCount();
                comp.increaseWinCount();
            }
        }
    }
    public Type getTypeByNumber(int number) {
        Type type = null;
        switch (number) {
            case 1:
                type = Type.ROCK;
                break;
            case 2:
                type = Type.PAPER;
                break;
            case 3:
                type = Type.SCISSORS;
                break;
            default:
                System.out.println("No such choice.");
                type = null;
        }
        return type;
    }
    public void showMenu() {
        String menu = "Choose your option(1-3)\n" +
                "1. Rock\n" +
                "2. Papers\n" +
                "3. Scissors\n";
        System.out.print(menu);
    }
    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while(!(option >= 1 && option <= 3)) {
            this.showMenu();
            System.out.print("Your choice: ");
            try {
                option = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]", ""));
            } catch (Exception e) {
                System.out.println("Input error! Enter a number between 1 and 3 - " + e.getMessage());
            }
        }

        return option;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getCurrentGameNumber() {
        return currentGameNumber;
    }

    public void setCurrentGameNumber(int currentGameNumber) {
        this.currentGameNumber = currentGameNumber;
    }
}
