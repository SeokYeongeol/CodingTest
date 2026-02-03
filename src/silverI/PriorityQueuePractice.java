package silverI;

import java.util.*;
import java.io.*;
import java.lang.*;

// 백준 11286
public class PriorityQueuePractice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if (firstAbs == secondAbs) {
                return o1 - o2;     // if o1 - o2 양수 : o1 > o2
            }
            return firstAbs - secondAbs;
        });

        for (int i = 0; i < n; i++) {
            int req = arr[i];
            if (req == 0) {
                if (pq.isEmpty()) System.out.println("0");
                else System.out.println(pq.poll());
            } else {
                pq.add(req);
            }
        }
    }
}