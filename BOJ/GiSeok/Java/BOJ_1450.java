/**
 * 1450 - G1 냅색문제 [X|01:32:14]
 * 골드1, DP, 시도4
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_1450 {

    static int n, c;
    static int[] pack;
    static ArrayList<Integer> v1 = new ArrayList<>();
    static ArrayList<Integer> v2 = new ArrayList<>();
    static int ret = 0;

    static void go1(int here, int _n, int sum) {
        if (sum > c) return;
        if (here > _n) {
            v1.add(sum);
            return;
        }

        go1(here + 1, _n, sum + pack[here]);
        go1(here + 1, _n, sum);
    }

    static void go2(int here, int _n, int sum) {
        if (sum > c) return;
        if (here > _n) {
            v2.add(sum);
            return;
        }

        go2(here + 1, _n, sum + pack[here]);
        go2(here + 1, _n, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        pack = new int[n];
        for (int i = 0; i < n; i++) pack[i] = Integer.parseInt(st.nextToken());

        go1(0, (n/2)-1, 0);
        go2((n/2), n-1, 0);

        Collections.sort(v1);
        Collections.sort(v2);

        for (int b : v1) {
            if (c - b >= 0) {

                int low = -1;
                int high = v2.size();

                while (low + 1 < high) {
                    int mid = (low + high) / 2;

                    if (v2.get(mid) <= c-b) low = mid;
                    else high = mid;
                }

                ret += high;
            }
        }

        bw.write(ret + "");
        bw.flush(); bw.close();
    }
}