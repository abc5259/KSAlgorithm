package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        boolean[] check = new boolean[N];

        int answer = 0;

        for(int i=0; i<N; i++) {
            if(arr[i] == 'P') {
                for(int j=i-K; j<=i+K; j++) {
                    if(j < 0 || j >= N) continue;
                    if(arr[j] == 'P') continue;
                    if(check[j]) continue;

                    check[j] = true;
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
