package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (N-- > 0) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        long res = 0;

        while (pq.size() > 1) {
            int A = pq.poll();
            int B = pq.poll();
            int sum = A + B;
            res += sum;
            pq.offer(sum);
        }

        System.out.println(res);
    }
}

// G4 카드 정렬하기 우선순위 큐
// 문제이해를 너무 늦게해서 오래걸린 문제
// 쉽게 접근했는데 계속해서 히든테케에서 문제가 생겼다
// trouble shooting
// 일단 2개 이상을 이용해야 하고, 1개 있으면 0이 출력되어야 함 비교를 못하기 때문