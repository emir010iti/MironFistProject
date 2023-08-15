package romancalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {

    public static void calculate(String leftNumber, String operation, String rightNumber) {

        boolean numValid = true;
        boolean opValid = true;
        int leftInt, rightInt;
        int resultInt = 0;

        leftInt = RomanNumerals.parse(leftNumber.toUpperCase());
        rightInt = RomanNumerals.parse(rightNumber.toUpperCase());

        if(leftInt == -1){
            Integer.parseInt(leftNumber);
            leftInt = Integer.parseInt(leftNumber);
        }
        if(leftInt == -1){
            Integer.parseInt(rightNumber);
            leftInt = Integer.parseInt(rightNumber);
        }
        if (leftInt == -1) {
            numValid = false;
            System.out.println("invalid number: " + leftNumber);
        }
        if (rightInt == -1) {
            numValid = false;
            System.out.println("invalid number: " + rightNumber);
        }


        if (operation.equals("+") || operation.equals("-") || operation.equals("*") ||
                operation.equals("/") || operation.equals("%") || operation.equals("#")) {
            opValid = true;
        } else {
            opValid = false;
            System.out.println("invalid operation");

        }

        if (numValid == true && opValid == true) {

            if (operation.equals("+")) {
                resultInt = leftInt + rightInt;
            }

            else if (operation.equals("-")) {
                resultInt = leftInt - rightInt;
            }

            else if (operation.equals("*")) {
                resultInt = leftInt * rightInt;
            }

            else if (operation.equals("/")) {
                resultInt = leftInt / rightInt;
            }

            else if (operation.equals("%")) {
                resultInt = leftInt % rightInt;
            }

            else if (operation.equals("#")) {
                resultInt = (leftInt + rightInt)/2;
            }



            if(opValid && numValid) {

                if (resultInt <= 0 || resultInt >= 4000) {
                    System.out.println("result out of range");
                } else {
                    System.out.println(RomanNumerals.format(resultInt));
                }
            }




        }


    }

    public static int parseDecimalNumber(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("> ");

            final String line = reader.readLine();
            if (line.length() == 0) {
                System.out.println("done");
                break;
            }
            final Scanner scanner = new Scanner(line);
            final String leftNumber, operation, rightNumber;
            try {
                leftNumber = scanner.next();
                operation = scanner.next();
                rightNumber = scanner.next();
            }
            catch (NoSuchElementException e) {
                System.err.println("syntax error");
                System.out.println();
                continue;
            }

            calculate(leftNumber, operation, rightNumber);

            System.out.println();
        }
    }
}
