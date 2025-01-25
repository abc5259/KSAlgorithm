/**
 * [B1 구현] 디지털 티비 - O, 00:20:49
 * 시도 1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] channel = new String[n];
        for (int i = 0; i < n; i++)
            channel[i] = br.readLine();

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        boolean flag = false;
        while (true) {
            if (!flag) {
                if (!channel[idx].equals("KBS1")) {
                    idx++; sb.append("1");
                } else {
                    if (idx == 0) { flag = true; }
                    else {
                        String tmp = channel[idx];
                        channel[idx] = channel[idx-1];
                        channel[idx-1] = tmp;
                        idx--; sb.append("4");
                    }
                }
            } else {
                if (!channel[idx].equals("KBS2")) {
                    idx++; sb.append("1");
                } else {
                    if (idx == 1) break;
                    else {
                        String tmp = channel[idx];
                        channel[idx] = channel[idx-1];
                        channel[idx-1] = tmp;
                        idx--; sb.append("4");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
