import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"CatchMayIgnoreException", "AccessStaticViaInstance"})
public class Main {

    private static Scanner javaScanner = new Scanner(System.in);
    @SuppressWarnings({"unused", "InstantiationOfUtilityClass"})
    private static final reading_BrainfuckCore brainfuckCore = new reading_BrainfuckCore();

    public static void main(String args[]) {
        if (args.length == 1) {
            runFile(args[0]);
        } else if (args.length == 0) {
            System.out.println("Enter the code:");
            String code = javaScanner.nextLine();
            System.out.println("Output:");
            brainfuckCore.interpret(code);
        }
    }

    public static void runFile(String filePath) {
        File file = new File(filePath);
        StringBuilder codeOfFileStrBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //debug(line);
                codeOfFileStrBuilder.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (Exception e) {}
        brainfuckCore.interpret(codeOfFileStrBuilder.toString());
    }
}