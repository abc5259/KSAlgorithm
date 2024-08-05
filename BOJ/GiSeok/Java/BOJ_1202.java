/**
 * 1202 - 보석 도둑 [실패|01:22:20]
 * 골드2, 그리디, 시도14
 * 
 * 다 해놓고 반복문을 잘못만듦
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
    // 시간제한 1초, 메모리제한 256MB
    // 보석이 총 N개
    // 보석은 무게 M, 가격 V
    // 가방은 K개, 각 가방에 담을 수 있는 최대무게 C
    // 가방에는 1개의 보석만 가능
    // 상덕이가 훔칠 수 있는 보석의 최대 가격은?
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] gems = new long[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i][0] = Long.parseLong(st.nextToken());
            gems[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(gems, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)((o1[0] == o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0]);
            }
        });

        long[] bags = new long[K];
        for (int i = 0; i < K; i++)
            bags[i] = Long.parseLong(br.readLine());

        Arrays.sort(bags);

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int idx = 0;
        for (int k = 0; k < K; k++) {
            while (idx < N && gems[idx][0] <= bags[k]) pq.add(gems[idx++][1]);
            if (!pq.isEmpty()) sum += pq.poll(); 
        }

        System.out.println(sum);
    }
}
