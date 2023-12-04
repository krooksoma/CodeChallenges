package org.example.adventOfCode;

import org.example.adventOfCode.utils.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {

    /**Advent of Code Challenge day 1 challenge. One implementation will read numbers(Constant.DIGITS_ONLY)
    the second implementation will read digits and its names(Constants.DIGITS_AND_NAMES_ONLY)
    */

     public int readLine() throws IOException {
        int totalValue = 0;
        String firstInteger, lastInteger;

        try {
            File file = new File("src/main/java/org/example/adventOfCode/files/input.txt"); // creates a new instance of the file
            System.out.println(file.getCanonicalFile());
            FileReader fileReader = new FileReader(file); //reads the file
            BufferedReader reader = new BufferedReader(fileReader); // creates a buffering character input stream
            String line;
            int readingLine = 0;

            while((line = reader.readLine()) != null){
                LinkedList<String> integers = new LinkedList<>();
//                System.out.println("reading line: " + line);
                readingLine++;
                Matcher m = Pattern.compile(Constants.DIGIT_AND_NAME_MATCH).matcher(line);
                while(m.find()){
                    if(m.group().length() > 2){
                        integers.add(String.valueOf(getIntegerValueFromString(m.group())));
                    }else{
                        integers.add(m.group());
                    }
                }

                if(integers.size() == 1){
                    totalValue += Integer.parseInt(integers.getFirst() + integers.getFirst());
                } else {

                    firstInteger = integers.getFirst();
                    lastInteger = integers.getLast();
                    System.out.println("Now reading line: " + readingLine);
                    System.out.println("firstInteger: " + firstInteger + " || " + "lastInteger: " + lastInteger);
                    System.out.println("\n");
                    totalValue += Integer.parseInt(firstInteger + lastInteger);
                }
            }

        }catch(Exception e){
            throw new IOException(e.getMessage());
        }
        return totalValue;
    }

    static int getIntegerValueFromString(String word){
        int integerValue = 0;

        switch(word.toLowerCase()){
            case "one":
                integerValue = 1;
                break;
            case "two":
                integerValue = 2;
                break;
            case "three":
                integerValue = 3;
                break;
            case "four":
                integerValue = 4;
                break;
            case "five":
                integerValue = 5;
                break;
            case "six":
                integerValue = 6;
                break;
            case "seven":
                integerValue = 7;
                break;
            case "eight":
                integerValue = 8;
                break;
            default:
                integerValue = 9;
                break;
        }

        return integerValue;

    }
}
