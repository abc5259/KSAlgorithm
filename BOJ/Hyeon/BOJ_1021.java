package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int res = 0;
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            deque.offer(i);
        }

        for (int i = 0; i < M; i++) {
            int idx = deque.indexOf(arr[i]);

            if (idx <= deque.size() / 2) {
                for (int j = 0; j < idx; j++) {
                    deque.offerLast(deque.pollFirst());
                    res++;
                }
            } else {
                for (int j = deque.size() - 1; j >= idx; j--) {
                    deque.offerFirst(deque.pollLast());
                    res++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(res);
    }
}

// S3 회전하는 큐 덱
// 덱 개념을 활용하고, 중간값과 비교해서 이보다 작으면 앞에서 뒤에서 하는 개념은 이해했지만
// 구현이 너무 오래걸렸다.
// 일단 indexOf()를 생각못해낸게 크다.
// 리스트 컬렉션에서 indexOf로 찾고자 하는 값의 인덱스를 구할 수 있었고 이와 비교하여 앞 뒤를 하면된다.
// 빼는것은 횟수가 아니기에 따로 빼주고
// 2번 3번 동작을 각각 분리하였다.
// 그리고 뒤에서 빼서 앞으로 오는 3번의 경우 찾고자 하는 값도 가져와야 해서 j>=idx 했다.