package silverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1021
public class RotationQueue {
    static Deque<Integer> deq;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] findNums = new int[m];
        deq = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            findNums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : findNums) {
            if (checkFirst() == i) deq.removeFirst();
            else {
                int index = findIndex(i);
                if ((deq.size()/2) <= index) {
                    while (checkFirst() != i) {
                        rightMove();
                    }
                    deq.removeFirst();
                } else {
                    while (checkFirst() != i) {
                        leftMove();
                    }
                    deq.removeFirst();
                }
            }
        }

        System.out.println(count);
    }

    // 2번 연산
    private static void leftMove() {
        deq.addLast(deq.pollFirst());
        count++;
    }

    // 3번 연산
    private static void rightMove() {
        deq.addFirst(deq.pollLast());
        count++;
    }

    // 첫 번째 값 리턴 (NullPointerException 방지)
    private static int checkFirst() {
        return deq.peekFirst() == null ? -1 : deq.peekFirst();
    }

    // 찾아야 되는 값의 인덱스 리턴
    private static int findIndex(int target) {
        int index = 0;
        for (int i : deq) {
            if (i == target) return index;
            index++;
        }
        return -1;
    }
}