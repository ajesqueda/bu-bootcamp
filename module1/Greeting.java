import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("What is your name?  ");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name + "! Welcome to the program.");
            System.out.print("What do you do for work? ");
            String work = scanner.nextLine();
            System.out.println("Hello, " + name + "! As a " + work + " , you are in the exactly right place.");
        }
    }
}
