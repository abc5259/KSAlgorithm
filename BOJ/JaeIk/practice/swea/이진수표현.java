package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.imageio.IIOException;

public class 이진수표현 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean flag = true;
            for(int i=0; i<n; i++){
                if((m & (1<<i)) <= 0){
                    flag = false;
                    break;
                }
            }

            String answer = (flag)? "ON": "OFF";

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}
