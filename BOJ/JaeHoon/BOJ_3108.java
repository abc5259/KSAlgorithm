package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_3108 {
    static int N;
    static int[] parent;
    static class Square {
        int[][] l =  new int[2][2];
        int[][] r =  new int[2][2];
        int[][] t =  new int[2][2];
        int[][] b =  new int[2][2];
        int x1,y1,x2,y2;

        Square(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            l[0][0] = x1;
            l[0][1] = y1;
            l[1][0] = x1;
            l[1][1] = y2;

            r[0][0] = x2;
            r[0][1] = y1;
            r[1][0] = x2;
            r[1][1] = y2;

            t[0][0] = x1;
            t[0][1] = y2;
            t[1][0] = x2;
            t[1][1] = y2;

            b[0][0] = x1;
            b[0][1] = y1;
            b[1][0] = x2;
            b[1][1] = y1;
        }

        public boolean contains(Square square) {
            if(b[0][1] >= square.l[0][1] && b[0][1] <= square.l[1][1] && b[0][0] <= square.l[0][0] && b[1][0] >= square.l[0][0]) {
                return true;
            }
            if(t[0][1] >= square.l[0][1] && t[0][1] <= square.l[1][1] && t[0][0] <= square.l[0][0] && t[1][0] >= square.l[0][0]) {
                return true;
            }
            if(b[0][1] >= square.r[0][1] && b[0][1] <= square.r[1][1] && b[0][0] <= square.r[0][0] && b[1][0] >= square.r[0][0]) {
                return true;
            }
            if(t[0][1] >= square.r[0][1] && t[0][1] <= square.r[1][1] && t[0][0] <= square.r[0][0] && t[1][0] >= square.r[0][0]) {
                return true;
            }

            return false;
        }

        public boolean isContainZero() {
            if(l[0][1] <= 0 && l[1][1] >= 0 && l[0][0] == 0) return true;
            if(r[0][1] <= 0 && r[1][1] >= 0 && r[0][0] == 0) return true;
            if(t[0][0] <= 0 && t[1][0] >= 0 && t[0][1] == 0) return true;
            if(b[0][0] <= 0 && b[1][0] >= 0 && b[0][1] == 0) return true;
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;

        Square[] squares = new Square[N+1];
        boolean check = false;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            squares[i] = new Square(x1, y1, x2, y2);
            if(squares[i].isContainZero()) {
                check = true;
            }
        }

        for(int i=1; i<=N-1; i++) {
            for(int j=i+1; j<=N; j++) {
                if(i==j) continue;
                if(squares[i].contains(squares[j])) {
                    union(i, j);
                }
                else if(squares[j].contains(squares[i])) {
                    union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=N; i++) {
            int v = find(i);
            set.add(v);
        }
        System.out.println(check ? set.size() - 1 : set.size());
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x <= y) {
            parent[y] = x;
        }else {
            parent[x] = y;
        }
    }
}
