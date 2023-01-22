package cinema;

import java.util.Arrays;
import java.util.Scanner;

class Cinema {
    static String[][] cinema;
    static int rows;
    static int seats;
    static int numberOfSeats;
    static int row;
    static int seat;
    static int currentIncome;
    static int flag;

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
            int num = scanner.nextInt();
            System.out.println();
            switch (num) {
                case 1 -> showTheSeats();
                case 2 -> buyATicket();
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

    static void buyATicket() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Enter a row number:");
            row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt();
            if (row > rows || seat > seats) {
                System.out.println("\nWrong input!");
                continue;
            }
            if (cinema[row - 1][seat - 1].equals("S")) {
                cinema[row - 1][seat - 1] = "B";
                flag += 1;
                System.out.println();
                seatReservation(row);
                break;
            } else System.out.println("\nThat ticket has already been purchased!");
        }
    }

    static void seatReservation(int row) {
        numberOfSeats = cinema.length * cinema[0].length;
        int halfRows = cinema.length / 2;
        int price = 0;
        if (numberOfSeats <= 60) price = 10;
        if (numberOfSeats > 60) price = row > halfRows ? 8 : 10;
        currentIncome += price;
        System.out.println("Ticket price: $" + price);
        System.out.println();
    }

    static void showStatistics() {
        int numberOfPurchasedTickets = 0;
        double percentage = 0.00;
        int totalIncome = 0;

        for (int i = 0; i < flag; i++) {
            numberOfPurchasedTickets += 1;
        }

        percentage = (numberOfPurchasedTickets * 100.0) / (rows * seats);


        if ((rows * seats) <= 60) totalIncome = (rows * seats) * 10;
        if ((rows * seats) > 60) totalIncome = (rows / 2 * seats) * 10 + ((rows - rows / 2) * seats) * 8;

        String result = String.format("Number of purchased tickets: %d %nPercentage: %.2f%% %nCurrent income: $%d %nTotal income: $%d",
                                      numberOfPurchasedTickets, percentage, currentIncome, totalIncome);
        System.out.println(result);
        System.out.println();
    }
}

