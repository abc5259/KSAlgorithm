package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1351 {
    static HashMap<Long, Long> map;
    static int P, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(dp(N));
    }

    static long dp(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long value = dp(n / P) + dp(n / Q);
        map.put(n, value);
        return value;
    }
}

// G5 무한 수열 DP + HashMap
// 일단 입력값과 연산 값이 int범위를 넘어가서 long으로 해야됨
// parseLong 주의하고
// map 을 이용한 dp 이다. 왜냐하면 인덱스와 밸류를 동시에 가져야 하기에 인덱스를 키값으로 쓰고 dp의 연산결과를 value로 가지는
// 해쉬맵을 사용함
// 시간초과 N이 1조라서 반복문 불가 무조건 재귀 DP 사용
// 근데 기저조건 걸어서 map에 가지고 있으면 바로 가져옴
// 아니면 연산 재귀로 한다음에 map에 값 넣고 return 함

