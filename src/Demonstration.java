import java.util.InputMismatchException;
import java.util.Scanner;
import first_ex.Main;
import second_ex.mainSoldier;

public class Demonstration {
    public static void startDemonstration() {
        System.out.print("""
                Starting Demonstration
                1. Завдання - 1
                2. Завдання - 2
                3. Вихід
                Ваш вибір:\s""");
        Scanner scanner = new Scanner(System.in);
        int choise = 0;
        try {
            choise = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println(" ");
        }
        switch (choise) {
            case 1 -> {
                Main.mainFirst();
                pressToContinue();
                startDemonstration();
            }
            case 2 -> {
                mainSoldier.mainStart();
                pressToContinue();
                startDemonstration();
            }
            case 3 -> {
                System.out.println("Гарного дня)");
            }
            default -> {
                System.out.println("Не правильний вибір!");
                startDemonstration();
            }

        }
    }
    private static void pressToContinue() {
        System.out.println("Press any key to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
