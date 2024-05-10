package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요일맞추기 {
    static int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] arr = {3, 4, 5, 6, 0, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int i=1; i<M; i++){
                sum += days[i];
            }
            sum += D;

            int answer = arr[sum%7];

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}
