package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 진기의최고급붕어빵2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            boolean[] orders = new boolean[11112];
            int max = 0;
            for(int i=0; i<n; i++){
                int second = Integer.parseInt(st.nextToken());
                orders[second] = true;
                max = Math.max(second, max);
            }

            int bread = 0;
            boolean flag = true;
            for(int i=0; i<=max; i++){

                if(i%m == 0)bread+=k;
                if(i==0)bread=0;

                if(orders[i]){
                    if(bread-1 < 0) {
                        flag = false;
                        break;
                    }
                    bread--;
                }
            }

            String answer = flag? "Possible": "Impossible";

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}
