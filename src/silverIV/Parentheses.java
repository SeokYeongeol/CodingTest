package silverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 9012
public class Parentheses {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Input
        int input = Integer.parseInt(st.nextToken());
        String[] parentheses = new String[input];
        for (int i = 0; i < input; i++) {
            st = new StringTokenizer(br.readLine());
            parentheses[i] = st.nextToken();
        }

        // Logic
        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i].charAt(0) == ')') {
                System.out.println("NO");
                continue;
            }
            Stack<String> stack = new Stack<>();
            boolean flag = true;
            for (int j = 0; j < parentheses[i].length(); j++) {
                if (parentheses[i].charAt(j) == '(') stack.push("V");
                else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty() && flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}