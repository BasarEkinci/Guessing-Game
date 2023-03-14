import java.util.Random;
import java.util.Scanner;

public class EasyNumberGuess {

    private Scanner input = new Scanner(System.in);
    private int randomNumber;
    private int chances = 5;
    private int guessedNumber;
    private Random random;

    public EasyNumberGuess(){
        random = new Random();
        randomNumber = random.nextInt(15);
    }
    public void Instructions(){
        System.out.println("1. Guess the number given range.");
        System.out.println("2. You are allowed to make one guess at a time.");
        System.out.println("3. Each game has 5 chances to guess the correct number.");
        System.out.println("4. Once you have used up all your chances, you lose the game.");
        System.out.println("Good Luck!");
    }

    public void GuessNumber(){
        do{
            System.out.print("Enter guess number from 1 to 15. " + chances + " chances left.");
            guessedNumber = input.nextInt();
            if(guessedNumber == randomNumber){
                System.out.println("Correct!. You've won the game with just " + (5 - chances) + " times.");
            }
            if(guessedNumber > randomNumber){
                System.out.println("Wrong!. Your guess was too high.");
                chances--;
            }
            if(guessedNumber < randomNumber){
                System.out.println("Wrong!. Your guess was too high. ");
                chances--;
            }
            if(chances == 0){
                System.out.println("You lost the game!");
            }

        }while (guessedNumber != randomNumber && chances != 0);
    }



}
