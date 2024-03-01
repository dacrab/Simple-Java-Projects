import java.util.Scanner;

public class QuizApplication {
    private static int score = 0;
    private static final int TOTAL_QUESTIONS = 5; // Total number of questions in the quiz
    private static final String[] QUESTIONS = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "What is the chemical symbol for water?",
            "True or False: Java is a programming language.",
            "How many continents are there in the world?"
    };
    private static final String[] ANSWERS = {"Paris", "Mars", "H2O", "True", "7"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You will be presented with " + TOTAL_QUESTIONS + " questions. Good luck!\n");

        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            System.out.println("Question " + (i + 1) + ": " + QUESTIONS[i]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equalsIgnoreCase(ANSWERS[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + ANSWERS[i]);
            }
            System.out.println();
        }

        System.out.println("Quiz complete!");
        System.out.println("Your score: " + score + "/" + TOTAL_QUESTIONS);

        scanner.close();
    }
}
