package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17266 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[M];
        for(int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = 100000;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if(check(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.println(high);
    }

    static boolean check(int mid) {
        int prev = 0;
        for(int i=0; i<M; i++) {
            int p = Math.max(0, arr[i] - mid);
            if(prev < p) return false;
            prev = arr[i] + mid;
        }
        return N <= prev;
    }
}
