/**
 * 11279 - 최대 힙(S2/우선순위큐) [O|00:06:04]
 * 시도1
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (heap.isEmpty()) System.out.println(0);
                else System.out.println(heap.poll());
            } else {
                heap.add(x);
            }
        }
    }
}
