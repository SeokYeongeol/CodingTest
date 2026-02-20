package silverV;

import java.util.Scanner;

// 백준 1543
public class DocumentSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String document = sc.nextLine();
        String searchWord = sc.nextLine();
        int cnt = 0;

        int len = document.length() - searchWord.length();
        for (int i = 0; i <= len; i++) {
            if (document.startsWith(searchWord, i)) {
                cnt++;
                i += searchWord.length()-1;
            }
        }
        System.out.println(cnt);
    }
}
