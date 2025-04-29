package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        int cnt = 0;
        while (M-- > 0) {
            if (set.contains(br.readLine())) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}

// S4 문자열 집합 SET
// 집합의 문자열과 주어진 문자열을 비교해서 갯수 구하기
// 그냥 중복없이 하고 contains 써서 쉽게 풀었다.