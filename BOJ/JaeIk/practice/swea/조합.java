package BOJ.JaeIk.practice.swea;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 조합 {
    static final int MOD = 1234567891;
    static long[] factorial;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            factorial = new long[n+1];
            factorial[0] = 1;
            for(int i=1; i<=n; i++) {
                factorial[i] = (factorial[i-1]*i)%MOD;
            }
            long bottom = (factorial[r]*factorial[n-r])%MOD;
            long reBottom = fermat(bottom, MOD-2);

            System.out.println("#"+(tc+1)+" "+(factorial[n]*reBottom)%MOD);
        }
    }

    static long fermat(long bottom, int x) {
        if(x==0)return 1;

        //x가 너무 크기 때문에 분할정복
        long temp = fermat(bottom, x/2);
        long result = (temp*temp)%MOD;
        if(x%2 == 0)return result;

        return (result*bottom)%MOD;
    }
}