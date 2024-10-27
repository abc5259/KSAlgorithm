/**
 * 1225. [S/W 문제해결 기본] 7일차 - 암호생성기 (D3|구현) [O|00:18:37]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            boolean flag = false;
            while (!flag) {
                for (int i = 1; i <= 5; i++) {
                    int num = q.poll() - i;
                    if (num <= 0) {
                        q.offer(0);
                        flag = true;
                        break;
                    }
                    q.offer(num);
                }
            }

            System.out.print("#" + tc);
            while (!q.isEmpty())
                System.out.print(" " + q.poll());
            System.out.println();
        }
    }
}