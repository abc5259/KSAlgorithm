package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.peekLast()[0] > num) {
                deque.pollLast();
            }
            deque.offer(new int[]{num, i});

            if (i - deque.peekFirst()[1] >= L) {
                deque.pollFirst();
            }
            sb.append(deque.peek()[0]).append(" ");
        }
        System.out.println(sb);
    }
}

// P4 최솟값 찾기 덱, 슬라이딩 윈도우
// 조건을 걸어서 최소값을 구하는 문제
// 덱의 가장 앞에 최소값을 놓고 이게 오름차순정렬이 되게끔만든다음
// 맨 끝에있는게 입력값보다 크면 계속해서 빼주고
// 그다음에 맨끝보다 큰 값이 오면 덱에 넣어준다
// 최소값이 인덱스 연산해서 조건에 일치하지 않으면 poll하고 그다음의 최소값을 출력한다.