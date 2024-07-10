package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = N-1;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while (l < r) {
            int sum = arr[l] + arr[r];
            int dif = Math.abs(sum);
            if(dif < min) {
                min = dif;
                ans[0] = l;
                ans[1] = r;
            }

            if(sum < 0) {
                l++;
            }
            else if(sum > 0) {
                r--;
            } else if (sum == 0) {
                break;
            }
        }

        System.out.println(arr[ans[0]] + " " + arr[ans[1]]);
    }
}
