package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16401 {
    static int M, N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int low = 0;
        int high = 1_000_000_001;

        while (low + 1< high) {
            int mid = (low + high) / 2;
//            System.out.println(mid + " " + check(mid));
            if(check(mid)) {
                low = mid;
            }else {
                high = mid;
            }
        }

        System.out.println(low);
    }

    private static boolean check(int target) {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(arr[i] >= target) {
                cnt+=arr[i] / target;
            }
        }
        return M <= cnt;
    }
}
