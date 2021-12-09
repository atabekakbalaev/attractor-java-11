package hw25;

public class Main {

    public static void main(String[] args) {
        final int totalGames = 6;
        Player human = new Player("Human", totalGames);
        Player comp = new Player("Computer", totalGames);
        Player[] players = {human, comp};
        Game game = new Game(players, totalGames);
        game.startGame();
        game.checkScore(human, comp);
        game.printGameResults(human, comp);
    }
}
