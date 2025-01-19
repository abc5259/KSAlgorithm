package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1637 {
    static Value[] values;
    static long max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long max = 0;
        long low = 0;
        values = new Value[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            values[i] = new Value(a, c, b);
            max = Math.max(max, c);
        }
        long high = max + 1;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if(check(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if(max == low) {
            System.out.println("NOTHING");
            return;
        }
        System.out.println(high + " " + (getCnt(high) - getCnt(high-1)));
    }

    private static boolean check(long mid) {
        long cnt = getCnt(mid);
        return cnt % 2 == 1;
    }

    private static long getCnt(long mid) {
        long cnt = 0;
        for (Value value : values) {
            if(value.a > mid) continue;
            long sum = (Math.min(mid, value.c) - value.a) / value.b;
            cnt += sum + 1;
        }
        return cnt;
    }

    static class Value {
        int a,c,b;

        public Value(int a, int c, int b) {
            this.a = a;
            this.c = c;
            this.b = b;
        }
    }
}