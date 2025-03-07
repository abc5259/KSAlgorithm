package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17383 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int low = 0;
        int high = 1000000000;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if(isPossible(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(high);
    }

    public static boolean isPossible(int rt) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += 1 - (arr[i] - 1) / rt;
            }
            return cnt > 0;
        }
}
