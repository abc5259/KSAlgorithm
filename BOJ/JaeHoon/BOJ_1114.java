package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1114 {
    static int K,C,L;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int low = 0;
        int high = L;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if(check(mid)) {
                high = mid;
            }else {
                low = mid;
            }
        }

        int start = 0;
        for(int i=0; i<K-1; i++) {
            int prev = arr[i] - start;
            int next = arr[i+1] - start;
            if(prev > high) {
                continue;
            }
            if(next > high) {
                start = arr[i];
                break;
            }
            if (next == high && C == 1) {
                start = arr[i];
                break;
            }
        }
        if(start == 0) {
//            if(L - )
            start = arr[K-1];
        }

        if(check2(high)) {
            start = arr[0];
        }
        System.out.println(high + " " + start);
    }

    private static boolean check(int target) {
        int cnt = 0;
        int start = 0;
        for(int i=0; i<K-1; i++) {
            int prev = arr[i] - start;
            int next = arr[i+1] - start;
            if(prev > target) {
                return false;
            }
            if(next > target) {
                start = arr[i];
                cnt++;
            }
        }
        if(arr[K-1] - start > target) {
            return false;
        }
        if(L - start > target) {
            if(L - arr[K-1] > target) {
                return false;
            }
            cnt++;
        }
        return cnt <= C;
    }
    private static boolean check2(int target) {
        int cnt = 0;
        int start = 0;
        for(int i=0; i<K-1; i++) {
            int prev = arr[i] - start;
            int next = arr[i+1] - start;
            if(prev > target) {
                return false;
            }
            if(next > target) {
                start = arr[i];
                cnt++;
            }
        }
        if(arr[K-1] - start > target) {
            return false;
        }
        if(L - start > target) {
            if(L - arr[K-1] > target) {
                return false;
            }
            cnt++;
        }
        return cnt < C;
    }
}
