package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        City[] arr = new City[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new City(a,b);
        }

        int MAX = 100*1000 + 1;
        int[] dp = new int[MAX];
        for(int i=1; i<=N; i++) {
            for(int j=arr[i].price; j<MAX; j++) {
                dp[j] = Math.max(dp[j], dp[j-arr[i].price]+arr[i].customer);
            }
        }


        int min = Integer.MAX_VALUE;
        for(int j=1; j<MAX; j++) {
            if(dp[j] >= C) {
                min = j;
                break;
            }
        }

        System.out.println(min);

    }
    static class City {
        int price;
        int customer;

        public City(int price, int customer) {
            this.price = price;
            this.customer = customer;
        }
    }
}
