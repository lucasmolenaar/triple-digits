package nl.novi.basicprogramming;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // Nieuwe Random en Scanner initialiseren
    public static Random randomizer = new Random();
    public static Scanner userInput = new Scanner(System.in);

    // Boolean om te bepalen of er door wordt gespeeld of niet
    private static boolean continuePlaying = true;

    public static void main(String[] args) {
        while(continuePlaying) {
            playGame();
        }
    }

    public static void playGame() {
        // Random gegeven getallen
        int maxRand = 9;
        int firstDigit = randomizer.nextInt(maxRand) + 1;
        int secondDigit = randomizer.nextInt(maxRand) + 1;
        int thirdDigit = randomizer.nextInt(maxRand) + 1;

        // De som en het product van de drie getallen
        int sumOfDigits = firstDigit + secondDigit + thirdDigit;
        int productOfDigits = firstDigit * secondDigit * thirdDigit;
        // Som en product printen in de console
        System.out.println("De som van de drie getallen is: " + sumOfDigits);
        System.out.println("Het product van de drie getallen is: " + productOfDigits);

        for (int i = 0; i < 3; i++) {
            // Gebruiker moet drie getallen kiezen
            System.out.println("Kies een nummer (1-9):");
            int playersChoice1 = userInput.nextInt();
            System.out.println("Kies een nummer (1-9):");
            int playersChoice2 = userInput.nextInt();
            System.out.println("Kies een nummer (1-9):");
            int playersChoice3 = userInput.nextInt();

            // De som en het product van de drie gekozen getallen van de gebruiker
            int sumOfChoices = playersChoice1 + playersChoice2 + playersChoice3;
            int productOfChoices = playersChoice1 * playersChoice2 * playersChoice3;
            boolean hasPlayerWon = sumOfDigits == sumOfChoices && productOfDigits == productOfChoices;

            // Checken of 2 sommen en 2 producten gelijk zijn
            if (hasPlayerWon) {
                System.out.println("Je hebt gewonnen!");
                break;
            } else if(i < 2){
                System.out.println("Fout, nog een keer");
            } else {
                System.out.println("Helaas, je hebt verloren!");
            }
        }

        askToPlayAgain();
    }

    public static void askToPlayAgain() {
        // Vragen of de gebruiker door wilt spelen
        System.out.println("Wil je nog een keer spelen? (y/n)");
        String continuePlayingChoice = userInput.next();

        switch (continuePlayingChoice) {
            case "y":
                System.out.println("Het spel begint opnieuw");
                continuePlaying = true;
                break;
            case "n":
                System.out.println("Het spel stopt");
                continuePlaying = false;
                break;
            default:
                System.out.println("Je hebt geen geldige waarde ingevoerd");
        }
    }
}
