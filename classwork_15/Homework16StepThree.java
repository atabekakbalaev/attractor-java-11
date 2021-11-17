import java.util.Random;

/**
 * Homework15
 */
public class Homework16StepThree {

    static String[] actions = { "Beginning of the day", "Get up from the bed with my left foot",
            "Get up from the bed with my right foot", "Falling from the bed", "Running on the alley",
            "Exercise on the balcony", "Prepare a strong coffee", "Preparing a hearty breakfast",
            "Getting yesterday's salad", "Flat tire", "Getting to work by walking", "Getting to work by bus",
            "Getting to work by my car", "At work on time", "Late for work", "The end" };

    public static void main(String[] args) {
        System.out.printf(" # | %s\n", "Action");
        System.out.printf("%s|%s\n", "-".repeat(3), "-".repeat(35));
        showAction(actions[0]);
    }

    static void showAction(String action) {
        System.out.printf(" . | %s\n", action);
        switch (action) {
        case "Beginning of the day":
            showAction(getRandomAction(2, 8, actions[1], actions[2]));
            break;
        case "Get up from the bed with my left foot":
            showAction(getRandomAction(7, 10, actions[3], actions[4]));
            break;
        case "Get up from the bed with my right foot":
            showAction(getRandomAction(4, 6, actions[4], actions[5]));
            break;
        case "Falling from the bed":
        case "Running on the alley":
            showAction(getRandomAction(8, 12, actions[6], actions[7]));
            break;
        case "Exercise on the balcony":
            showAction(getRandomAction(1, 4, actions[7], actions[8]));
            break;
        case "Prepare a strong coffee":
        case "Preparing a hearty breakfast":
        case "Getting yesterday's salad":
            showAction(getRandomAction(2, 5, actions[9], actions[12]));
            break;
        case "Flat tire":
            showAction(getRandomAction(2, 8, actions[10], actions[11]));
            break;
        case "Getting to work by walking":
            showAction(getRandomAction(2, 8, actions[13], actions[14]));
            break;
        case "Getting to work by bus":
            showAction(getRandomAction(1, 2, actions[13], actions[14]));
            break;
        case "Getting to work by my car":
            showAction(getRandomAction(5, 8, actions[13], actions[14]));
            break;
        case "At work on time":
        case "Late for work":
            showAction(getRandomAction(1, 1, actions[15], actions[15]));
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