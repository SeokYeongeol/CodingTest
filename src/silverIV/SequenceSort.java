package silverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1015
public class SequenceSort {

    static class Node {
        int value, index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Node[] arrA = new Node[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = new Node(Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(arrA, Comparator.comparingInt(o -> o.value));

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[arrA[i].index] = i;
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}