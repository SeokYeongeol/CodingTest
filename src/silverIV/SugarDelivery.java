package silverIV;

import java.util.Scanner;

// 백준 2839
public class SugarDelivery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        while (N >= 0) {
            if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                return;
            }
            N -= 3;
            count++;
        }
        System.out.println(-1);
    }
}