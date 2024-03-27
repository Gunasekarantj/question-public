import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class question {
    public static void main(String[] args) {
        int maxAttempts = 3;
        int initialScore = 0;
        int finalScore = askQuestions(maxAttempts, initialScore);
        System.out.println("Your final score is: " + finalScore);
    }

    static int askQuestions(int attempts, int score) {
        List<String> answerList = getAnswerList();
        List<String> questionList = getQuestionList();
        int count = 0;
        for(String eachQuestion: questionList){
            attempts = 3;
            while (attempts > 0) {
                Scanner scanner = new Scanner(System.in);
                System.out.println(eachQuestion);
                String userAnswer = scanner.nextLine();

                if (userAnswer.equals(answerList.get(count))) {
                    System.out.println("Correct answer! You earned 1 mark.");
                    score++;
                    break; // Exit the loop on correct answer
                } else {
                    System.out.println("Wrong answer. You have " + attempts + " attempts remaining.");
                    attempts--;
                }
            }
            if (attempts == 0) {
                System.out.println("You've reached the maximum number of attempts. " +
                        "Your final score is: " + score + ". The correct answer is: " + answerList.get(count));
            }
            count++;
        }
        return score;
    }

    private static List<String> getAnswerList() {
        List<String> answerList = new ArrayList<>();
        answerList.add("HashSet<Character> charSet = new HashSet<>()");
        answerList.add("s.toCharArray()");
        return answerList;
    }

    private static List<String> getQuestionList() {
        List<String> questionList = new ArrayList<>();
        questionList.add("How to create a hashset of characters with variable name charSet in Java?");
        questionList.add("How to convert the string 's' to a character array in Java?");
        return questionList;
    }
}
