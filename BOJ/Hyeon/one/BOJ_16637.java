package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637 {
    static int N, res;
    static char[] problem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        problem = br.readLine().toCharArray();

        res = Integer.MIN_VALUE;
        dfs(2, problem[0] - '0');
        System.out.print(res);
    }

    private static void dfs(int idx, int total) {
        if (idx >= N) {
            res = Math.max(total, res);
            return;
        }
        dfs(idx + 2, cal(total, problem[idx] - '0', problem[idx - 1]));

        if (idx + 2 < N) {
            int right = cal(problem[idx] - '0', problem[idx + 2] - '0', problem[idx + 1]);

            int left = cal(total, right, problem[idx - 1]);
            dfs(idx + 4, left);
        }
    }

    private static int cal(int i, int j, char op) {
        switch (op) {
            case '+':
                return i + j;
            case '-':
                return i - j;
            default:
                return i * j;
        }
    }
}

// G3 괄호 추가하기 DFS
// 일단 DFS 를 통해서 괄호를 만드냐 안만드냐로 따져서 분기하면된다.
// 괄호 연산인데 우선순위가 없기 때문에 2번째 인덱스부터 시작해도된다 왜냐하면 0번재부터 시작하던 2번째부터 시작하던 0 ~2는 연산을 반드시 해야되기에
// 일단 2부터 시작하고 total로 현재까지의 합을 0번인덱스의 값으로 설정한다.
// 그리고 N이 1일경우는 바로 탈출조건을 통해서 0번의 인덱스값을 가지게 된다
// 2번째 인덱스에서 괄호를 열지 않을 경우에는
// -2 번째 인덱스부터 -1번째의 연산자를 통해 연산한 값을 total에 저장해두고 idx+2 로 다음 인덱스를 재귀한다

// 괄호를 열 경우에는 괄호를 열기 이전까지의 total과 현재 괄호를 열고 +2인덱스와 +1연산자를 이용한 값의 결과를 가지고
// +4 idx 로 이동해서 재귀한다.