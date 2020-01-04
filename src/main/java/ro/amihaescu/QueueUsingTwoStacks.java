package ro.amihaescu;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

        int numberOperations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOperations; i++) {
            String line = scanner.nextLine();
            String[] commands = line.split(" ");
            processCommands(commands, inStack, outStack);
        }
    }

    private static void processCommands(String[] commands, Stack<Integer> inStack, Stack<Integer> outStack) {
        if (commands.length == 2) {
            Integer value = Integer.valueOf(commands[1]);
            inStack.push(value);
        } else {
            String command = commands[0];
            if (outStack.isEmpty()) {
                reverseStacks(inStack, outStack);
            }
            if (!outStack.isEmpty()) {
                if (command.equals("3")) {
                    System.out.println(outStack.peek());
                } else {
                    outStack.pop();
                }
            }
        }
    }

    private static void reverseStacks(Stack<Integer> inStack, Stack<Integer> outStack) {
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
    }
}
