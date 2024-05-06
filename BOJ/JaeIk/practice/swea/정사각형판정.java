package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정사각형판정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            char[][] map = new char[n][n];
            for(int i=0; i<n; i++){
                map[i] = br.readLine().toCharArray();
            }

            int r_min = 20;
            int c_min = 20;
            int r_max = 0;
            int c_max = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] == '#'){
                        r_min = Math.min(r_min, i);
                        c_min = Math.min(c_min, j);

                        r_max = Math.max(r_max, i);
                        c_max = Math.max(c_max, j);
                    }
                }
            }

            boolean flag = true;
            total : for(int i=r_min; i<=r_max; i++){
                for(int j=c_min; j<=c_max; j++){
                    if(map[i][j] != '#'){
                        flag=false;
                        break total;
                    }
                }
            }

            String result = (r_max-r_min == c_max-c_min && flag)? "yes": "no";

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
