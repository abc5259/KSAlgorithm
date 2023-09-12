package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11399 {
    static int N;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        time = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int prev_sum=0;
        int total=0;

        for(int i=0; i<N; i++){
            total += prev_sum + time[i];
            prev_sum += time[i];
        }

        System.out.println(total);
    }
}
