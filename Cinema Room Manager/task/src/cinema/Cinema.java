package cinema;

import java.util.Scanner;

class Cinema {
    static String[][] cinema;
    static int rows;
    static int seats;
    static int numberOfSeats;
    static int currentIncome;
    static int reservedSeats;

    public static void main(String[] args) {
        createCinema();
        menu();
    }

    static void createCinema() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        System.out.println();
        numberOfSeats = rows * seats;

        cinema = new String[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = "S";
            }
        }
    }

    static void menu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                               1. Show the seats
                               2. Buy a ticket
                               3. Statistics
                               0. Exit
                               """);
            System.out.println();

            int num = scanner.nextInt();
            switch (num) {
                case 1 -> showTheSeats();
                case 2 -> reserveSeat();
                case 3 -> showStatistics();
                default -> {
                    return;
                }
            }
        }
    }

    static void showTheSeats() {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinema[0].length; i++) {
            System.out.print(" " + i);
        }

        System.out.println();
        for (int i = 0; i < cinema.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.print(" " + cinema[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();

            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();

            if (row > rows || seat > seats) {
                System.out.println("\nWrong input!");
            } else {
                if (cinema[row - 1][seat - 1].equals("S")) {
                    cinema[row - 1][seat - 1] = "B";
                    reservedSeats += 1;
                    System.out.println();
                    printTicketPrice(row);
                    break;
                } else {
                    System.out.println("\nThat ticket has already been purchased!");
                }
            }
        }
    }

    static void printTicketPrice(int row) {
        int price = getPrice(row);
        currentIncome += price;
        System.out.println("Ticket price: $" + price);
        System.out.println();
    }

    static int getPrice(int row) {
        int halfRows = cinema.length / 2;
        if (numberOfSeats <= 60) return 10;
        else return row > halfRows ? 8 : 10;
    }

    static void showStatistics() {
        double percentage = (reservedSeats * 100.0) / (rows * seats);
        int totalIncome = getTotalIncome();

        System.out.printf("""
                          Number of purchased tickets: %d
                          Percentage: %.2f%%
                          Current income: $%d
                          Total income: $%d
                          """, reservedSeats, percentage, currentIncome, totalIncome);
        System.out.println();
    }

    static int getTotalIncome() {
        return (numberOfSeats <= 60) ? numberOfSeats * 10
                                     : (rows / 2 * seats) * 10 + ((rows - rows / 2) * seats) * 8;
    }
}

