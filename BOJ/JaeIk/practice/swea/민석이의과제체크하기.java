package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;

public class 민석이의과제체크하기 {
    static boolean[] hasSubmit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            hasSubmit = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=k; i++){
                hasSubmit[Integer.parseInt(st.nextToken())] = true;
            }

            StringBuilder sb  = new StringBuilder();
            for(int i=1; i<=n; i++){
                if(!hasSubmit[i]){
                    sb.append(i).append(" ");
                }
            }

            System.out.println("#"+(tc+1)+" "+sb);
        }
    }
}
