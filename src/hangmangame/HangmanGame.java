/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Rakesh
 */
public class HangmanGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hangman Game. \n Guess the Word withing 6 trails to win the Game.");
        System.out.println();
        System.out.println("The word has been picked. Below is the picture"
                        +"thats your current guess, which starts off as nothing. Everytime you guess incorrectly, I add a body parts to the picture.\n When there is a full person you lose");
        boolean Play = true;
        while(Play){
            System.out.println();
            System.out.println("Alright! Let's play!");
            Hangman game = new Hangman();
            do {
                // Draw the things...
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                System.out.print(game.mysteryWord);
                System.out.println();
                
                // Get the guess
                System.out.println("Enter a character that you think is in the word");
                char guess = (sc.next().toLowerCase()).charAt(0);
                System.out.println();
                
                // Check if the character is guessed already
                while (game.isGuessedAlready(guess)) {
                    System.out.println("Try again! You've already guessed that character.");
                    guess = (sc.next().toLowerCase()).charAt(0);
                }
                
                // Play the guess
                if (game.playGuess(guess)) {
                    System.out.println("Great guess! That character is in the word!");
                } else {
                    System.out.println("Unfortunately that character isn't in the word");
                }
                
            }
            while (!game.gameOver()); // Keep playing until the game is over
            
            // Play again or no?
            System.out.println();
            System.out.println("Do you want to play another game? Enter Y if you do.");
            Character response = (sc.next().toUpperCase()).charAt(0);
            Play = (response == 'Y' || response =='y');
            
        }
        
    }
    
}
