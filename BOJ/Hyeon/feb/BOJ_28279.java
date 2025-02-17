package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayDeque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "1":
                    deque.offerFirst(st.nextToken());
                    break;
                case "2":
                    deque.offerLast(st.nextToken());
                    break;
                case "3":
                    sb.append(!deque.isEmpty() ? deque.pollFirst() : -1).append("\n");
                    break;
                case "4":
                    sb.append(!deque.isEmpty() ? deque.pollLast() : -1).append("\n");
                    break;
                case "5":
                    sb.append(deque.size()).append("\n");
                    break;
                case "6":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "7":
                    sb.append(!deque.isEmpty() ? deque.peekFirst() : -1).append("\n");
                    break;
                case "8":
                    sb.append(!deque.isEmpty() ? deque.peekLast() : -1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

// S4 덱2 덱
// 개 쉽게 풀었다.
// deque의 사용방법에 관련된 메소드들을 익히는 문제

// 덱 자료구조 그림그려보기
