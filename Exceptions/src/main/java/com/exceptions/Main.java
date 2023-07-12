package com.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Array to test accessArrayElement function
        int [] array = {1, 2, 3, 4, 5, 6};
        // File instance to test readFile function
        File file = new File("test.txt");

        divideByZero(5,0);
        accessArrayElement(array, 9);
        readFile(String.valueOf(file));
    }

    /**
     * Manage ArithmeticException
     * @param divisor value to divide
     * @param dividend value to divide
     */
    public static void divideByZero(int divisor, int dividend) {
        try {
            int result = divisor / dividend;
            if(dividend > 0) {
                System.out.println("Result: " + result);
            }
        }catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Manage ArrayIndexOutOfBounds
     * @param array array to receive
     * @param index index to access
     */
    public static void accessArrayElement(int[] array, int index) {
        try {
            int element = array[index];
            System.out.println("Element in index " + index + " is: " + element);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Limits out of array");
        }
    }

    /**
     * Manage FileNotFound exception
     * @param filePath path of file
     */
    public static void readFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("File not found: " + filePath);
        }
    }
}
