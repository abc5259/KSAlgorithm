package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 세영이의SEM력연도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int year=1;
            int a = 1;
            int b = 1;
            int c = 1;
            while(true){
                if(a==s && b==e && c==m)break;

                a++; b++; c++; year++;

                if(a==366)a=1;
                if(b==25)b=1;
                if(c==30)c=1;
            }

            System.out.println("#"+(tc+1)+" "+year);
        }
    }
}
