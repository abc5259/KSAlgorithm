package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            sb.append(getMaxArea(n, arr)).append("\n");
        }
        System.out.println(sb);
    }

    static long getMaxArea(int n, long[] arr) {
        long maxArea = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int targetIndex = stack.pop();
                long height = arr[targetIndex];

                long width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int targetIndex = stack.pop();
            long height = arr[targetIndex];

            long width;
            if (stack.isEmpty()) {
                width = n;
            } else {
                width = n - stack.peek() - 1;
            }

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
// P5 히스토그램에서 가장 큰 직사각형 스택
// 1시간 40분
// 직사각형 최대 넓이가 100_000 * 1_000_000_000 이므로 long
// 스택에는 막대의 높이가 아닌 인덱스 저장해서 양쪽 파악
// 새로 들어올 막대가 스택 최상단 보다 작으면 확장 불가
// 오른쪽 장애물에 현재 탐색 중인 인덱스 i 왼쪽 장애물 = pop하고
// 스택에 남아있는 다음 인덱스 peek 가로 길이 = i - peek - 1 이 된다
// 스택에 남은 인덱스들은 오른쪽 장애물이 없으므로 오른쪽 장애물을 n으로 두고 진행