package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1354 {
    static int P, Q, x, y;
    static HashMap<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(dp(N));
    }

    static long dp(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 0) {
            return 1;
        }
        long res = dp((n / P) - x) + dp((n / Q) - y);
        map.put(n, res);
        return res;
    }
}

// G5 무한 수열2 DP + HashSet
// 비슷한 문제 기저조건 1개 더 따져야하고 long parseLong 생각해줘야하고
// dp 재귀로 DFS 사용해서 map에 put해주는것
// 그리고 dp의 최종값 산정