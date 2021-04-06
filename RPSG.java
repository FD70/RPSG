import java.util.*;

public class RPSG {

    static final int NUM_OF_ATTEMPTS = 10;

    static final int ROCK = 1;      // 001
    static final int SCISSORS = 2;  // 010
    static final int PAPER = 4;     // 100

    static int[] varSet = {ROCK, SCISSORS, PAPER};
    static String[] nameSet = {"ROCK", "SCISSORS", "PAPER"};


    static int oneOfVarSet() {
        return varSet[(int) (Math.random() * varSet.length)];
    }

    static void oneCycle(Scanner scanner) {

        // wait
        while (!scanner.hasNext());

        String myChoice = scanner.nextLine().toLowerCase();
        int myChoiceInt;

        if (        myChoice.startsWith("r")) {
            myChoiceInt = ROCK;

        } else if ( myChoice.startsWith("s")) {
            myChoiceInt = SCISSORS;

        } else if ( myChoice.startsWith("p")) {
            myChoiceInt = PAPER;

        } else {
            System.out.println("- - -");
            return;
        }

        int coChoiceInt = oneOfVarSet();

        System.out.printf("Me - %s\n", nameSet[myChoiceInt >> 1]);
        System.out.printf("Co - %s\n", nameSet[coChoiceInt >> 1]);

        if ((myChoiceInt ^ coChoiceInt) == 0) {

            System.out.println("draw");

        } else if ( ((myChoiceInt << 1) & (coChoiceInt + (coChoiceInt << varSet.length))) == 0) {
            System.out.println("lose");
        } else {
            System.out.println("win");
        }

    }

    public static void main(String[] args) {

        System.out.println("PRINT 'R', 'S' or 'P'");

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < NUM_OF_ATTEMPTS; i++) {
            System.out.printf("att - %s%n", i);
            oneCycle(scanner);
            System.out.print("\n");
        }

        System.out.println("END");
    }
}
