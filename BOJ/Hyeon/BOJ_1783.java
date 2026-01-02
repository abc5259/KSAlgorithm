package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int res;

        if (N == 1) {
            res = 1;
        } else if (N == 2) {
            res = Math.min(4, (M + 1) / 2);
        } else {
            if (M < 7) {
                res = Math.min(4, M);
            } else {
                res = M - 2;
            }
        }
        System.out.println(res);
    }
}
// S3 병든 나이트 그리디
// 45분
// N이 20억 M이 20억이라서 뭘해도 시간복잡도가 안될 거 같아가지고 O(1) 이라는것을 늦게 깨달았다.
// 그럼 그리디로 접근해야 했고 N에 대한 조건을 걸어서 해야됐다
// 4개 이상을 뽑으려면 최소한의 M의 길이가 7이었다.