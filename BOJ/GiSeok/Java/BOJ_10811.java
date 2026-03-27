package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        for (int x = 0; x < n; x++) num[x] = x+1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken()) - 1;
            int idx2 = Integer.parseInt(st.nextToken()) - 1;

            while (idx1 < idx2) {
                int tmp = num[idx1];
                num[idx1] = num[idx2];
                num[idx2] = tmp;
                idx1++;
                idx2--;
            }
        }

        for (int x = 0; x < n; x++) {
            System.out.print(num[x] + " ");
        }
        System.out.println();
    }
}
