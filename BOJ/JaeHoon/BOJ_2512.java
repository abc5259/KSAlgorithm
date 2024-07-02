package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class BOJ_2512 {
    static int N;
    static int[] arr;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum  = 0;
        int max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        M = Integer.parseInt(br.readLine());

        if(sum <= M) {
            System.out.println(max);
            return;
        }

        int low = 1;
        int high = max;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if(check(mid)) {
                low = mid;
            }else {
                high = mid;
            }
        }

        System.out.println(low);
    }

    public static boolean check(int target) {
        int sum = 0;
        for(int i=0; i<N; i++) {
            if(target >= arr[i]) {
                sum += arr[i];
            }else {
                sum += target;
            }
        }

        return sum <= M;
    }

}
