/**
 * 1228. [S/W 문제해결 기본] 8일차 - 암호문1 (D3|구현) [O|00:10:27]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            ArrayList<Integer> nums = new ArrayList<>();
            int length = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length; i++) nums.add(Integer.parseInt(st.nextToken()));

            int cnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cnt; i++) {
                st.nextToken();
                int position = Integer.parseInt(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());
                for (int j = 0; j < quantity; j++) nums.add(position + j, Integer.parseInt(st.nextToken()));
            }

            System.out.print("#" + tc);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + nums.get(i));
            }
            System.out.println();
        }
    }
}