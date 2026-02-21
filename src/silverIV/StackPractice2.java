package silverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 10828
public class StackPractice2 {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Input
        int commandSize = Integer.parseInt(st.nextToken());
        String[] command = new String[commandSize];

        // Input + Logic
        for (int i = 0; i < commandSize; i++) {
            st = new StringTokenizer(br.readLine());
            command[i] = st.nextToken();
            if (command[i].equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            switch (command[i]) {
                case "top" -> System.out.println(top(stack));
                case "empty" -> System.out.println(empty(stack));
                case "pop" -> System.out.println(pop(stack));
                case "size" -> System.out.println(stack.size());
            }
        }
    }

    // Empty Requirement Function
    private static int empty(Stack<Integer> stack) {
        return stack.isEmpty() ? 1 : 0;
    }

    // Pop Requirement Function
    private static int pop(Stack<Integer> stack) {
        return stack.isEmpty() ? -1 : stack.pop();
    }

    // Top Requirement Function
    private static int top(Stack<Integer> stack) {
        return stack.isEmpty() ? -1 : stack.peek();
    }
}
