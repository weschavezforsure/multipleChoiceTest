/**********
QuestionItem.java, a class to store necessary information about
a multiple choice question, display the question, and determine
correctness.
    -Wesley Chavez, 10/4/16
**********/

public class QuestionItem
{
    private String question;    //The question to be asked
    private String[] answers;   //An array of possible answers
    private int correctAnswer;  //The correct answer, 1-indexed

    //Constructor
    public QuestionItem(String ques, String[] ans, int corrAns)
    {
        question = ques;
        answers = ans;
        correctAnswer = corrAns;
    }

    //Displays the question and possible answers nicely
    public void displayQuestionAndAnswers()
    {
        System.out.println(question);   //Print question
        int size =  answers.length;     
        for (int i = 0; i < size; i++)  //Print string array of answers
        {
            System.out.format("%d. %s%n",i+1,answers[i]);   //Print answers on separate lines
        }
    }

    //Determines correctness of input parameter "guess", pretty straightforward
    public boolean isCorrect(int guess)
    {
        if(guess == correctAnswer)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
