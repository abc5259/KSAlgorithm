package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1508 {
    static int N,M,K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 1;
        int high = N+1;
        while(low + 1 < high) {
            int mid = (low + high)/2;
            if(check(mid)) {
                low = mid;
            }else {
                high = mid;
            }
        }

        System.out.println(solve(low));
    }

    public static boolean check(int dif) {
        int sum = 1;
        int prev = arr[0];
        for(int i=1; i<K; i++) {
            if(arr[i] - prev >= dif) {
                sum++;
                prev = arr[i];
            }
        }
        return  sum >= M;
    }

    public static String solve(int dif) {
        int prev = arr[0];
        int sum = 1;
        StringBuilder sb = new StringBuilder("1");
        for(int i=1; i<K; i++) {
            if(sum >= M) {
                sb.append("0");
                continue;
            }
            if(arr[i] - prev >= dif) {
                sum++;
                prev = arr[i];
                sb.append("1");
            }else {
                sb.append("0");
            }
        }
        return  sb.toString();
    }
}
