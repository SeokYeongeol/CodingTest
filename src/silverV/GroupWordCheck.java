package silverV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 1316
public class GroupWordCheck {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Input
        int input = Integer.parseInt(st.nextToken());
        String[] groupWords = new String[input];
        for (int i = 0; i < input; i++) {
            st = new StringTokenizer(br.readLine());
            groupWords[i] = st.nextToken();
        }

        // Logic
        int count = 0;
        for (int i = 0; i < input; i++) {
            Stack<Character> stack = new Stack<>();
            stack.push(groupWords[i].charAt(0));
            boolean flag = true;
            for (int j = 1; j < groupWords[i].length(); j++) {
                if (stack.peek() == groupWords[i].charAt(j)) {
                    continue;
                }
                if (stack.contains(groupWords[i].charAt(j))) {
                    flag = false;
                    break;
                }
                stack.push(groupWords[i].charAt(j));
            }
            if (flag) count++;
        }
        System.out.println(count);
    }
}
