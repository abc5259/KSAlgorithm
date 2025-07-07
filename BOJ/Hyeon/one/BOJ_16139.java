package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] sum = new int[s.length() + 1][26];

        for (int i = 1; i <= s.length(); i++) {
            int searchChar = s.charAt(i - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                int before = sum[i - 1][j];
                if (j == searchChar) {
                    sum[i][j]++;
                }
                sum[i][j] += before;
            }
        }

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int idx = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken()) + 1;
            int r = Integer.parseInt(st.nextToken()) + 1;

            sb.append(sum[r][idx] - sum[l - 1][idx]).append("\n");
        }
        System.out.println(sb);
    }
}

// S1 인간-컴퓨터 상호작용 누적합
// 일단 풀었다.