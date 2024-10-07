/**
 * 20934. 방울 마술(D3|구현) [O|00:05:00]
 * 시도1
 */
package Swea.Giseok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_20934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int K = Integer.parseInt(st.nextToken());

            int idx = s.indexOf("o");

            for (int k = 0; k < K; k++) {
                if (idx == 1) idx = 0;
                else if (idx == 0) idx = 1;
                else if (idx == 2) idx = 1;
            }

            System.out.println("#" + tc + " " + idx);
        }
    }
}
