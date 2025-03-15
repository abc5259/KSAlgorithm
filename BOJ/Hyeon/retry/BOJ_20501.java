package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] friends = new int[2001][64];

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                char num = str.charAt(j - 1);
                if (num == '1') {
                    friends[i][j / 32] |= 1 << (j % 32);
                }
            }
        }
        int Q = Integer.parseInt(br.readLine());

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long sum = 0;

            for (int i = 0; i < 64; i++) {
                sum += Integer.bitCount(friends[a][i] & friends[b][i]);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
// G2 FaceBook 비트연산 = 새로운 풀이
// 걍 개어렵네
// 일단 2000명의 친구관계면 1명의 친구는 2000명과의 관계가 있다 그러면 2진수로 비트연산하면 32자리가 int이고 64는 long이다
// 그러면 64자리마다 1자리에 32개의 비트를 넣을 수 있다. 그럼 64 * 32로 무난하다.
// j번과의 나머지 연산으로 Integer.bitCount 하면된다.