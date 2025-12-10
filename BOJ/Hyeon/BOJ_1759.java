package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static int L, C;
    static char[] line;
    static char[] res;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        line = new char[C];
        res = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            line[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(line);

        sb = new StringBuilder();

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == L) {
            if (check(res)) {
                for (char val : res) {
                    sb.append(val);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            res[depth] = line[i];
            dfs(depth + 1, i + 1);
        }
    }

    static boolean check(char[] res) {
        int v = 0, c = 0;

        for (char word : res) {
            if (word == 'a' || word == 'i' || word == 'o' || word == 'u' || word == 'e') {
                v++;
            } else {
                c++;
            }
            if (v >= 1 && c >= 2) {
                return true;
            }
        }
        return false;
    }
}
// G5 암호 만들기 백트래킹 DFS
// 30분
// trouble shooting
// 이거 문제가 내가 잘못 이해했다 기저 사례를 자음과 모음도 고려했었어야 했다
// 그리고 문제 자체가 오름차순 정렬이어야 돼서 line 이라는 입력값을 정렬해서 넣었고
// 또 나는 0부터 시작해도되는지 알았는데 이전의 값보다 항상 커야되기때문에 만약 내가 맨 앞자리에
// 맨 처음 인덱스를 써서 끝났으면 맨앞자리에 두번째 인덱스가 올텐데 두번째 자리에 첫번째인덱스 값이 오면 안되게
// 내가 현재 두번째 인덱스라는 거를 기억하고 있어야 된다
// 그 값으로 start 를 두었고 또 기저사례에서 정답 탈출 조건을 한번더 걸었다