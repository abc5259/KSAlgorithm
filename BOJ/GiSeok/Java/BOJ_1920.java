/**
 * 1920 - 수 찾기(S4) [O|00:07:41]
 * 구현, 시도2
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) set.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (set.contains(Integer.parseInt(st.nextToken())))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}