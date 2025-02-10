package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<int[]> stack = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek()[1] < height) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0").append(" ");
            } else {
                sb.append(stack.peek()[0]).append(" ");
            }
            stack.push(new int[]{i, height});
        }
        System.out.println(sb);
    }
}
// G5 탑 스택
// 스택을 활용하는 것을 바로 알았다 왜냐하면 시간복잡도가 N은 500,000 인데 O(N^2)의 완전 탐색의 경우 시간초과가 나기 때문
// 그래서 스택을 사용했고 ArrayDeque 를 사용했다.
// 다만 출력 문이 인덱스를 출력하고 있어서 계속해서 인덱스가 걸렸다.
// 인덱스 값을 저장해두는 배열과 스택을 같이 쓰기엔 문제가 되어서 이를 구하기 위해 스택에 인덱스와 높이를 둘다 넣을 수 밖에 없었다.
// 그리고 스택에 2가지 정수를 가지는 배열을 만드는데 이를 이용하기 위해 int [] 를 제네릭으로 선언하고
// push 할 때마다 new int[]{,}로 배열을 만들어주면서 푸시했다.