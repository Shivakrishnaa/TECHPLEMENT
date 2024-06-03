import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class QuizQuestion
	{
		String question;
		ArrayList<String> options;
		int correctAnswer;

    public  QuizQuestion(String question, ArrayList<String> options, int correctAnswer)
	{
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
	}
    
public class QuizGenerator
	{
		public static void main(String[] args) 
			{
				ArrayList<QuizQuestion> quizQuestions = new ArrayList<>();

        // Add quiz questions with multiple-choice options and correct answers
				quizQuestions.add(new QuizQuestion("1. Who invented Java Programming?", 
                new ArrayList<>(List.of("A.  Guido van Rossum", "B. James Gosling", "C.  Dennis Ritchie", "D. Bjarne Stroustrup")), 1));
				quizQuestions.add(new QuizQuestion("2. Which component is used to compile, debug and execute the java programs?", 
                new ArrayList<>(List.of("A. JRE", "B. JIT ", "C. JDK ", "D. JVM")), 2));
				quizQuestions.add(new QuizQuestion("3. Which one of the following is not a Java feature?", 
                new ArrayList<>(List.of("A. Object-oriented", "B. Dynamic and Extensible ", "C. Portable ", "D. Use of pointers")), 3));
				quizQuestions.add(new QuizQuestion("4. Which of these cannot be used for a variable name in Java?", 
                new ArrayList<>(List.of("A. keyword", "B. identifier & keyword ", "C.  identifier ", "D. none of the mentioned")), 0));
        // Take the quiz
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        for (QuizQuestion question : quizQuestions) 
        {
            System.out.println(question.question);
            for (String option : question.options)
            {
                System.out.println(option);
            }
            System.out.print("Enter your answer (A, B, C, or D): ");
            String userAnswer = scanner.next();
            if (userAnswer.equalsIgnoreCase(question.options.get(question.correctAnswer).substring(0, 1))) 
            {
                score++;
            }
        }
        scanner.close();

        // Display quiz results
        System.out.println("Quiz completed! Your score: " + score + "/" + quizQuestions.size());
			}
}