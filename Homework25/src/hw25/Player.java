package hw25;

import java.util.Arrays;

public class Player {
    private Type currentChoice;
    private int drawCount;
    private int winCount;
    private int loseCount;
    private Type[] choices;
    private String name;

    public Player(String name, int totalGames) {
        this.choices = new Type[totalGames];
        this.drawCount = 0;
        this.winCount = 0;
        this.loseCount = 0;
        this.name = name;
    }
    public void increaseDrawCount() {
        this.drawCount++;
    }
    public void increaseWinCount() {
        this.winCount++;
    }
    public void increaseLoseCount() {
        this.loseCount++;
    }
    public void printChoices() {
        System.out.println(Arrays.toString(this.choices));
    }

    public void printPlayerStatus() {
        String headerFormat = "|%10s|%12s|%10s|%12s|%15s|\n";
        String contentFormat = "|%10s|%12s|%10s|%12s|%15.2f|\n";
        String divider = "+" + "-".repeat(63) + "+";
        System.out.println(divider);
        System.out.format(headerFormat, "Wins", "Loses", "Draws", "Total games", "Win rate");
        System.out.println(divider);
        System.out.format(contentFormat, this.winCount, this.loseCount, this.drawCount,
                this.getTotalGameCount(), this.getWinRate());
        System.out.println(divider);
    }
    public int getTotalGameCount() {
        return this.drawCount + this.loseCount + this.winCount;
    }
    public double getWinRate() {
        return this.getTotalGameCount() != 0 ? (double) this.winCount / this.getTotalGameCount() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getCurrentChoice() {
        return currentChoice;
    }

    public void setCurrentChoice(Type currentChoice, int index){
        this.currentChoice = currentChoice;
        this.choices[index] = currentChoice;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public void setDrawCount(int drawCount) {
        this.drawCount = drawCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    public Type[] getChoices() {
        return choices;
    }

    public void setChoices(Type[] choices) {
        this.choices = choices;
    }
}
