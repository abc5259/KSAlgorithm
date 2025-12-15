package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10597 {
    static int N;
    static int[] res;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();
        if (len < 10) {
            N = len;
        } else {
            N = (len - 9) / 2 + 9;
        }

        res = new int[N];
        visit = new boolean[N + 1];

        dfs(str, 0);
    }

    static void dfs(String str, int idx) {
        if (idx == N) {
            if (!str.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int val : res) {
                sb.append(val).append(" ");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (!str.isEmpty()) {
            int value = Integer.parseInt(str.substring(0, 1));

            if (value > 0 && value <= N && !visit[value]) {
                visit[value] = true;
                res[idx] = value;
                dfs(str.substring(1), idx + 1);
                visit[value] = false;
            }
        }

        if (str.length() >= 2) {
            int value = Integer.parseInt(str.substring(0, 2));
            if (value > 0 && value <= N && !visit[value]) {
                visit[value] = true;
                res[idx] = value;
                dfs(str.substring(2), idx + 1);
                visit[value] = false;
            }
        }
    }
}
// G5 순열장난 백트래킹 DFS
// 1시간 10분
// trouble shooting
// 1. substring 무를 썰기 전에 무가 있는지 확인 StringIndexOutOfBounds
// -> substring 을 쓰면서 길이 체크를 해야된다 마치 자료구조의 pop 할 때 size를 보듯이
// 2. 막다른 길만 막아야함
// -> 1자리 수가 안됐을 경우 2자리를 봐야하는데 그냥 return 으로 탈출시킴
// 3. 흔적 지우기 즉 백트래킹
// -> visit[false] 해줘야함.
// 4. ArrayOutOfBounds Exception
// -> Integer.parseInt 의 값을 반환할 때 Array의 인덱스 내에 있는지도 체크해야함.