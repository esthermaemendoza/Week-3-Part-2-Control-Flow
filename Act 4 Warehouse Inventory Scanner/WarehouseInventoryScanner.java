import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class WarehouseInventoryScannerWeek4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] inventoryGrid = {
            {15, -1, 20},
            {4, 25, 2},
            {-1, 10, 30}
        };

        int userSelection;

        do {
            System.out.println("\nDEPOT INVENTORY MENU");
            System.out.println("1. Calculate Total Inventory");
            System.out.println("2. Locate Critically Low Shelf");
            System.out.println("3. Restock Item Shelf");
            System.out.println("4. Terminate Program");

            System.out.print("Please make a selection: ");
            userSelection = readInt(scanner);

            if (userSelection == 1) {
                int runningSum = 0;
       
                for (int r = 0; r < inventoryGrid.length; r++) {
                    for (int c = 0; c < inventoryGrid[r].length; c++) {
                        if (inventoryGrid[r][c] == -1) {
                            continue;
                        }

                        runningSum += inventoryGrid[r][c];
                    }
                }

                System.out.println("Accumulated Inventory Total: " + runningSum);

            } else if (userSelection == 2) {
                boolean itemFound = false;
                for (int r = 0; r < inventoryGrid.length; r++) {
                    for (int c = 0; c < inventoryGrid[r].length; c++) {
                        if (inventoryGrid[r][c] == -1) {
                            continue;
                        }

                        if (inventoryGrid[r][c] <= 3) {
                            System.out.println("Critically Low Shelf Located!");
                            System.out.println("Shelf Row: " + (r + 1));
                            System.out.println("Shelf Column: " + (c + 1));
                            System.out.println("Current Stock: " + inventoryGrid[r][c]);

                            itemFound = true;
                            break;
                        }
                    }

                    if (itemFound) {
                        break;
                    }
                }

                if (!itemFound) {
                    System.out.println("No critically low shelves discovered.");
                }

            } else if (userSelection == 3) {
                // Use a while loop plus return to simulate restocking with input validation
                processRestock(inventoryGrid, scanner);

            } else if (userSelection == 4) {
                System.out.println("Shutting down Inventory Management System...");

            } else {
                System.out.println("Unrecognized choice. Please try again.");
            }

        } while (userSelection != 4);
        
        scanner.close();
    }

    public static void processRestock(int[][] inventoryGrid, Scanner scanner) {
        int targetRow;
        int targetCol;

        while (true) {
            System.out.print("Select shelf row (1-" + inventoryGrid.length + "): ");
            targetRow = readInt(scanner);

            System.out.print("Select shelf column (1-" + inventoryGrid[0].length + "): ");
            targetCol = readInt(scanner);

            if (targetRow < 1 || targetRow > inventoryGrid.length
                    || targetCol < 1 || targetCol > inventoryGrid[0].length) {
                System.out.println("Out of bounds coordinates. Try again.");
                continue;
            }

            if (inventoryGrid[targetRow - 1][targetCol - 1] == -1) {
                System.out.println("Restocking error: This shelf is marked damaged (-1). Try again.");
                continue;
            }

            break;
        }

        int additionQuantity;

        while (true) {
            System.out.print("Enter quantity to deposit: ");
            additionQuantity = readInt(scanner);

            if (additionQuantity <= 0) {
                System.out.println("Deposit amount must be greater than zero.");
                continue;
            }

            break;
        }

        inventoryGrid[targetRow - 1][targetCol - 1] += additionQuantity;

        System.out.println("Restock Completed Successfully!");
        System.out.println("New Shelf Count: " + inventoryGrid[targetRow - 1][targetCol - 1]);

        return;
    }

    public static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input format. Enter an integer: ");
            scanner.next();
        }

        return scanner.nextInt();
    }
}
