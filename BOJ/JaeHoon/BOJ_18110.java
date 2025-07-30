package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int exclude = (int) Math.round(N * 0.15);
        double sum = 0;
        int n = 0;
        for(int i=exclude+1; i<=N-exclude; i++) {
            n++;
            sum += arr[i];
        }

        double avg = sum / n;
        System.out.println(Math.round(avg));
    }
}
