package com.solvd.homework.bubble_sorting;

import java.util.Scanner;

// Bubble sorting
public class Executor {
    private static Scanner in;

    public static void main(String[] args) {

        int arrayLength = inputArrayLength();

        int[] array = inputArray(arrayLength);

        System.out.println("Array: ");
        outputArray(array);

        boolean sortedParameter = inputSortedParameter();
        sortArray(array, sortedParameter);

        System.out.print("Sorted array: ");
        outputArray(array);

    }

    private static int[] inputArray(int arrayLength) {
        int[] array1 = new int[arrayLength];
        for (int i = 0; i < array1.length; i++) {
            while(true) {
                try {
                    in = new Scanner(System.in);
                    System.out.print("array["+i+"] = ");
                    array1[i] = in.nextInt();

                    break;
                }
                catch(Exception e) {
                    System.out.println("You have to input integer.");
                }
            }
        }
        return array1;
    }

    private static void outputArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static int inputArrayLength() {
        int length;
        while(true) {
            try {
                in = new Scanner(System.in);
                System.out.print("Input array length: ");
                length = in.nextInt();
                if (length > 0) {
                    break;
                } else {
                    System.out.println("You have to input positive numbers.");
                }
            }
            catch(Exception e) {
                System.out.println("You have to input integer.");
            }
        }
        return length;
    }

    private static boolean inputSortedParameter() {
        boolean sortedParameter;
        while(true) {
            try {
                in = new Scanner(System.in);
                System.out.println("Sort by ascending input -> true");
                System.out.println("Sort by descending input -> false");
                sortedParameter = in.nextBoolean();

                break;
            }
            catch(Exception e) {
                System.out.println("You have to input true or false.");
            }
        }
        return sortedParameter;
    }

    private static void sortArray(int[] array, boolean sortByAscending) {
        if (sortByAscending) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }
}
