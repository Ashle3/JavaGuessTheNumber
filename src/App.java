import java.util.Random; //import the Random class
import java.util.Scanner; //import the Scanner class to read user input

public class App {
    static int generateNumber(){
        Random randomNum = new Random();

        int n = randomNum.nextInt(101); //generates a random number between 1 and 100

        return n;
    }

    static int removeTry(int turn){ //removes a try from the tries variable
        int newTurn = turn - 1;
        return newTurn;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the Guess a Number game!");
        System.out.println();
        System.out.println("Rules: At the start of the game, a number between 1 and 100 will be randomly generated. Enter a number, and you will be told to guess either higher or lower. If you guess correctly, you win the game! You will have 10 tries to guess the number. If your 10 tries are up and you haven't correctly guessed the number, you get a game over. ");
        System.out.println();
        System.out.println("Let's begin!");
        System.out.println();

        Scanner object = new Scanner(System.in); //Creates a scanner object

        int number = generateNumber(); //generate the random number 
        int tries = 10; //defines the number of tries the player has

        while (tries > 0){
            System.out.println("Guesses left: " + tries);
            System.out.println("Enter a number: ");
            int userGuess = object.nextInt(); //reads the user's input

            if (userGuess == number){
                System.out.println("You got it! The answer is " + number);
                tries = -1;
            } else if (userGuess < number){
                System.out.println();
                System.out.println("Higher");
                System.out.println();
                tries = removeTry(tries);
            } else if (userGuess > number){
                System.out.println();
                System.out.println("Lower");
                System.out.println();
                tries = removeTry(tries);
            }
        } 
        
        object.close(); //closes the Scanner object

        if (tries == 0) {
            System.out.println("You've run out of turns. GAME OVER");
            System.out.println("The number was " + number);
        } else if (tries == -1){
            System.out.println("Thank you for playing! ");
        }
    }
}
