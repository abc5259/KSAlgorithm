package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8983 {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(x == o.x) return o.y - y;
            return x - o.x;
        }

        @Override
        public String toString() {
            return "x = " + x + " y = " + y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] guns = new int[M];
        Point[] animals = new Point[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            guns[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            animals[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(guns);

        int result = 0;
        for(int i=0; i<N; i++) {
            int low = 0;
            int high = M-1;
            while (low + 1 < high) {
                int mid = (low + high) / 2;
                if(animals[i].x < guns[mid]) {
                    high = mid;
                }else {
                    low = mid;
                }
            }
            if(isDead(guns[low], animals[i], L) || isDead(guns[high], animals[i], L)) {
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean isDead(int gun, Point animal, int L) {
        return Math.abs(gun - animal.x) + animal.y <= L;
    }
}
