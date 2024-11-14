/**
 * 1984. 중간 평균값 구하기 (D2|구현) [O]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0; int max = 0; int min = 10001;
            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            System.out.println("#" + t + " " + Math.round(((sum - max - min) / 8.0)));
        }
    }
}
