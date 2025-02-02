package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10165 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Line[] lines = new Line[M];

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[i] = new Line(i+1, a, b);
        }
        Arrays.sort(lines, (a,b) -> {
            if(a.a == b.a) {
                if(a.a > a.b && b.a < b.b) return -1;
                if(a.a < a.b && b.a > b.b) return 1;
                return b.b - a.b;
            }
            return a.a - b.a;
        });

        int left = 0;
        int right = 1;
        boolean[] result = new boolean[M];
        while (left < M) {
            if(lines[left].contains(lines[right])) {
                result[lines[right].id-1] = true;
                right++;
            }
            else {
                if(left > right) {
                    break;
                }
                left = right;
                right++;
            }

            if(right == M) {
                right = 0;
            }
            if(left == right) break;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            if(!result[i]) sb.append(i+1).append(" ");
        }
        System.out.println(sb);
    }
    static class Line {
        int id,a,b;

        public Line(int id, int a, int b) {
            this.id = id;
            this.a = a;
            this.b = b;
        }

        public boolean contains(Line other) {
            if(a < b && other.a < other.b) {
                return a <= other.a && b >= other.b;
            }
            else if(a < b && other.a > other.b) {
                return false;
            }
            else if(a > b && other.a < other.b) {
                int a1 = a;
                int a2 = N-1;
                int b1 = 0;
                int b2 = b;
                return (a1 <= other.a && a2 >= other.b) || (b1 <= other.a && b2 >= other.b);
            }
            else {
                int a1 = a;
                int a2 = N-1;
                int a3 = other.a;
                int a4 = N-1;

                int b1 = 0;
                int b2 = b;
                int b3 = 0;
                int b4 = other.b;
                return (a1 <= a3 && a2 >= a4) && (b1 <= b3 && b2 >= b4);
            }
        }

        @Override
        public String toString() {
            return id + " [" + a + ", " + b + "]";
        }
    }
}
