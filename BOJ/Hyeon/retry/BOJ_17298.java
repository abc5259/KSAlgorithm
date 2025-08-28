package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 아직 오큰수를 찾지 못한 숫자의 인덱스를 스택에 저장
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int O : arr) {
            sb.append(O).append(" ");
        }
        System.out.print(sb);
    }
}
// G5 오큰수 스택
// 스택에는 아직 오큰수를 못찾은 숫자의 인덱스를 관리한다.
// 그래서 스택으로 가장 큰 오큰수 찾으면 걔부터 다 채워진다. 끝부분 부터인셈이지
// 그리고 현재 인덱스를 stack 에 push 해서 미래에 자신의 오큰수를 찾게 한다.
// 탐색 다 끝나고 마지막 수는 -1 로 덮어쓰고 스택에서 뺴낸다.
// 그리고 iter 으로 출력.