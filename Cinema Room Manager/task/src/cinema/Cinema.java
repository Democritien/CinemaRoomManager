package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

//        System.out.println(printViewOfTheatre());
        System.out.println(calculateIncome(rows, seats));
    }

    public static String printViewOfTheatre() {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= 8; i++) {
            System.out.print(" " + i);
        }

        System.out.println("\t");

        String[][] seats = new String[7][9];

        seats[0][0] = "1";
        seats[1][0] = "2";
        seats[2][0] = "3";
        seats[3][0] = "4";
        seats[4][0] = "5";
        seats[5][0] = "6";
        seats[6][0] = "7";

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (j > 0) {
                    System.out.print(seats[i][j] = "S" + " ");
                } else System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }

    public static int calculateIncome(int rows, int seats) {

        int income = 0;

        if (rows * seats <= 60) income = rows * seats * 10;
        if (rows * seats > 60) income = (rows / 2 * seats * 10) + ((rows - rows / 2) * seats * 8);

        System.out.println("Total income:");
        System.out.print("$");

        return income;
    }
}