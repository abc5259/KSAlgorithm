package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] sol = new int[n];
        for (int i = 0; i < n; i++) {
            sol[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();

        int idx = 0;

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+").append("\n");
            while (!stack.isEmpty() && stack.peek() == sol[idx]) {
                stack.pop();
                idx++;
                sb.append("-").append("\n");
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
// S2 스택 수열 스택
// 쉽게 풀었다. 그냥 문제이해가 오래걸렸을 뿐
// 입력된 문자열이 나오게끔 1~n 까지의 배열과 비교해서 인덱스를 조정해주면서 출력하면된다.
// 주어진 순열을 못만드는 경우 스택에 남게 된다. 그래서 NO를 출력하고 아니면 push 와 pop을 출력한다.