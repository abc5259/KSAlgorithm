package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 준환이의운동관리 {
    static int L, U, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            U = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            int answer = 0;
            if(L <= X && X <= U){
                answer = 0;
            }
            if(X < L){
                answer = L-X;
            }
            if(X > U){
                answer = -1;
            }

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}
