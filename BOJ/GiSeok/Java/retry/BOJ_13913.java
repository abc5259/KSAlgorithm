package BOJ.GiSeok.Java.retry;

import java.util.*;
import java.io.*;

public class BOJ_13913 {

    static int[][] ye;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ye = new int[100001][2];
        for (int i = 0; i <= 100000; i++) {
            ye[i][0] = 987654321;
        }
        ye[n][0] = 0;
        int ret = 0;

        Deque<Integer> q = new ArrayDeque<>();
        q.add(n);

        while (!q.isEmpty()) {
            int pin = q.poll();

            int np1 = pin + 1;
            int np2 = pin - 1;
            int np3 = pin * 2;

            if (np1 >= 0 && np1 <= 100000) {
                if (ye[pin][0] + 1 < ye[np1][0]) {
                    ye[np1][0] = ye[pin][0] + 1;
                    ye[np1][1] = 1;
                    q.add(np1);
                } else if (ye[pin][0] + 1 == ye[np1][0]) {
                    ye[np1][1]++;
                    q.add(np1);
                }
            }

            if (np2 >= 0 && np2 <= 100000) {
                if (ye[pin][0] + 1 < ye[np2][0]) {
                    ye[np2][0] = ye[pin][0] + 1;
                    ye[np2][1] = 1;
                    q.add(np2);
                } else if (ye[pin][0] + 1 == ye[np2][0]) {
                    ye[np2][1]++;
                    q.add(np2);
                }
            }

            if (np3 >= 0 && np3 <= 100000) {
                if (ye[pin][0] + 1 < ye[np3][0]) {
                    ye[np3][0] = ye[pin][0] + 1;
                    ye[np3][1] = 1;
                    q.add(np3);
                } else if (ye[pin][0] + 1 == ye[np3][0]) {
                    ye[np3][1]++;
                    q.add(np3);
                }
            }
        }

        System.out.println(ye[k][0]);

        StringBuilder sb = new StringBuilder();
        int c = ye[k][0];
        int now = k;
        while (c >= 0) {
            sb.insert(0, now + " ");
            int n1 = now - 1;
            int n2 = now + 1;
            int n3 = now / 2;

            if (n1 >= 0 && n1 <= 100000 && ye[n1][0] == c - 1) {
                now = n1;
            } else if (n2 >= 0 && n2 <= 100000 && ye[n2][0] == c - 1) {
                now = n2;
            } else if (n3 >= 0 && n3 <= 100000 && ye[n3][0] == c - 1) {
                now = n3;
            }
            c--;
        }

        System.out.println(sb);
    }
}
