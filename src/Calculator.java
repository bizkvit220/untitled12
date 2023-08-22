import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner str = new Scanner(System.in);
        System.out.println("Input: ");
        String inputStr = str.nextLine();
        System.out.println("\n" + "Output: ");

        String operatorStr = "";
        char[] symbol = new char[10];
        char operator = '+';
        for (int i=1; i < inputStr.length(); i++) {

            symbol[i] = inputStr.charAt(i);
            if (symbol[i] == '+'){
                operator = '+'; operatorStr = "\\+";
            }
            if (symbol[i] == '-'){
                operator = '-'; operatorStr = "-";
            }
            if (symbol[i] == '*'){
                operator = '*'; operatorStr = "\\*";
            }
            if (symbol[i] == '/'){
                operator = '/'; operatorStr = "/";
            }
        }

        int arg1 = 0;
        int arg2 = 0;
        int result = 0;
        int resultArabic = 0;

        String[] numbers = inputStr.split(operatorStr);
        if (numbers.length > 2) {
            System.out.println("throws Exception");
            System.exit(0);
        }
        try{
            arg1 = romanNumber(numbers[0]);
            arg2 = romanNumber(numbers[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("throws Exception");
            System.exit(0);
        }
        if (arg1 == 0 | arg2 == 0) {
            result = 0;
            try {
                arg1 = Integer.parseInt(numbers[0]);
                arg2 = Integer.parseInt(numbers[1]);
                if (arg1 > 10 | arg2 > 10 | arg1 < 0 | arg2 <0) {
                    System.out.println("throws Exception");
                    System.exit(0);
                }
                resultArabic = calculate(arg1, arg2, operator);
                System.out.println(resultArabic);
            } catch (NumberFormatException e) {
                System.out.println("throws Exception");
            } catch (ArithmeticException e) {
                System.out.println("throws Exception");
            }
        } else {
            try {
                result = calculate(arg1, arg2, operator);
                if (result == 0) {
                    System.exit(0);
                }
                String resultRoman = romanSolution(result);
                System.out.println(resultRoman);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("throws Exception");
            }
        }
    }

    public static int calculate(int a, int b, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                break;
        }
        return result;
    }

    public static int romanNumber(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("i")) {
            return 1;
        }else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("ii")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("iii")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("iv")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("v")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("vi")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("vii")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("viii")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("ix")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else if (roman.equals("x")) {
            return 10;
        } else {
            return 0;
        }
    }

    public static String romanSolution(int arabic) {
        String[] romanChars = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        String n = romanChars[arabic];
        return n;

    }
}