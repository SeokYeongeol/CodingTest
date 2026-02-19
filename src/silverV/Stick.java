package silverV;


import java.io.IOException;
import java.util.Scanner;

// 백준 1094
public class Stick {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int cnt = 1;
        int stick = 64;

        if (x == stick) {
            System.out.println(cnt);
            return;
        }
        while (x != 0) {
            stick /= 2;
            if (x == stick) {
                break;
            } else if (x > stick){
                x -= stick;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}