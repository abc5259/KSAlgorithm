package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int tip = Integer.parseInt(br.readLine());
            pq.offer(tip);
        }

        long max = 0;

        for (int i = 0; i < N; i++) {
            int tip = pq.poll() - i;
            if (tip > 0) {
                max += tip;
            }
        }

        System.out.println(max);
    }
}
// S4 알바생 강호 그리
// 6분
// 그냥 순서대로 들어오는 팁에 있어서 가장 많은 팁부터 받을 수 있게 PQ 자료구조를 사용하고
// reverseOrder 옵션으로 내림차순으로 구함
// 그리고 10만번 사람이 올 수 있고 팁은 10만까지 가능해서 점차 깎이기 떄문에 500억쯤 예상 가능 그래서 long 사용함
// 등수별로 차감해서 0보다 클때만 누적해서 연산