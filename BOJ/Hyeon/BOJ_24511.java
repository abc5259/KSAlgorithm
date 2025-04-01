package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) != 0) {
                st2.nextToken();
                continue;
            }
            deque.offerFirst(Integer.parseInt(st2.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            deque.offer(Integer.parseInt(st.nextToken()));
            sb.append(deque.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}

// S3 queuestack 덱
// 풀었다. 일단 스택은 출력문에 영향이 없다는 것을 빨리 파악해야 한다.
// 시간복잡도가 O(N^2)이 될 경우 10만으로 주어져있기 떄문에 시간초과를 야기한다. 그래서
// 반복문이 아니다는 것을 파악해야하고, 이때 큐의 값이 OFFERFIRST를 통해 출력되는것을 파악했다.
// 그래서 M번 반복마다 큐에서 하나씩 빼고 뒤로는 M의 값을 채워넣는다.