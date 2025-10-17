package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class BOJ_2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (check(c)) {
                    sb.append(c);
                } else {
                    if (sb.length() > 0) {
                        pq.offer(new BigInteger(sb.toString()));
                        sb = new StringBuilder();
                    }
                }
            }
            if (sb.length() > 0) {
                pq.offer(new BigInteger(sb.toString()));
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    private static boolean check(char c) {
        return ('0' <= c) && (c <= '9');
    }
}
// S4 수학숙제 우선순위 큐
// 15분
// 그냥 각 스트링빌더의 길이를 통해서 비교해서 문자열을 만든다.