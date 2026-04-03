package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_13549 {

    static class Point {
        int p, val;

        public Point(int p, int val) {
            this.p = p;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // x-1, x+1, 2*x
        PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        q.add(new Point(n, 0));

        int[] v = new int[200001];
        Arrays.fill(v, 987654321);
        v[n] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.p < 0 || p.p > 200000) continue;
            int n1 = p.p - 1;
            int n2 = p.p + 1;
            int n3 = p.p * 2;

            if (p.val > v[p.p]) continue;
            if (n1 >= 0 && n1 <= 200000 && p.val + 1 < v[n1]) {
                v[n1] = p.val + 1;
                q.add(new Point(n1, v[n1]));
            }

            if (n2 <= 200000 && p.val + 1 < v[n2]) {
                v[n2] = p.val + 1;
                q.add(new Point(n2, v[n2]));
            }

            if (n3 <= 200000 && p.val < v[n3]) {
                v[n3] = p.val;
                q.add(new Point(n3, v[n3]));
            }
        }

        System.out.println(v[k]);
    }
}
