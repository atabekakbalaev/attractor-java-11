import java.util.Random;

/**
 * Homework15
 */
public class Homework16StepTwo {

    static String[] actions = { "Beginning of the day", "Get up from the bed with my left foot",
            "Get up from the bed with my right foot", "Falling from the bed", "Running on the alley",
            "Exercise on the balcony", "Prepare a strong coffee", "Preparing a hearty breakfast",
            "Getting yesterday's salad", "Flat tire", "Getting to work by walking", "Getting to work by bus",
            "Getting to work by my car", "At work on time", "Late for work", "The end" };

    public static void main(String[] args) {
        showAction(actions[0]);
    }

    static void showAction(String action) {
        System.out.println(action);
        switch (action) {
        case "Beginning of the day":
            System.out.println(getRandomAction(2, 8, actions[1], actions[2]));
            break;
        default:
            break;
        }
    }

    static String getRandomAction(int firstMax, int secondMax, String firstAction, String secondAction) {
        int n = new Random().nextInt(secondMax) + 1;
        if (n <= firstMax) {
            return firstAction;
        } else {
            return secondAction;
        }
    }
}