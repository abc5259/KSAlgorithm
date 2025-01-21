package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());
        int[] money = {500,100,50,10,5,1};
        int result = 0;
        while (N > 0) {
            for(int m: money) {
                if(N >= m) {
                    int cnt = N / m;
                    result += cnt;
                    N = N - cnt * m;
                }
            }
        }

        System.out.println(result);
    }
}
