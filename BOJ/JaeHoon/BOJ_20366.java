package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_20366 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Snow> snows = new ArrayList<>();
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                int sum = arr[i] + arr[j];
                snows.add(new Snow(i, j, sum));
            }
        }

        Collections.sort(snows, (a, b) -> a.sum - b.sum);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<snows.size()-1; i++) {
            Snow snow1 = snows.get(i);
            Snow snow2 = snows.get(i + 1);

            if(snow1.v1 != snow2.v1 && snow1.v1 != snow2.v2 && snow1.v2 != snow2.v1 && snow1.v2 != snow2.v2) {
                min = Math.min(min, Math.abs(snow1.sum - snow2.sum));
            }

        }
        System.out.println(min);
    }

    static class Snow {
        int v1, v2, sum;

        public Snow(int v1, int v2, int sum) {
            this.v1 = v1;
            this.v2 = v2;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Snow{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", sum=" + sum +
                    '}';
        }
    }
}
