// 우선순위 큐 - boj.kr/1715 카드 정렬하기
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pqLowest = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pqLowest.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while (true) {
            int q1 = pqLowest.remove();
            if (pqLowest.isEmpty())
                break;
            int q2 = pqLowest.remove();

            ans += (q1 + q2);
            pqLowest.add(q1+q2);
        }

        System.out.println(ans);
    }
}
