import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Ask filename
        System.out.print("Enter file name to create: ");
        String filename = sc.nextLine();

        // Step 2: Ask user input for file content
        System.out.println("Enter text to write into file (type END to stop):");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            while (true) {
                String line = sc.nextLine();

                if (line.equalsIgnoreCase("END"))
                    break;

                bw.write(line);
                bw.newLine();
            }

            bw.close();
            System.out.println("\nFile created and saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
            return;
        }

        // Step 3: Analyze the file
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            String longestWord = "";
            String shortestWord = null;
            Set<String> uniqueWords = new HashSet<>();

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String w : words) {
                    w = w.replaceAll("[^a-zA-Z]", ""); // remove punctuation

                    if (w.isEmpty()) continue;

                    uniqueWords.add(w.toLowerCase());

                    if (w.length() > longestWord.length())
                        longestWord = w;

                    if (shortestWord == null || w.length() < shortestWord.length())
                        shortestWord = w;
                }
            }

            br.close();

            // Step 4: Print Results
            System.out.println("\n==== FILE ANALYSIS ====");
            System.out.println("Longest word: " + longestWord);
            System.out.println("Shortest word: " + shortestWord);
            System.out.println("Number of unique words: " + uniqueWords.size());

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}