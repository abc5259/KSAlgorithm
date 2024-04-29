package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;
import java.util.StringTokenizer;

public class 무한문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            int gcd = getGCD(a.length(), b.length());
            int lcm = a.length()*b.length() / gcd;

            String result = (Objects.equals(f(a, lcm), f(b, lcm)))? "yes": "no";

            System.out.println("#"+(tc+1)+" "+result);
        }
    }

    static String f(String str, int lcm){
        StringBuilder sb = new StringBuilder();
        while(true){
            if(sb.length() == lcm)break;

            sb.append(str);
        }

        return sb.toString();
    }

    //최대공약수
    static int getGCD(int a, int b){
        if(b==0)return a;
        else{
            return getGCD(b, a%b);
        }
    }
}
