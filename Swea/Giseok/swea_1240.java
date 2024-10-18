/**
 * 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드 (D3|구현) [O(댓글힌트)|01:11:10]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1240 {

    static String[] nums = new String[]{"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
    static int n, m;
    static String[] codes;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            codes = new String[n];
            for (int i = 0; i < n; i++) {
                codes[i] = br.readLine();
            }

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (codes[i].contains("1")) {
                    int index = codes[i].lastIndexOf("1");
                    if (index == -1) continue;
                    String s = codes[i].substring(index - 55, index+1);

                    int seq = 1;
                    int even = 0;
                    int odd = 0;
                    for (int m = 0; m < 56; m+=7) {
                        String tmp = s.substring(m, m+7);
                        for (int n = 0; n < 10; n++) {
                            if (tmp.equals(nums[n]) && seq % 2 == 0) {
                                even += n;
                                break;
                            } else if (tmp.equals(nums[n]) && seq % 2 != 0) {
                                odd += n;
                                break;
                            }
                        }
                        seq++;
                    }

                    int ret = odd * 3 + even;
                    if (ret % 10 == 0) {
                        System.out.println("#" + tc + " " + (odd + even));
                        flag = true;
                        break;
                    }
                }
            }

            if (!flag) System.out.println("#" + tc + " " + 0);
        }
    }
}