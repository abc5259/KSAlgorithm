package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큰수의최대공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            String answer = (a.equals(b))? a: "1";

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

//    static int GCD(int a, int b){
//        if(a%b==0){
//            return b;
//        }
//        return GCD(b, a%b);
//    }
}
