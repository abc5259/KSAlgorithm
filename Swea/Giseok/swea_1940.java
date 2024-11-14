/**
 * @문제 소요시간
 * 1940. 가랏! RC카! (D2|구현) [O|00:11:34]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int cnt = Integer.parseInt(br.readLine());
            int speed = 0;
            int position = 0;
            for (int i = 0; i < cnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                if (command != 0) {
                    int count = Integer.parseInt(st.nextToken());

                    if (command == 1) speed += count;
                    else if (command == 2) speed = Math.max(speed - count, 0);
                }
                position += speed;
            }

            System.out.println("#" + t + " " + position);
        }
    }
}