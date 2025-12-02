import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadUsingFileReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String filename = sc.nextLine(); // user input

        try {
            FileReader fr = new FileReader(filename);
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}