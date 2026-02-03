package silverII;

import java.util.Scanner;

// 백준 1874
public class StackPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int[] arr = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = sc.nextInt();
        }

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int num = 1;
        boolean flag = true;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < capacity; i++) {
            if (arr[i] >= num) {
                while (arr[i] >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int containsNum = stack.pop();
                if (containsNum > arr[i]) {
                    System.out.println("No");
                    flag = false;
                    break;
                } else sb.append("-\n");
            }
        }

        if (flag) System.out.println(sb);
    }
}
