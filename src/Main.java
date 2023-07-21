import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean complete;

        // Task 1
        Result result = getResult(scanner);

        System.out.println(Math.max(result.num1, result.num2));

        do {
            System.out.println("Give me another number: ");
            String input3 = scanner.nextLine();
            if (isDouble(input3)) {
                double num3 = Double.parseDouble(input3);
                System.out.println(num3 + (num3 % 2 == 0 ? " is even" : " is odd"));
                complete = true;
            } else {
                System.out.println("Please provide a numeric input: " + input3 + " is not numeric");
                complete = false;
            }
        } while (!complete);

        do {
            System.out.println("Give me a traffic light colour: ");
            String colour = scanner.nextLine().toLowerCase();
            if (colour.contains("green") && !colour.contains("amber") && !colour.contains("red")) {
                System.out.println("GO");
                complete = true;
            } else if (!colour.contains("green") && colour.contains("amber") && !colour.contains("red")) {
                System.out.println("SLOW DOWN");
                complete = true;
            } else if (!colour.contains("green") && !colour.contains("amber") && colour.contains("red")) {
                System.out.println("STOP");
                complete = true;
            } else {
                System.out.println("Please enter a colour that can be seen on a traffic light (green, amber or red)");
                complete = false;
            }
        } while (!complete);

        // Task 2
        do {
            System.out.println("Give a number between 1 and 12: ");
            String input4 = scanner.nextLine();
            if (isInteger(input4)) {
                int num4 = Integer.parseInt(input4);
                switch (num4) {
                    case 1:
                    case 2:
                    case 3:
                        System.out.println("Spring");
                        complete = true;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        System.out.println("Summer");
                        complete = true;
                        break;
                    case 7:
                    case 8:
                    case 9:
                        System.out.println("Autumn");
                        complete = true;
                        break;
                    case 10:
                    case 11:
                    case 12:
                        System.out.println("Winter");
                        complete = true;
                        break;
                    default:
                        System.out.println("Please enter a number corresponding to a month (1-12)");
                        complete = false;
                        break;
                }
            } else {
                System.out.println("Please enter a number corresponding to a month (1-12)");
                complete = false;
            }
        } while (!complete);

        // Task 3
        do {
            Result result2 = getResult(scanner);
            System.out.println("Provide an operator: ");
            String operator = scanner.nextLine();
            switch (operator) {
                case "+":
                    System.out.println(result2.num1 + " + " + result2.num2 + " = " + (result2.num1 + result2.num2));
                    complete = true;
                    break;
                case "-":
                    System.out.println(result2.num1 + " - " + result2.num2 + " = " + (result2.num1 - result2.num2));
                    complete = true;
                    break;
                case "*":
                    System.out.println(result2.num1 + " * " + result2.num2 + " = " + (result2.num1 * result2.num2));
                    complete = true;
                    break;
                case "/":
                    System.out.println(result2.num1 + " / " + result2.num2 + " = " + (result2.num1 / result2.num2));
                    complete = true;
                    break;
                case "**":
                    System.out.println(result2.num1 + " to the power of " + result2.num2 + " = " + (Math.pow(result2.num1, result2.num2)));
                    complete = true;
                    break;
                default:
                    System.out.println("Invalid operator provided: please provide a mathemtical operator (+ - * / **)");
                    complete = false;
                    break;
            }
        } while (!complete);

    }

    private static Result getResult(Scanner scanner) {
        boolean complete;
        double num1 = 0;
        double num2 = 0;
        do {
            System.out.println("Give me 2 numbers: ");
            String input1 = scanner.nextLine();
            if (isDouble(input1)) num1 = Double.parseDouble(input1);
            else {
                System.out.println("Please provide a numeric input: " + input1 + " is not numeric");
                complete = false;
                continue;
            }
            String input2 = scanner.nextLine();
            if (isDouble(input2)) num2 = Double.parseDouble(input2);
            else {
                System.out.println("Please provide a numeric input: " + input2 + " is not numeric");
                complete = false;
                continue;
            }
            complete = true;
        } while (!complete);
        return new Result(num1, num2);
    }

    private static class Result {
        public final double num1;
        public final double num2;

        public Result(double num1, double num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
