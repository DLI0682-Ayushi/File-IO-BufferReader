package FileIO;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteUserContent {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Ayushi.Pundir\\Desktop\\file1.txt";

        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(fileName)) {

            System.out.println("Enter the data you want to add to the file:");
            String userInput = scanner.nextLine();
            writer.write(userInput);
            writer.flush();
            System.out.println("Your words have been immortalized in " + fileName + "!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
