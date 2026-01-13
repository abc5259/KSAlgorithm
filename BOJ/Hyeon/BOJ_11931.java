package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (N-- > 0) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
// S5 수 정렬하기 4 우선순위 큐
// 4분
// Arrays.sort 의 듀얼 피벗 퀵 정렬 방식은 N의 최악을 고려했을 때 시간복잡도는 N^2라서
// heap 정렬을 통해서 N log N 이 되게끔 PQ 를 통해서 했다.
// Collections sort 는 TimSort 방식으로 N log N 으로 같다.