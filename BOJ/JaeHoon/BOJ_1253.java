package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        Arrays.sort(arr);
        for(int i=0; i<N; i++) {
            int left = 0;
            int right = N-1;
            while (true) {
                if(left == i) {
                    left++;
                }
                if(right == i) {
                    right--;
                }
                if(left >= right) break;
                int sum = arr[left] + arr[right];
                if(sum == arr[i]) {
                    cnt++;
                    break;
                }
                if(sum < arr[i]) {
                    left++;
                }
                else if(sum > arr[i]) {
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}
