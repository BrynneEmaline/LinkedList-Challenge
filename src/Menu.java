import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void startUp(Itinerary itinerary) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("What would you like to do?");
            System.out.println("(F)orward" +
                    "    \n(B)ackward" +
                    "    \n(L)ist places" +
                    "    \n(A)dd" +
                    "    \n(Q)uit");


            String input = scanner.nextLine();

            switch (input) {
                case "F", "f" -> {
                    String choice;
                    do {
                        String forward = itinerary.forward();
                        System.out.println(forward);
                        if (forward.equalsIgnoreCase("End of list reached.\n")) {
                            break;
                        }
                        System.out.println("See the next town? Y/N ");
                        choice = scanner.nextLine();
                    } while (choice.equalsIgnoreCase("Y"));

                }
                case "B", "b" -> {
                    String choice;
                    do {
                        String backward = itinerary.backward();
                        System.out.println(backward);
                        if (backward.equalsIgnoreCase("Front of list reached.\n")) {
                            break;
                        }
                        System.out.println("See the previous town? Y/N ");
                        choice = scanner.nextLine();
                    } while (choice.equalsIgnoreCase("Y"));

                }
                case "L", "l" -> itinerary.list();
                case "A", "a" -> {
                    int distance;
                    String name;

                    System.out.println("Enter the name of the town: ");
                         name = scanner.nextLine();
                    System.out.println("Enter the distance of the town from Sydney: ");
                     try {
                        distance = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid distance.");
                        scanner.nextLine();
                        System.out.println("Enter the distance of the town from Sydney: ");
                        distance = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    System.out.println(itinerary.addTown(name, distance));
                }

                case "Q", "q" -> {
                    System.out.println("Quitting program");
                    running = false;
                }
                default -> {
                    System.out.println("Invalid Choice: " + input);
                }
            }
        }
    }
}
