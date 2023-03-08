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
    static int counter;
    static char randomAlphabet;
    static char guessAlphabet;

    static boolean isGameContinue = true;
    static boolean isGuessingContinue = true;


    public static void main(String[] args) {

        Menu();
        menuInput = input.nextInt();
        while (menuInput != 5){
            if(menuInput == 1){
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
            }
            else if(menuInput == 2){
                do {
                    System.out.println("Guess The Alphabet\n------------------");
                    StartMenu();
                    if(startMenuInput == 1){
                        EasyAlphabetGuess();
                    }else if(startMenuInput == 2){
                        MediumAlphabetGuess();
                    }else if(startMenuInput == 3){
                        HardAlphabetGuess();
                    }else if(startMenuInput == 4){
                        isGameContinue = false;
                    }
                }while (isGameContinue);
            }
            else if(menuInput == 3){
                if(letterScore == 0)
                    System.out.println("Guess the Alphabet Score: Have not played yet");
                else
                    System.out.println("Guess The Alphabet Score: " + letterScore);
                if(numberScore == 0)
                    System.out.println("Guess the Number Score: Have not played yet");
                else
                    System.out.println("Guess The Number Score: " + numberScore);

                System.out.println("Total score: " + (numberScore + letterScore));
            }
            else if(menuInput == 4){
                ShowCredit();
            }else{
                System.out.println("Invalid option, Please try again");
            }
            Menu();
            menuInput = input.nextInt();
        }
        System.out.println("System closed");
    }
    static void Menu(){
        System.out.println("MENU\n____");
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
    static void GuessTheNumberInstructions(int difficulty){

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
    static void GuessTheAlphabetInstructions(int difficulty){
        if(difficulty == 1){
            chances = 2;
            System.out.println("1. Guess The vowel alphabet");
            System.out.println("2. You are allowed to make one guess a time");
            System.out.println("3. Each game has " + chances + " chances to guess the correct vowel");
            System.out.println("4. Once you have used up all your chances, you lose the game");
        }
        if(difficulty == 2){
            chances = 4;
            System.out.println("1. Guess The consonant alphabet");
            System.out.println("2. You are allowed to make one guess a time");
            System.out.println("3. Each game has " + chances + " chances to guess the correct vowel");
            System.out.println("4. Once you have used up all your chances, you lose the game");
        }
        if(difficulty == 3){
            chances = 5;
            System.out.println("1. Guess The alphabet");
            System.out.println("2. You are allowed to make one guess a time");
            System.out.println("3. Each game has " + chances + " chances to guess the correct vowel");
            System.out.println("4. Once you have used up all your chances, you lose the game");
        }
    }
    static void EasyNumberGuess(){
      NumberGuessGameEvents(1);
    }
    static void MediumNumberGuess(){
        NumberGuessGameEvents(2);
    }
    static void HardNumberGuess(){
       NumberGuessGameEvents(3);
    }
    static void EasyAlphabetGuess(){
        AlphabetGuessGameEvents(1);
    }
    static void MediumAlphabetGuess(){
        AlphabetGuessGameEvents(2);
    }
    static void HardAlphabetGuess(){
        AlphabetGuessGameEvents(3);
    }

    static void AlphabetGuessGameEvents(int difficulty){

        GuessTheAlphabetInstructions(difficulty);
        String letters = "";
        int scoreMultiplier = 0;
        if(difficulty == 1){
           letters = "aeiou";
           scoreMultiplier = 10;
        }else if(difficulty==2){
            letters = "bcdfghjklmnpqrstvwxyz";
            scoreMultiplier = 15;
        }else if(difficulty == 3){
            letters = "abcdefghIijklmnopqrstuvwxyz";
            scoreMultiplier = 15;
        }
        System.out.println("Good Luck!");

        guessAlphabet = letters.charAt(random.nextInt(letters.length()));

        while (chances > 0 || !isGameContinue){
            System.out.println("Enter a word: " + chances + " left.What is the alphabet.");
            System.out.print("===> ");
            guessAlphabet = input.next().charAt(0);
            if(guessAlphabet == randomAlphabet){
                System.out.println("Correct! You won the game!");
                letterScore += scoreMultiplier;
                isGameContinue = false;
            }else{
                System.out.println("Wrong guess!");
                chances--;
            }
        }
        if(chances == 0){
            System.out.println("You lost the game");
        }
    }

    static void NumberGuessGameEvents(int difficulty){
        GuessTheNumberInstructions(difficulty);
        System.out.println("Good Luck! ");
        int bound = 0;
        int scoreMultiplier = 0;
        if(difficulty == 1){
            scoreMultiplier = 10;
            bound = 15;
        }else if(difficulty == 2){
            scoreMultiplier = 15;
            bound = 20;
        }else if(difficulty == 3){
            scoreMultiplier = 20;
            bound = 40;
        }
        randomNumber = random.nextInt(bound);

        while (chances > 0 ||!isGameContinue){
            System.out.println("Enter your guess number from 1 to" + bound + "." + chances + " chances left.");
            System.out.print("==>");
            guessNumber = input.nextInt();

            if(guessNumber > randomNumber){
                System.out.println("Wrong! Your guess is higher.");
                counter++;
                chances--;
            }else if(guessNumber < randomNumber){
                System.out.println("Wrong! Your guess is lower");
                counter++;
                chances--;
            }else if(randomNumber == guessNumber){
                System.out.println("Correct! You've won the game with just " + counter + " times");
                counter++;
                numberScore += scoreMultiplier;
                isGameContinue = false;
            }
        }
        if(chances == 0){
            System.out.println("You lost the game!");
            counter = 0;
        }
    }

    static void ShowCredit(){
        Student s1 = new Student("Ismail Basar","Ekinci","200209054","Software Construction");
        System.out.println(s1.ToString());
    }
}