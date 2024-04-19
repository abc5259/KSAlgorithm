package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] people = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            people[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(people);
        int ans = people[0];
        for (int i = 1; i < N; i++) {
            people[i] += people[i-1];
            ans += people[i];
        }
        
        System.out.println(ans);
    }
}
