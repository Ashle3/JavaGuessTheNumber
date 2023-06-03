import java.util.Random; //import the Random class
import java.util.Scanner; //import the Scanner class to read user input
import java.util.ArrayList; //import the Array List class

public class App {
    static int generateNumber(){
        Random randomNum = new Random(); //create Random object
        int n = randomNum.nextInt(101); //generates a random number between 1 and 100
        return n;
    }

    static int removeTry(int turn){ //removes a try from the tries variable
        int newTurn = turn - 1;
        return newTurn;
    }

    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println("Welcome to the Guess a Number game!");
        System.out.println();
        System.out.println("Rules: At the start of the game, a number between 1 and 100 will be randomly generated. Enter a number, and you will be told to guess either higher or lower. If you guess correctly, you win the game! You will have 10 tries to guess the number. If your 10 tries are up and you haven't correctly guessed the number, you get a game over. ");
        System.out.println();
        System.out.println("Let's begin!");
        System.out.println();

        Scanner object = new Scanner(System.in); //Creates a scanner object

        int number = generateNumber(); //generate the random number 
        int tries = 10; //defines the number of tries the player has
        int tryNumber = 0; //increases by 1 after each turn

        //define an array list to hold the try symbols
        ArrayList<String> lifeSymbols = new ArrayList<String>();
        //Populate the Array List with 10 *'s
        int i = 0;
        while(i < 10){
            lifeSymbols.add("* ");
            i++;
        }

        //define an Array List that will hold all of the user's guesses
        ArrayList<Integer> guesses = new ArrayList<Integer>();


        while (tries > 0){
            //print out the number of guesses you have left as a symbol
            for (i = 0; i < lifeSymbols.size(); i++){
                System.out.print(lifeSymbols.get(i));
            }

            System.out.println();
            System.out.println("^^ Guesses left: " + tries);
            System.out.println("Previous guesses: " + guesses);
            System.out.println("Enter a number: ");
            int userGuess = object.nextInt(); //reads the user's input
            guesses.add(userGuess);

            if (userGuess == number){
                System.out.println();
                System.out.println("You got it! The answer is " + number);
                System.out.println();
                tries = -1;
            } else if (userGuess < number){
                System.out.println();
                System.out.println("Higher");
                System.out.println();
                lifeSymbols.remove(0); //remove the first item in the Array List
                tries = removeTry(tries);
                tryNumber = tryNumber + 1; //increase the try number variable by 1
            } else if (userGuess > number){
                System.out.println();
                System.out.println("Lower");
                System.out.println();
                System.out.println();
                tries = removeTry(tries); 
                lifeSymbols.remove(0); //remove the first item in the Array List
                tryNumber = tryNumber + 1; //increase the try number variable by 1
            }

        } 

        object.close(); //closes the Scanner object

        if (tries == 0) {
            System.out.println("You've run out of turns. GAME OVER");
            System.out.println("The number was " + number);
            System.out.println();
            System.out.println("GAME SUMMARY: ");
            System.out.println("Total number of guesses: " + tryNumber);
            System.out.println("All guesses: " + guesses);
            System.out.println();
        } else if (tries == -1){
            System.out.println("Thank you for playing! ");
            System.out.println(); //insert game summary
            System.out.println("GAME SUMMARY: ");
            System.out.println("Total number of guesses: " + tryNumber);
            System.out.println("All guesses: " + guesses);
            System.out.println();
        }
    }
}
