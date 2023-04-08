import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */

public class FilesInOut {
    public static void main(String[] args) {
        
        // determines the input and output of FilesInOut
        File inputFile = new File("C:\\Users\\Shania\\Downloads\\CSCU9T4Prac2-main\\CSCU9T4Prac2-main\\input.txt");
        File outputFile = new File("output.txt");

        try {
            
            // creates a scanner to read the input file, and a "PrintWriter" to write to the output file
            Scanner scanner = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile);

            // formats the name and date for each line in the input file, then it writes the results to the output file.
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                StringBuilder formattedName = new StringBuilder();
                String formattedDate = "";

                // removes any digits from the name and capitalizes the initial letter for each of the word
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];

                    if (i ==0) {
                        String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                        formattedName.append(formattedWord);
                    } else if (i ==1 && word.length() == 2) {
                        formattedName.append(". ").append(word.toUpperCase());
                    } else if (i == words.length -1) {
                        String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                        formattedName.append(" ").append(formattedWord.replaceAll("[0-9]", ""));
                    } else {
                        String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                        formattedName.append(" ").append(formattedWord.replaceAll("[0-9]", ""));
                    }
                }

                // rearranges the day, month, year in the format "dd/mm/yyyy" to format the date
                int dateIndex = line.lastIndexOf(" ");
                String dateString = line.substring(dateIndex + 1);
                String day = dateString.substring(0, 2);
                String month = dateString.substring(2, 4);
                String year = dateString.substring(4);
                formattedDate = day + "/" + month + "/" + year;

                // writes formatted output to file
                writer.println(formattedName.toString() + " " + formattedDate);
            }

            // closes the scanner and PrintWriter
            scanner.close();
            writer.close();
            
        } catch (FileNotFoundException e) {
            
            // handles if the input and output file cant be found
            e.printStackTrace();
        }
    }
}
