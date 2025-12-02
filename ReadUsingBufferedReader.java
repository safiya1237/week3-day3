import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadUsingBufferedReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String filename = sc.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            System.out.println("\n---- File Content ----");

            while ((line = br.readLine()) != null) {
                System.out.println(line);   // print each line
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}