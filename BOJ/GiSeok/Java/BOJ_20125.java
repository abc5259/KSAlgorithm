/**
 * [S4 구현] 쿠키의 신체 측정 - O, 00:15:38
 * 시도 1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] cookie = new String[n];
        boolean flag = false;
        int heart_x = 0;
        int heart_y = 0;
        for (int i = 0; i < n; i++) {
            cookie[i] = br.readLine();
            if (cookie[i].contains("*") && !flag) {
                heart_x = cookie[i].indexOf("*");
                heart_y = i + 1;
                flag = true;
            }
        }

        int left_arm = heart_x - cookie[heart_y].indexOf("*");
        int right_arm = cookie[heart_y].lastIndexOf("*") - heart_x;
        int waist = 0;
        for (int y = heart_y + 1; y < n; y++) {
            if (cookie[y].charAt(heart_x) == '*') waist++;
            else break;
        }
        int left_leg = 0;
        for (int y = heart_y + waist; y < n; y++) {
            if (cookie[y].charAt(heart_x-1) == '*') left_leg++;
        }
        int right_leg = 0;
        for (int y = heart_y + waist; y < n; y++) {
            if (cookie[y].charAt(heart_x+1) == '*') right_leg++;
        }

        System.out.printf("%d %d\n", heart_y + 1, heart_x + 1);
        System.out.printf("%d %d %d %d %d\n", left_arm, right_arm, waist, left_leg, right_leg);
    }
}
