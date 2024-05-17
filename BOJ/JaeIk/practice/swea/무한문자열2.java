package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무한문자열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int gcd = getGCD(str1.length(), str2.length());
            int size = getLCM(str1.length(), str2.length(), gcd);

            StringBuilder sb1 = new StringBuilder();
            while(sb1.length() < size){
                sb1.append(str1);
            }

            StringBuilder sb2 = new StringBuilder();
            while(sb2.length() < size){
                sb2.append(str2);
            }

            String answer = (sb1.toString().contentEquals(sb2))?"yes":"no";

            System.out.println("#"+(tc+1)+" "+answer);
        }


    }

    static int getLCM(int a, int b, int gcd){
        return (a/gcd) * (b/gcd) * gcd;
    }

    static int getGCD(int a, int b){
        if(b==0)return a;

        return getGCD(b, a%b);
    }
}
