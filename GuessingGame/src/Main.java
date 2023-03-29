import java.util.Random;
import java.util.Scanner;
public class Main {

    //Global variables
    static Random random = new Random();
    static Scanner input = new Scanner(System.in);
    static int randomNumber;
    static int guessNumber;
    static int wrongRight;
    static int guessTheNumberScore;
    static int guessTheAlphabetScore;
    static int menuInput;
    static int startMenuInput;
    static int counter;
    static String randomAlphabet;
    static String guessAlphabet;
    static boolean isGameContinue = true;



    public static void main(String[] args) {

        Menu();
        menuInput = input.nextInt();
        while (menuInput != 5){
            switch (menuInput){
                case 1://Guess The Number
                    do{
                        System.out.println("---------------\nGuess The Number\n---------------");
                        StartMenu();
                        if(startMenuInput == 1){//Guess the Number Easy
                            randomNumber = random.nextInt(15);
                            counter = 0;
                            wrongRight = 5;
                            GuessTheNumberInstructions(1);
                            System.out.println("\nGood Luck!");
                            System.out.println("Easy:");

                            do{
                                System.out.println("Enter guess number from 1 to 15. " + wrongRight + " chances left");
                                System.out.print("Guess number: ");
                                guessNumber = input.nextInt();

                                if(guessNumber == randomNumber){
                                    counter++;
                                    guessTheNumberScore += 5;
                                    System.out.println("Correct!You've won the game just " + counter + " times.\n");
                                }else if(guessNumber < randomNumber){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong!Your guess was too low\n");
                                }else if (guessNumber > randomNumber){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong!Your guess was too high\n");
                                }

                                if(wrongRight == 0){
                                    System.out.println("\nYou lost the game! ");
                                }
                            }while (wrongRight != 0 && guessNumber != randomNumber);

                        }else if(startMenuInput == 2){//Guess the number : medium
                            randomNumber = random.nextInt(20);
                            wrongRight = 4;
                            counter = 0;
                            GuessTheNumberInstructions(2);
                            System.out.println("\nGood Luck!");
                            System.out.println("Medium:");

                            do{
                                System.out.println("Enter guess number from 1 to 20. " + wrongRight + " chances left");
                                System.out.print("Guess number: ");
                                guessNumber = input.nextInt();
                                if(guessNumber == randomNumber){
                                    counter++;
                                    guessTheNumberScore += 10;
                                    System.out.println("Correct!You've won the game just " + counter + " times.\n");
                                }else if(guessNumber < randomNumber){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong!\n");
                                }else if (guessNumber > randomNumber){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong!\n");
                                }

                                if(wrongRight == 0){
                                    System.out.println("\nYou lost the game! ");
                                }
                            }while (wrongRight != 0 && guessNumber != randomNumber);

                        }else if(startMenuInput == 3) {//Guess the Number : Hard
                            randomNumber = random.nextInt(40);
                            wrongRight = 4;
                            counter = 0;
                            GuessTheNumberInstructions(3);
                            System.out.println("\nGood Luck!");
                            System.out.println("Medium:");

                            do{
                                System.out.println("Enter guess number from 1 to 40. " + wrongRight + " chances left");
                                System.out.print("Guess number: ");
                                guessNumber = input.nextInt();
                                if(guessNumber == randomNumber){
                                    counter++;
                                    guessTheNumberScore += 15;
                                    System.out.println("Correct!You've won the game just " + counter + " times.\n");
                                }else if(guessNumber < randomNumber){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong!\n");
                                }else if (guessNumber > randomNumber){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong!\n");
                                }

                                if(wrongRight == 0){
                                    System.out.println("\nYou lost the game! ");
                                }
                            }while (wrongRight != 0 && guessNumber != randomNumber);
                        }else if(startMenuInput == 4){
                            System.out.println("--Returning Main Menu--\n-----------------------");
                        }
                        else{
                            System.out.println("Invalid input. Please try again");
                        }
                    } while (startMenuInput != 4);
                    break;
                case 2://Guess The Alphabet
                    int guessIndex;
                    int randomAlphabetIndex;
                    do {
                        System.out.println("---------------\nGuess The Alphabet\n---------------------");
                        StartMenu();
                        if(startMenuInput == 1){
                            counter = 0;
                            String[] vowels = {"a","e","i","o","u"};
                            randomAlphabet = vowels[random.nextInt(vowels.length)];
                            randomAlphabetIndex = GetIndex(vowels,randomAlphabet);
                            GuessTheAlphabetInstructions(1);

                            do{
                                System.out.println("Enter a word: " + wrongRight + " chances left. What is the alphabet?");
                                guessAlphabet = input.next().toLowerCase();
                                guessIndex = GetIndex(vowels,guessAlphabet);
                                if(guessIndex == randomAlphabetIndex){
                                    System.out.println("Correct! You've won the game with just " + counter + " times.");
                                }else if(guessIndex < randomAlphabetIndex){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong! Your guess was too low");
                                }else if(guessIndex > randomAlphabetIndex){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong! Your guess was too high");
                                }

                                if(wrongRight == 0){
                                    System.out.println("You lost the game!\n");
                                }

                            }while (wrongRight != 0 && guessIndex != randomAlphabetIndex);
                        }else if(startMenuInput == 2){
                            counter = 0;
                            String[] consonants = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
                            randomAlphabet = consonants[random.nextInt(consonants.length)];
                            randomAlphabetIndex = GetIndex(consonants,randomAlphabet);
                            GuessTheAlphabetInstructions(2);

                            do{
                                System.out.println("Enter a word: " + wrongRight + " chances left. What is the alphabet?");
                                guessAlphabet = input.next().toLowerCase();
                                guessIndex = GetIndex(consonants,guessAlphabet);
                                if(guessIndex == randomAlphabetIndex){
                                    System.out.println("Correct! You've won the game with just " + counter + " times.");
                                }else if(guessIndex < randomAlphabetIndex){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong! Your guess was too low");
                                }else if(guessIndex > randomAlphabetIndex){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong! Your guess was too high");
                                }

                                if(wrongRight == 0){
                                    System.out.println("You lost the game!\n");
                                }

                            }while (wrongRight != 0 && guessIndex != randomAlphabetIndex);
                        }else if(startMenuInput == 3){
                            counter = 0;
                            String[] consonants = {"a","b", "c", "d","e", "f", "g", "h","i", "j", "k", "l", "m", "n","o", "p", "q", "r", "s", "t","u", "v", "w", "x", "y", "z"};
                            randomAlphabet = consonants[random.nextInt(consonants.length)];
                            randomAlphabetIndex = GetIndex(consonants,randomAlphabet);
                            GuessTheAlphabetInstructions(3);

                            do{
                                System.out.println("Enter a word: " + wrongRight + " chances left. What is the alphabet?");
                                guessAlphabet = input.next().toLowerCase();
                                guessIndex = GetIndex(consonants,guessAlphabet);
                                if(guessIndex == randomAlphabetIndex){
                                    System.out.println("Correct! You've won the game with just " + counter + " times.");
                                }else if(guessIndex < randomAlphabetIndex){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong! Your guess was too low");
                                }else if(guessIndex > randomAlphabetIndex){
                                    wrongRight--;
                                    counter++;
                                    System.out.println("Wrong! Your guess was too high");
                                }

                                if(wrongRight == 0){
                                    System.out.println("You lost the game!\n");
                                }

                            }while (wrongRight != 0 && guessIndex != randomAlphabetIndex);
                        }else if(startMenuInput == 4){
                            System.out.println("--Returning Main Menu--\n-----------------------");
                        }else
                        {
                            System.out.println("Invalid input. Please try again");
                        }
                    }while (startMenuInput != 4);
                    break;
                case 3://Show Score
                    if(guessTheAlphabetScore == 0)
                        System.out.println("Guess the Alphabet Score: Have not played yet");
                    else
                        System.out.println("Guess The Alphabet Score: " + guessTheAlphabetScore);
                    if(guessNumber == 0)
                        System.out.println("Guess the Number Score: Have not played yet");
                    else
                        System.out.println("Guess The Number Score: " + guessTheNumberScore);

                    System.out.println("Total score: " + (guessTheAlphabetScore + guessTheNumberScore));//Total Score
                    break;
                case 4://Show Credit
                    ShowCredit();
                    break;
                default://Invalid input
                    System.out.println("Invalid option, Please try again");
                    break;
            }
            Menu();
            menuInput = input.nextInt();
        }
        System.out.println("--<System closed>--");
    }

    static int GetIndex(String[] arr, String obj){
        for(int i = 0; i < arr.length;i++){
            if(arr[i].equals(obj)){
                return i;
            }
        }
        return -1;
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

        if(difficulty == 1)//According to the difficulty to choose the wrong right
            wrongRight = 5;
        else if(difficulty == 2)
            wrongRight = 4;
        else if(difficulty == 3)
            wrongRight = 3;

        System.out.println("Instructions: ");
        System.out.println("1. Guess the number based on the gaven range.");
        System.out.println("2. You are allowed to make one guess at a time.");
        System.out.println("3. Each game has " + wrongRight + " chances to guess the correct number.");
        System.out.println("4. Once you have used up all your chances, you lose the game.");
    }
    static void GuessTheAlphabetInstructions(int difficulty){
        if(difficulty == 1){//According to the difficulty to choose instructions
            wrongRight = 2;
            System.out.println("1. Guess The vowel alphabet");
            System.out.println("2. You are allowed to make one guess a time");
            System.out.println("3. Each game has " + wrongRight + " chances to guess the correct vowel");
            System.out.println("4. Once you have used up all your chances, you lose the game");
            System.out.println("\nGood Luck!\nEasy:");
        }
        if(difficulty == 2){
            wrongRight = 4;
            System.out.println("1. Guess The consonant alphabet");
            System.out.println("2. You are allowed to make one guess a time");
            System.out.println("3. Each game has " + wrongRight + " chances to guess the correct vowel");
            System.out.println("4. Once you have used up all your chances, you lose the game");
            System.out.println("\nGood Luck!\nMedium:");
        }
        if(difficulty == 3){
            wrongRight = 5;
            System.out.println("1. Guess The alphabet");
            System.out.println("2. You are allowed to make one guess a time");
            System.out.println("3. Each game has " + wrongRight + " chances to guess the correct vowel");
            System.out.println("4. Once you have used up all your chances, you lose the game");
            System.out.println("\nGood Luck!\nHard:");
        }
    }
    static void ShowCredit(){
        System.out.println("Student Name/Surname && ID");
        System.out.println("Gulsu Oz - 200209057");
        System.out.println("Huseyin Murat - 200209028 ");
        System.out.println("Omer Akce - 200209045 ");
        System.out.println("Ismail Basar Ekinci - 200209057");
        System.out.println("Edar Erdem - 200209002");
        System.out.println("Yunus Emre Bektas - 200209043 ");
        System.out.println("Course of Study: Software Construction");
    }


}