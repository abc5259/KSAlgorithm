package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long min = Long.MAX_VALUE;
        Arrays.sort(arr);
        long[] result = new long[3];
        for(int i=0; i<N; i++) {
            int left = 0;
            int right = N-1;
            long dif = -arr[i];
            while (left < right) {
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }

                if(min > Math.abs(arr[i] + arr[left] + arr[right])) {
                    min = Math.abs(arr[i] + arr[left] + arr[right]);
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }
                if(arr[left] + arr[right] > dif) {
                    right--;
                }else {
                    left++;
                }

            }
        }
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
