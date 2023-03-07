import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random random = new Random();
    static Scanner input = new Scanner(System.in);

    static int randomNumber;
    static int guessNumber;
    static int chances;
    static int numberScore;
    static int letterScore;
    static int menuInput;
    static int startMenuInput;
    static int difficulty;
    static int counter = 0;
    static boolean isGameContinue = true;
    static boolean isGuessingContinue = true;


    public static void main(String[] args) {

        Menu();
        menuInput = input.nextInt();
        while (menuInput != 5){
            do{
                System.out.println("Guess The Number\n---------------");
                StartMenu();
                if(startMenuInput == 1){
                    EasyNumberGuess();
                }else if(startMenuInput == 2){
                    MediumNumberGuess();
                }else if(startMenuInput == 3) {
                    HardNumberGuess();
                }else if(startMenuInput == 4){
                    isGameContinue = false;
                }
            } while (isGameContinue);
            Menu();
            menuInput = input.nextInt();
        }
        System.out.println("System closed");
    }
    static void Menu(){
        System.out.println("1. Guess the Number.");
        System.out.println("2. Guess the Alphabet.");
        System.out.println("3. High Score.");
        System.out.println("4. Credit.");
        System.out.println("5. Exit");
        System.out.print("Enter you choice: ");
    }

    static void StartMenu(){
        System.out.println("Start Menu\n----------");
        System.out.println("Select Difficulty Level");
        System.out.println("1. Easy\n2. Medium\n3. Hard\n4. Return to Main Menu");
        System.out.print("===>");
        startMenuInput = input.nextInt();
    }
    static void Instructions(int difficulty){

        if(difficulty == 1)
            chances = 5;
        else if(difficulty == 2)
            chances = 4;
        else if(difficulty == 3)
            chances = 3;

        System.out.println("Instructions: ");
        System.out.println("1. Guess the number based on the gaven range.");
        System.out.println("2. You are allowed to make one guess at a time.");
        System.out.println("3. Each game has " + chances + " chances to guess the correct number.");
        System.out.println("4. Once you have used up all your chances, you lose the game.");
    }

    static void EasyNumberGuess(){
        Instructions(1);
        System.out.println("Good Luck! ");
        System.out.println("Easy:");
        chances = 5;
        randomNumber = random.nextInt(15);

        while (isGameContinue){
            System.out.println("Enter your guess number from 1 to 15. " + chances + " chances left.");
            System.out.print("==>");
            guessNumber = input.nextInt();

            if(guessNumber > randomNumber){
                System.out.println("Wrong! Your guess is higher.");
                chances--;
            }else if(guessNumber < randomNumber){
                System.out.println("Wrong! Your guess is lower");
                chances--;
            }else if(randomNumber == guessNumber){
                System.out.println("Correct! You've won the game with just " + chances + " times");
                numberScore += 5;
                isGameContinue = false;
            }else if(chances == 0){
                System.out.println("You lost the game!");
                isGameContinue = false;
            }
        }
    }
    static void MediumNumberGuess(){
        Instructions(2);
        System.out.println("Good Luck! ");
        System.out.println("Medium:");
        chances = 5;
        randomNumber = random.nextInt(20);

        while (isGameContinue){
            System.out.println("Enter your guess number from 1 to 20. " + chances + " chances left.");
            System.out.print("==>");
            guessNumber = input.nextInt();

            if(guessNumber > randomNumber){
                System.out.println("Wrong! Your guess is higher.");
                chances--;
            }else if(guessNumber < randomNumber){
                chances--;
                System.out.println("Wrong! Your guess is lower");
            }else if(randomNumber == guessNumber){
                System.out.println("Correct! You've won the game with just"  + chances + " times");
                numberScore += 10;
                isGameContinue = false;
            }else if(chances == 0){
                System.out.println("You lost the game!");
                isGameContinue = false;
            }
        }
    }
    static void HardNumberGuess(){
        Instructions(3);
        System.out.println("Good Luck! ");
        System.out.println("hard:");
        chances = 5;
        randomNumber = random.nextInt(40);

        while (isGameContinue){
            System.out.println("Enter your guess number from 1 to 40. " + chances + " chances left.");
            System.out.print("==>");
            guessNumber = input.nextInt();

            if(guessNumber > randomNumber){
                System.out.println("Wrong! Your guess is higher.");
                chances--;
            }else if(guessNumber < randomNumber){
                chances--;
                System.out.println("Wrong! Your guess is lower");
            }else if(randomNumber == guessNumber){
                System.out.println("Correct! You've won the game with just" + chances + "times");
                numberScore += 15;
                isGameContinue = false;
            }else if(chances == 0){
                System.out.println("You lost the game!");
                isGameContinue = false;
            }
        }
    }

}