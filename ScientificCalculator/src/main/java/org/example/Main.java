package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to continue");
        sc.nextLine();
        Calculator.start();
    }
}
