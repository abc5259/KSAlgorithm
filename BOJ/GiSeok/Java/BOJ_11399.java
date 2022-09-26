// 백준 - 11399 [그리디]ATM (09/ 26)
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(times);

        int time = 0;

        for (int i = 0; i < times.length; i++) {
            int n = 0;
            for (int j = 0; j <= i; j++) {
                n += times[j];
            }
            time += n;
        }

        System.out.println(time);
    }
}