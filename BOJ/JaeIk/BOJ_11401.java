package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11401 {
    static long NUM = 1000000007;
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        long num = factorial(n);

        long denom = factorial(k) * factorial(n-k) % NUM;

        System.out.println(num * pow(denom, NUM-2)%NUM);

    }

    static long factorial(long n){
        long fac = 1L;

        while(n>1){
            fac = (fac*n)%NUM;
            n--;
        }
        return fac;
    }

    static long pow(long a, long b){
        if(b == 1){
            return a%NUM;
        }

        long temp = pow(a, b/2);

        if(b%2 == 1){
            return (temp*temp%NUM)*a%NUM;
        }

        return temp*temp*NUM;
    }
}
