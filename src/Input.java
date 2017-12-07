import java.util.Scanner;

public class Input {
    private Scanner scan;

    public Input() {
        this.scan = new Scanner(System.in);
    }

    public String getString() {
        return this.scan.nextLine();
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return this.scan.nextLine();
    }

    public int getInt(int i, int i1) {

    }
//
//
//    public boolean yesNo() {
//        String input = this.scan.next();
//        if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean yesNo(String prompt) {
//        System.out.println(prompt);
//        String input = this.scan.next();
//        if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public int getInt(int min, int max) {
//        System.out.println("Please input an integer between " + min + " and " + max);
//
//        int userInput = this.getInt();
//
//        if(userInput > max || userInput < min) {
//            return getInt(min, max);
//        } else {
//            return userInput;
//        }
//    }
//
//    public int getInt(int min, int max, String prompt) {
//        System.out.println(prompt);
//
//        int userInput = this.getInt();
//
//        if(userInput > max || userInput < min) {
//            return getInt(min, max);
//        } else {
//            return userInput;
//        }
//    }
////
////    public int getInt() {
////        String userInput = this.scan.next();
////        int userInt = Integer.valueOf(userInput);
////        try {
////            return Integer.valueOf(userInput);
////        } catch (NumberFormatException e) {
////            System.out.println("Your input must be a number");
////            System.out.println(e.getMessage());
////            return.getInt();
////        }
////    }
//
//    public int getInt(String prompt) {
//        System.out.println(prompt);
//        return this.scan.nextInt();
//    }
//
//    public double getDouble(double min, double max) {
//        System.out.println("Please input an decimal number between " + min + " and " + max);
//
//        double userInput = this.getDouble();
//
//        if(userInput > max || userInput < min) {
//            return getDouble(min, max);
//        } else {
//            return userInput;
//        }
//    }
//
//    public double getDouble(double min, double max, String prompt) {
//        System.out.println(prompt);
//
//        double userInput = this.getDouble();
//
//        if(userInput > max || userInput < min) {
//            return getDouble(min, max);
//        } else {
//            return userInput;
//        }
//    }
//
//    public double getDouble() {
//
//    }
//
//    public double getDouble() {
//        return this.scan.nextDouble();
//    }
//
//    public double getDouble(String prompt) {
//        System.out.println(prompt);
//        return this.scan.nextDouble();
//    }
}