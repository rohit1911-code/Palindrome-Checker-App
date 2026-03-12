import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        String input = scanner.nextLine().toLowerCase();

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy twoPointerStrategy = new TwoPointerStrategy();

        long start1 = System.nanoTime();
        boolean result1 = stackStrategy.check(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = twoPointerStrategy.check(input);
        long end2 = System.nanoTime();

        System.out.println("Stack Strategy Result: " + result1);
        System.out.println("Stack Execution Time: " + (end1 - start1) + " ns");


        scanner.close();
    }
}

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

class TwoPointerStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;

    }
}