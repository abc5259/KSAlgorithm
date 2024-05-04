package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 제곱팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = 0;
            for(int i=a; i<=b; i++){
                double sqrt = Math.sqrt(i);

                if(isPalindrome(i) && isPalindrome(sqrt)){
                    result++;
                }
            }

            System.out.println("#"+(tc+1)+" "+result);
        }
    }

    static boolean isPalindrome(double origin){
        long round = Math.round(origin);
        if(origin != round){
            return false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append((int)origin);

        return String.valueOf((int)origin).equals(sb.reverse().toString());
    }
}
