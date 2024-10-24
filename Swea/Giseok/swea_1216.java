/**
 * 1216. [S/W 문제해결 기본] 3일차 - 회문2 (D3|구현) [O|00:11:00]
 * 시도4
 */
package Swea.Giseok;

import java.io.*;

public class swea_1216 {

    static char[][] flatMap;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());
            flatMap = new char[100][100];

            for (int i = 0; i < 100; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < 100; j++) {
                    flatMap[i][j] = tmp.charAt(j);
                }
            }

            int ret = 0;
            for (int c = 0; c < 100; c++) {
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 100 - c; j++) {
                        for (int w = 0; w < 2; w++) {
                            if (isPalindrome(i, j, c, w)) {
                                ret = Math.max(ret, c+1);
                            }
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + ret);
        }
    }

    public static boolean isPalindrome(int i, int j, int c, int w) {
        int left = j;
        int right = j + c;

        while (left <= right) {
            if (w == 0 && flatMap[i][left] == flatMap[i][right]) {
                left++; right--;
            } else if (w == 1 && flatMap[left][i] == flatMap[right][i]){
                left++; right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
