import java.util.*;

public class QuizGenerator1 {
    private static Map<String, List<Question>> quizzes = new HashMap<>();

    private static class Question {
        private String question;
        private List<String> options;
        private int correctAnswer;

        public Question(String question, List<String> options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void createQuiz(String topic) {
        quizzes.put(topic, new ArrayList<>());
    }

    public static void addQuestion(String topic, String question, List<String> options, int correctAnswer) {
        quizzes.get(topic).add(new Question(question, options, correctAnswer));
    }

    public static void takeQuiz(String topic) {
        List<Question> questions = quizzes.get(topic);
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (Question q : questions) {
            System.out.println(q.question);
            for (int i = 0; i < q.options.size(); i++) {
                System.out.println((i + 1) + ". " + q.options.get(i));
            }
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            if (userAnswer == q.correctAnswer) {
                score++;
            }
        }

        System.out.println("Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) 
    {
        createQuiz("java");
        addQuestion("java", "1. Which of the following is not an OOPS concept in Java?", Arrays.asList("Polymorphism", "Inheritance", "Compilation", "Encapsulation"), 3);
        addQuestion("java", "2. Which of these packages contains the exception Stack Overflow in Java?", Arrays.asList("java.io", "java.lang", "java.system", "java.util"), 2);

        takeQuiz("java");
    }
}
