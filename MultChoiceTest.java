/**********
MultChoiceTest.java, a program to administer a multiple choice test via command line I/O.
    -Wesley Chavez, 10/4/16

This class holds the main method and creates an array of QuestionItem objects to ask the user.
The user is informed of per-question correctness, and accuracy is relayed at the end of the
test with a percentage.  Users can only enter numbers 1-4 as input to the questions or
they will be prompted to do so before moving on to the next question.
**********/



import java.util.Scanner;                               //For command line user input
public class MultChoiceTest
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);     //For user's answers
        final int numQuestions = 5;                     //Total number of questions
        boolean correct;                                //Current correct designation
        int correctTotal = 0;                           //Running sum of correct answers
        
        QuestionItem[] questions = new QuestionItem[numQuestions];      //Instantiate array of question items
        
        //Initialize string array of answers, associated question, and correct answer
        //Correct answers are 1-indexed
        String[] ans0 = {"Abraham Lincoln", "George Washington", "Stephen Colbert", "The Pillsbury Doughboy"};    
        questions[0] = new QuestionItem("Who was the first president of the United States of America?",ans0,2);
        String[] ans1 = {"Franklin Pierce", "Warren Harding", "William Howard Harrison", "Gerald Ford"};    
        questions[1] = new QuestionItem("Who was NOT a president of the United States of America?",ans1,3);
        String[] ans2 = {"Matt Damon", "Kevin Bacon", "Tina Fey", "Jerry Seinfeld"};    
        questions[2] = new QuestionItem("Who co-starred with Leonardo DiCaprio in \"The Departed\"(2006)?",ans2,1);
        String[] ans3 = {"6", "8", "9", "10"};    
        questions[3] = new QuestionItem("How many prime numbers exist below 30?",ans3,4);
        String[] ans4 = {"1", "2", "3", "4"};    
        questions[4] = new QuestionItem("How many states in the U.S. have one syllable?",ans4,1);
        

        //Loop through questions
        for (int i = 0; i < numQuestions; i++)
        {
            System.out.println("---------------------------------------------"); //For nice display
            questions[i].displayQuestionAndAnswers();       //Show question and answers on screen
            while(true)                                     //Look for break statements to exit this loop
            {
                String userAnswer = userInput.nextLine();   //Read user input (until return character)
            
                //Make sure user enters 1,2,3, or 4.  This is the only way to exit the "while(true)" loop and move to next question.
                if (userAnswer.equals("1") || userAnswer.equals("2") || userAnswer.equals("3") || userAnswer.equals("4"))
                {
                    int userAnswerInt = Integer.parseInt(userAnswer);   //Convert user string to integer
                    correct = questions[i].isCorrect(userAnswerInt);    //QuestionItem method to determine if answer is correct.
                    if(correct == true)                                 //Correct
                    {
                        correctTotal++;                                 //Add 1 to correct total
                        System.out.println("Correct :)");
                        break;                                          //Exit the "while(true)" loop
                    }
                    else                                                //Incorrect
                    {
                        System.out.println("Incorrect :(");
                        break;                                          //Exit the "while(true)" loop
                    }
                }
                System.out.println("Enter a number 1-4");               //Prompt the user to enter valid answer
            }
        }
        //After all questions have valid answers, cast running sum to a float and display accuracy to user
        System.out.println("**********************");
        System.out.println("You got " + (double)correctTotal*100/numQuestions  + "% correct");
        System.out.println("**********************");
    }
}
