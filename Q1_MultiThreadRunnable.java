// Importing the Scanner class for taking input from the user
import java.util.Scanner;

// Class implementing Runnable interface to print each word separately
class WordThread implements Runnable {
    private String text; // variable to store the input paragraph

    // Constructor to initialize text
    public WordThread(String text) {
        this.text = text;
    }

    // run() method defines what the thread will execute
    public void run() {
        // Split the paragraph into words using spaces
        String[] words = text.split("\\s+");
        for (String word : words) {
            // Print each word
            System.out.println("Word Thread: " + word);
            try {
                // Pause for 2 seconds between words
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Handle thread interruption errors
                System.out.println(e);
            }
        }
    }
}

// Another class implementing Runnable to print only vowels from the text
class VowelThread implements Runnable {
    private String text; // variable to store the input paragraph

    // Constructor to initialize text
    public VowelThread(String text) {
        this.text = text;
    }

    // run() method defines what this thread will execute
    public void run() {
        // Loop through each character of the paragraph
        for (char c : text.toCharArray()) {
            // Check if the character is a vowel (upper or lowercase)
            if ("AEIOUaeiou".indexOf(c) != -1) {
                // Print vowel characters
                System.out.println("Vowel Thread: " + c);
                try {
                    // Pause for 2 seconds between vowels
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // Handle any thread interruption
                    System.out.println(e);
                }
            }
        }
    }
}

// Main class
public class Q1_MultiThreadRunnable {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a paragraph
        System.out.println("Enter a paragraph: ");
        String paragraph = sc.nextLine();

        // Create two Thread objects, passing the Runnable classes
        Thread t1 = new Thread(new WordThread(paragraph));  // Thread for words
        Thread t2 = new Thread(new VowelThread(paragraph)); // Thread for vowels

        // Start both threads (they will run concurrently)
        t1.start();
        t2.start();

        // Close the scanner
        sc.close();
    }
}
