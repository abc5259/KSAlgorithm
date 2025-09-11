package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class BOJ_16208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        long sum = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int left = 0;
        int right = N-1;
        long result = 0;
        while (left < right) {
            if(arr[left] <= arr[right]) {
                sum -= arr[left];
                result += sum * arr[left];
                left++;
            }else {
                sum -= arr[right];
                result += sum * arr[right];
                right--;
            }
        }

        System.out.println(result);
    }
}
