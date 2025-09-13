package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BOJ_9009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Integer> fibo = new ArrayList<>();
        fibo.add(0);
        fibo.add(1);

        int i = 1;
        while (fibo.get(i++) <= 1_000_000_000) {
            fibo.add(fibo.get(i - 1) + fibo.get(i - 2));
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();

            for (int j = fibo.size() - 1; j >= 0; j--) {
                if (fibo.get(j) <= n) {
                    n -= fibo.get(j);
                    deque.offerFirst(fibo.get(j));
                }
                if (n == 0) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst()).append(" ");
                    }
                    break;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
// S1 피보나치 그리디
// 바로 풀었다 무조건 발견하는대로 나오는게 그리디니까
// 그래서 먼저 피보나치 배열이 어디까지 가는 지 몰라서 ArrayList 로 만들고
// fibo 가 10억까지는 가야되니까 왜냐하면 입력값이 10억일 수 있어서 그래서 while 조건문에 달고
// i 인덱스부터 점검하면서 값을 add 했다
// 그리고 T 만큼 반복하고 이때 그냥 Deque 썻다 먼저 나오는게 제일 뒤로 가야돼서 스택이랑 뭐 같은 개념이다
// 그래서 n 을 누적차 한다음 offerFirst 뭐 이게 push 랑 같으니까 이거 쓰고 n이 0일때 탈출해서 출력했다.