/**
 * 1946. 간단한 압축 풀기 (D2|구현) [O]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            char[] alphabet = new char[n];
            int[] cnt = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                alphabet[i] = st.nextToken().charAt(0);
                cnt[i] = Integer.parseInt(st.nextToken());
            }

            int newLine = 0;
            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < cnt[i]; j++) {
                    System.out.print(alphabet[i]);
                    if (++newLine % 10 == 0) System.out.println();
                }
            }
            System.out.println();
        }
    }
}