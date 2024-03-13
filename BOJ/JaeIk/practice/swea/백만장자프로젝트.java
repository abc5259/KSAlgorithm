package BOJ.JaeIk.practice.swea;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class 백만장자프로젝트
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc=0; tc<T; tc++) {
            int n = sc.nextInt();

            long[] prices = new long[n];
            for(int i=0; i<n; i++) {
                prices[i] = sc.nextLong();
            }


            System.out.println("#"+(tc+1)+" "+getProfit(prices));
        }
    }

    static long getProfit(long[] prices) {
        long max = Integer.MIN_VALUE;
        long profit = 0;

        for(int i=prices.length-1; i>=0; i--) {
            if(max<=prices[i]) {
                max = prices[i];
            }else {
                profit += (max-prices[i]);
            }

        }

        return profit;
    }
}
