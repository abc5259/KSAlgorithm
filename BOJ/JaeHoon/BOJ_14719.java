package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=1; i<W-1; i++) {
            int maxLeft = -1;
            for(int j=i-1; j>=0; j--) {
                maxLeft = Math.max(maxLeft, arr[j]);
            }
            int maxRight = -1;
            for(int j=i+1; j<W; j++) {
                maxRight = Math.max(maxRight, arr[j]);
            }

            int h = Math.min(maxLeft, maxRight);
            if(arr[i] < h) {
                sum += h - arr[i];
            }
        }
        System.out.println(sum);
    }
}
