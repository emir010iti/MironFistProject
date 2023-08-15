package romancalc;

public class RomanNumerals {
    public static String format(int value) {
        // Group 1: Write this function!
        String romanNum = "";


        while (value > 0) {
            while (value >= 1000) {
                romanNum = romanNum + "M";
                value -= 1000;
            }
            while (value >= 900) {
                romanNum = romanNum + "CM";
                value -= 900;
            }
            while (value >= 500) {
                romanNum = romanNum + "D";
                value -= 500;
            }
            while (value >= 400) {
                romanNum = romanNum + "CD";
                value -= 400;
            }
            while (value >= 100) {
                romanNum = romanNum + "C";
                value -= 100;
            }
            while (value >= 90) {
                romanNum = romanNum + "XC";
                value -= 90;
            }
            while (value >= 50) {
                romanNum = romanNum + "L";
                value -= 50;
            }
            while (value >= 40) {
                romanNum = romanNum + "XL";
                value -= 40;
            }
            while (value >= 10) {
                romanNum = romanNum + "X";
                value -= 10;
            }
            while (value >= 9) {
                romanNum = romanNum + "IX";
                value -= 9;
            }
            while (value >= 5) {
                romanNum = romanNum + "V";
                value -= 5;
            }
            while (value >= 4) {
                romanNum = romanNum + "IV";
                value -= 4;
            }
            while (value >= 1) {
                romanNum = romanNum + "I";
                value -= 1;
            }

        }
        return romanNum;
    }

    public static int parse(String number) {

        int lengthOfNumber = number.length();

        int[] value = new int[lengthOfNumber];



        for (int i = lengthOfNumber; i> 0;i-=1) {
            if (number.charAt(i-1)==('I'))
                value [i-1]= 1;
            else if (number.charAt(i -1)==('V'))
                value [i-1]= 5;
            else if (number.charAt(i -1)==('X'))
                value [i-1]= 10;
            else if (number.charAt(i -1)==('L'))
                value [i-1]= 50;
            else if (number.charAt(i -1)==('C'))
                value [i-1]= 100;
            else if (number.charAt(i -1)==('D'))
                value [i-1]= 500;
            else if (number.charAt(i -1)==('M'))
                value [i-1]= 1000;
            else
                return -1;
        }

        for(int i = 0; i < lengthOfNumber -3; i+=1){
            if(value [i] == value[i+1] && value [i+1] == value[i+2] && value [i+2] == value[i+3]){
                return -1;
            }
        }



        int total = value [lengthOfNumber-1];
        for (int i = lengthOfNumber;i > 1;i-=1) {
            if (value[i -1] <= value[i - 2]){
                total+=value[i-2];
            }
            if (value[i -1 ] > value[i - 2]){
                total-=value[i-2];
            }

        }


        return total;
    }

    public static void main(String[] argv) {

        System.out.println("parse() tests:\n");


       int cmParse = parse("CM");
        if(cmParse == 900) {
            System.out.println("CM: Success");
        }else{
            System.out.println("CM: Fail " + cmParse);
        }

        int cdParse = parse("CD");
        if(cdParse == 400) {
            System.out.println("CD: Success");
        }else{
            System.out.println("CD: Fail " + cdParse);
        }

        int xcParse = parse("XC");
        if(xcParse == 90) {
            System.out.println("XC: Success");
        }else{
            System.out.println("XC: Fail " + xcParse);
        }

        int xlParse = parse("XL");
        if(xlParse == 40) {
            System.out.println("XL: Success");
        }else{
            System.out.println("XL: Fail " + xlParse);
        }

        int ixParse = parse("IX");
        if(ixParse == 9) {
            System.out.println("IX: Success");
        }else{
            System.out.println("IX: Fail " + ixParse);
        }

        int ivParse = parse("IV");
        if(ivParse == 4) {
            System.out.println("IV: Success");
        }else{
            System.out.println("IV: Fail " + ivParse);
        }


        int notRoman = parse("banana");

        if(notRoman == -1) {
            System.out.println("Not Roman Input: Success");
        }else{
            System.out.println("Not Roman Input: Fail " + notRoman);
        }

        int improperRoman = parse("IIII");

        if(improperRoman == -1) {
            System.out.println("Improper Roman Input: Success");
        }else{
            System.out.println("Improper Roman Input: Fail " + improperRoman);
        }

        System.out.println("\nformat() tests:\n");


        String cmFormat = format(900);
        if(cmFormat.equals("CM")) {
            System.out.println("CM: Success");
        }else{
            System.out.println("CM: Fail " + cmFormat);
        }

        String cdFormat = format(400);
        if(cdFormat.equals("CD")) {
            System.out.println("CD: Success");
        }else{
            System.out.println("CD: Fail " + cdFormat);
        }

        String xcFormat = format(90);
        if(xcFormat.equals("XC")) {
            System.out.println("XC: Success");
        }else{
            System.out.println("XC: Fail " + xcFormat);
        }

        String xlFormat = format(40);
        if(xlFormat.equals("XL")) {
            System.out.println("XL: Success");
        }else{
            System.out.println("XL: Fail " + xlFormat);
        }

        String ixFormat = format(9);
        if(ixFormat.equals("IX")) {
            System.out.println("IX: Success");
        }else{
            System.out.println("IX: Fail " + ixFormat);
        }

        String ivFormat = format(4);
        if(ivFormat.equals("IV")) {
            System.out.println("IV: Success");
        }else{
            System.out.println("IV: Fail " + ivFormat);
        }

    }
}
