package BOJ.JaeIk;

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static double[][] stars;
    private static PriorityQueue<Star> pq;
    private static int[] parents;

    private static class Star implements Comparable<Star> {
        int s;
        int e;
        double x1, x2;
        double y1, y2;
        double dis;

        Star(int s, int e, double x1, double x2, double y1, double y2, double dis) {
            this.s = s; this.e = e;
            this.x1 = x1; this.x2 = x2;
            this.y1 = y1; this.y2 = y2;
            this.dis = dis;
        }

        @Override
        public int compareTo(Star o) {
            if(this.dis > o.dis){
                return 1;
            }else if(this.dis < o.dis){
                return -1;
            }else {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        stars = new double[n + 1][2];
        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stars[i][0] = Double.parseDouble(st.nextToken()); // x좌표
            stars[i][1] = Double.parseDouble(st.nextToken()); // y좌표

            parents[i] = i;
        }

        pq = new PriorityQueue<>();

        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                double x1 = stars[i][0];
                double y1 = stars[i][1];

                double x2 = stars[j][0];
                double y2 = stars[j][1];

                double x = Math.pow(x1 - x2, 2);
                double y = Math.pow(y1 - y2, 2);

                double dis = Math.sqrt(x + y);

                pq.add(new Star(i, j, x1, x2, y1, y2, dis));
            }
        }

        double total = 0;
        int cnt = n - 1;
        while (!pq.isEmpty() && cnt > 0) {
            Star star = pq.poll();

            if(union(star.s, star.e)){
                total += star.dis;
                cnt--;
            }
        }

        double ans = (double) Math.round(total * 100) / 100;
        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        if(root1 == root2){
            return false;
        }

        if(root2 > root1){
            parents[root2] = root1;
        }else{
            parents[root1] = root2;
        }

        return true;
    }

    static int find(int root) {
        if (parents[root] == root) {
            return root;
        }
        return find(parents[root]);
    }
}