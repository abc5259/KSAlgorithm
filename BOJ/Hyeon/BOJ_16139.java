package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[][] sum = new int[str.length() + 1][26];

        for (int i = 1; i <= str.length(); i++) {
            int tmp = str.charAt(i - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                if (tmp == j) {
                    sum[i][j]++;
                }
                if (sum[i - 1][j] != 0) {
                    sum[i][j] += sum[i - 1][j];
                }
            }
        }

        int cnt = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (cnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int al = st.nextToken().charAt(0) - 'a';
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken()) + 1;

            sb.append(sum[to][al] - sum[from][al]).append("\n");
        }
        System.out.println(sb);
    }
}
// S1 인간-컴퓨터 상호작용 누적합
// 범위가 20만 * 20만 이어서 400억 시간 복잡도를 통해서 하면 정답이 안된다.
// 일단 그래서 2차원 배열을 통해 알파벳의 갯수들을 누적해서 저장한다음
// ex) from, to 행 배열에서 알파벳을 열 배열로 잡고
// from substring 하듯 하면된다. 그래서 from 은 그전 칸이 가지고있는 배열 누적합 개수
// to는 현재 누적합 개수를 통해서 뺄셈으로 현재 가지고 있는 수를 구할 수 있다
// 이를 통해서 20만 * 26 배열을 통해 누적합을 만들고 cnt 로 20만 반복문으로 시간초과가 안된다.