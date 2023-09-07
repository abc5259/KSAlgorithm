package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(calc(a,b));
    }

    static long calc(long a, long b){
        // 2^4 = 2^2 * 2^2 = 2^1*2^1 * 2^1*2^1
        // 2^5 = 2^2 * 2^2 * 2^1 = 2^1*2^1 * 2^1*2^1 * 2^1

        if(b==1){
            return a%c;
        }

        long temp = calc(a, b/2);

        //b가 홀수일 때
        if(b%2==1){
            return (temp*temp%c)*a%c;
        }

        //b가 짝수일 때
        return temp*temp%c;
    }
}
