package org.example.codePractices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Solution {
//    Generic method <E> allows for any data type

    public static <E> void printArray(E[] array) {
        for (E item : array) {
            System.out.println(item);
        }
    }

    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
//             if currently assessed number is not equal previous number
//             modify current index
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];

                j++;
            }
//             if currents element index is equal previous nothing changes. Next index is evaluated
        }
//         returns the number of unique elements
        return j;
    }

    //it can also be said to be the highest number in a given array
    public int maxProfit(int[] nums) {
        int totalProfit = 0;

        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));

        //assumes 1 as the smallest price and starting point
        for (int i = 1; i < nums.length; i++) {
//            if current index value is bigger than previous index
            if (nums[i] > nums[i - 1]) {
                //adds to totalProfit the difference between the current index and previous index
                totalProfit += nums[i] - nums[i - 1];
            }
        }

        return totalProfit;

    }

    public String convertFromDecimalToBinary(int number) {


        int n = 32227, remainder = 0, iteration = 0;
        String binary = "", finalBinary = "";

        while (n > 0) {
            iteration++;
            remainder = n % 2;
            n = n / 2;
            System.out.print("Iteration #: " + iteration + ". remainder : " + remainder);
            System.out.println("Number after division by 2: " + n);

            if (remainder == 1) {
                binary += "1";
            } else {
                binary += "0";
            }
        }

        for (int i = binary.length() - 1; i >= 0; i--) {
            finalBinary += binary.charAt(i);
        }
        System.out.println("Base 10 number converted to binary is: " + finalBinary);

        return finalBinary;
    }

    public char calculate(int[] number) {
        char finalGrade = '0';
        int numberOfGrades = number.length;
        int averageGrade = Arrays.stream(number).sum() / numberOfGrades;

        if (averageGrade < 40) {
            finalGrade = 'T';
        } else if (averageGrade < 55) {
            finalGrade = 'D';
        } else if (averageGrade < 70) {
            finalGrade = 'P';
        } else if (averageGrade < 80) {
            finalGrade = 'A';
        } else if (averageGrade < 90) {
            finalGrade = 'E';
        } else {
            finalGrade = 'O';
        }


        return finalGrade;
    }

    public int power(int n, int p) throws Exception {
        int result = 0;

        if (n < 0 || p < 0) {
            throw new Exception("n and p cannot be negative numbers.");
        }

        return result;
    }

    public void bubbleSort(List<Integer> list, int numberElements) {
        int swap = 0;
        for (int i = 0; i < numberElements; i++) {
            for (int j = i + 1; j < numberElements; j++)
                if (list.get(i) > list.get(j)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                    swap++;
                }
        }
        System.out.println("Array is sorted in " + swap + " swaps.");
        System.out.println("First Element: " + list.get(0));
        System.out.println("Last Element: " + list.get(numberElements - 1));

    }
}