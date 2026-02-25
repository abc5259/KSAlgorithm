package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long tmp = pq.poll() + pq.poll();
            pq.offer(tmp);
            pq.offer(tmp);
        }

        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }

        System.out.println(res);
    }
}
// S2 카드 합체 놀이 그리디
// 27분
// 개 뻘짓했다. 힙연산 시간복잡도 착각함
// n 이 1000이라서 우선순위 큐에 계속 넣음 이는 n log n
// 그리고 나서 m 번 15000번 기준으로 pq.poll 을 2번씩함 이는 m 번 반복에서 힙연산 log n 해서 m log n
// res 에 더할때 n log n
// trouble shooting
// 일단 PQ가 안되는줄알고 Arrays.sort 해서 0번 1번 인덱스의 합으로 가려했는데
// 그러니까 시간초과였다 그리고 15000번 반복해서 더하는데 백만까지의 숫자를 그래서 int 의 오버플로우가 발생한다
// 이는 int 배열에 있어서도 문제였다
// a가 100만 까지 가능하고 m번 연산해서 더하다보니 long 으로 일어났다.