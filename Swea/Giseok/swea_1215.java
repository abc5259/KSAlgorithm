/**
 * 1215. [S/W 문제해결 기본] 3일차 - 회문1 (D3|구현) [O|00:21:48]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;

public class swea_1215 {

    static char[][] flatMap;
    static int findLength;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            findLength = Integer.parseInt(br.readLine());
            flatMap = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < 8; j++) {
                    flatMap[i][j] = tmp.charAt(j);
                }
            }

            int ret = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - findLength; j++) {
                    for (int w = 0; w < 2; w++) {
                        if (isPalindrome(i, j, w)) {
                            ret++;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + ret);
        }
    }

    public static boolean isPalindrome(int i, int j, int w) {
        int left = j;
        int right = j + findLength - 1;

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
