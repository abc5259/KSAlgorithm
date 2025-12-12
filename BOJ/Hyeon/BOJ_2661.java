package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2661 {
    static int N;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        res = new int[N];
        sb = new StringBuilder();

        dfs(0, 0);
    }

    static void dfs(int depth, int value) {
        if (depth == N) {
            for (int val : res) {
                sb.append(val);
            }
            System.out.print(sb);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (i == value) {
                continue;
            }
            res[depth] = i;

            if (check(depth)) {
                dfs(depth + 1, i);
            }
        }
    }

    static boolean check(int depth) {

        for (int s = 2; s <= (depth + 1) / 2; s++) {
            boolean isSame = true;

            for (int i = 0; i < s; i++) {
                int left = depth - s - i;
                int right = depth - i;

                if (res[left] != res[right]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return false;
            }
        }
        return true;
    }
}
// G4 좋은수열 백트래킹 DFS
// 1시간 18분
// trouble shooting
// 인접하지 않으면 애초에 검사 대상이 아님
// 나쁜 수열 기준 : 인접하고 + 같은 숫자 반복 1자리든 그 이상이든
// 그래서 나는 check 를 통해서 더 재귀하는것을 고려하기로 했고
// 이전에 나온값을 가지치기할 때 기억해야되기 때문에 visit 를 안쓰고 또 before 를 만들어서 쓰는거 또한
// 같은 가지치기 가 아닌 인덱스 중복을 피하기 위한 것이기에 안썼다
// 그리고 BFS 처럼 최초 발견시 끝인 문제라서 System.exit(0) 으로 탈출 조건을 만들었다
// check 구현이 까다로웠는데
// 이게 res 가 맨 마지막 수가 추가될 때마다 검사를해야된다 왜냐하면 그전까지는 통과했으니까 그까지 갔으니까
// 그래서 각 좌표별로 투 포인터 개념으로 검사했다.