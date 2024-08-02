/**
 * 1781 - 컵라면 [성공|00:18:12]
 * 골드2, 그리디, 시도2
 * 
 * 이전에 푼거랑 비슷한 문제
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1781 {
    // 시간제한 2초, 메모리제한 256MB
    // N개의 문제.
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] problem = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problem[i][0] = Integer.parseInt(st.nextToken());
            problem[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(problem, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(problem[i][1]);
            if (problem[i][0] < pq.size()) pq.poll();
        }

        int ret = 0;
        while (!pq.isEmpty()) ret += pq.poll();
        System.out.println(ret);
    }
}
