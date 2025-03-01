package org.example;

import java.util.Scanner;

public class Calculator {
    private static final Scanner sc = new Scanner(System.in);

    public static void start() {
        while (true) {
            
            System.out.println("Select an operation:");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power Function (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            double num;
            double result;
            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    num = sc.nextDouble();
                    result = squareRoot(num);
                    if (result!=-1) {
                        System.out.println("Square Root: " + result + "\n");
                    } else {
                        System.out.println("Error! Cannot compute square root of a negative number." + "\n");
                    }
                    break;

                case 2:
                    System.out.print("Enter a non-negative integer: ");
                    num = sc.nextDouble();
                    result = factorialOf(num);
                    if (result > 0) {
                        System.out.println("Factorial: " + (long) result + "\n");
                    } else {
                        System.out.println("Error! Factorial is defined for non-negative integers only." + "\n");
                    }
                    break;

                case 3:
                    System.out.print("Enter number: ");
                    num = sc.nextDouble();
                    result = naturalLog(num);
                    if (result > 0) {
                        System.out.println("Natural Logarithm: " + result + "\n");
                    } else {
                        System.out.println("Error! Logarithm of a non-positive number is undefined." + "\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter base (x): ");
                    double base = sc.nextDouble();
                    System.out.print("Enter exponent (b): ");
                    double exponent = sc.nextDouble();
                    result = powerOf(base, exponent);
                    System.out.println("x^b: " + result + "\n");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option." + "\n");
            }
        }

    }

    public static double squareRoot(double num) {
        if (num >= 0) {
            return Math.sqrt(num);
        } else {
            return -1;
        }
    }

    public static long factorialOf(double factNum) {
        if(factNum<0 || factNum-Math.floor(factNum)!=0) {
            return -1;
        }
        else{
            return factorial(factNum);
        }
    }

    public static double naturalLog(double num) {
        if (num > 0) {
            return Math.log(num);
        } else {
            return -1;
        }
    }

    public static double powerOf(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    private static long factorial(double factNum) {
        int num = (int) factNum;
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}
