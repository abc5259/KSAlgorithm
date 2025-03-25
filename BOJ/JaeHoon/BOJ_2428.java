package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2428 {
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

        Arrays.sort(arr);

        long result = 0;
        for(int i=0; i<N; i++) {
            result += count(i);
        }
        System.out.println(result);
    }
    public static int count(int cur) {
        int low = cur;
        int high = N;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if(check(cur, mid)) {
                low = mid;
            }else {
                high = mid;
            }
        }

        return low - cur;
    }

    public static boolean check(int value, int target) {
        return arr[value] >= 0.9 * arr[target];
    }
}
