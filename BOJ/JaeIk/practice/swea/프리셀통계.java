package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 프리셀통계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            int pD = Integer.parseInt(st.nextToken());
            int pG = Integer.parseInt(st.nextToken());

            String answer = "Broken";

            if(pD!=100 && pG==100){
                System.out.println("#"+(tc+1)+" "+answer);
            }

            else if(pD>0 && pG==0){
                System.out.println("#"+(tc+1)+" "+answer);
            }
            else{
                while(n > 0){
                    if((n*pD)%100==0){
                        answer = "Possible";
                        break;
                    }
                    n--;
                }

                System.out.println("#"+(tc+1)+" "+answer);
            }
        }
    }
}
