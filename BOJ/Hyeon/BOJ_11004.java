package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        while (K-- > 1) {
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}
// S5 K번째 수 정렬 복습
// 5분
// 일단 다시 풀었는데 Arrays.sort 가 시간초과가 날거 같았다 왜냐하면
// 시간복잡도가 500만인데 최악을 고려한다면 O(N^2) 듀얼 피벗 퀵정렬을 써서
// List 를 통해 Collections.sort 를 해버린다면 타임정렬을 한다.최악의상황이어도 N log N
// PQ의 힙정렬 또한 마찬가지 N log N 이다. 그리고 K 만큼 반복 O(K)