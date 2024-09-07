/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numbergame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Keenan
 */
//Base class game
class Game {
    //General game properties (can be extended for other types of games)
    private String gameName;
    
    //Constructor to initialize game name
    public Game(String gameName) {
        this.gameName = gameName;
    }
    
    //Getter for game name
    public String getGamename() {
        return gameName;
}   
    
    //Method to start the game (to be overridden by subclasses)
    public void start() {
        System.out.println("Starting " + gameName + "...");
        
    }
}

//Guess the Number game class (inherits from Game)
class GuessNumberGame extends Game {
    private int randomNumber;
    private ArrayList<Integer> guessHistory; //Stores the guesses
    private int maxGuesses;
    
    //Constructor for the GuessNumberGame
    public GuessNumberGame(int maxGuesses) {
        super("Guess the Number Game");
        this.randomNumber = generateRandomNumber();
        this.guessHistory = new ArrayList<>();
        this.maxGuesses = maxGuesses;
    }
    
    //Generate a random number between 1 and 100
    private int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }
    
    //Starts the game
    @Override
    public void start() {
        super.start();
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        boolean guessedCorrectly = false;
        
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");
        
        //Game loop: run until the player guesses the correct number or reaches max guesses
        for (int attempts = 1; attempts <= maxGuesses && !guessedCorrectly; attempts++) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            guessHistory.add(guess);
            
            if (guess == randomNumber) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number correctly in " + attempts + "attempts");
            }else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            }else {
                System.out.println("Too high! Try again.");
            }
        }
        
        if (!guessedCorrectly) {
        System.out.println("Sorry , you've reached the maximum number of attempts. the correct number was: " + randomNumber);
        }
        
        //Display guess history
        displayGuessHistory(); 
    }
    
    //Method to display the guess history
    private void displayGuesshistory() {
        System.out.println("\nYour guesses: " + guessHistory);
    }

    private void displayGuessHistory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

//Main class to run the game
public class NumberGame {

    public static void main(String[] args) {
        //Create a new instance of GuessNumberGame and start it
        GuessNumberGame game = new GuessNumberGame(10); //Allow up to 10 guesses
        game.start();
    }
}
