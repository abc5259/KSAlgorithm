package BOJ.JaeIk;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {
    static int r1,r2;
    static int n,m;
    static int map[][];
    static int val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n][n];
        val = 1;

        solve();

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(map[i][j]).append(" ");
            }
            if(i==n-1)break;
            sb.append("\n");
        }

        System.out.println(sb);

        System.out.println((r1+1)+" "+(r2+1));

    }

    static void solve(){
        int limit = 1;
        int r = n/2;
        int c = n/2;

        while(val<n*n+1){

            for(int i=0; i<limit; i++){
                if(val==m){
                    r1=r; r2=c;
                }
                map[r--][c] = val++;
            }

            if(val-1==n*n)break;
            for(int i=0; i<limit; i++){
                if(val==m){
                    r1=r; r2=c;
                }
                map[r][c++] = val++;
            }

            limit++;

            for(int i=0; i<limit; i++){
                if(val==m){
                    r1=r; r2=c;
                }
                map[r++][c] = val++;
            }

            for(int i=0; i<limit; i++){
                if(val==m){
                    r1=r; r2=c;
                }
                map[r][c--] = val++;
            }

            limit++;
        }
    }

}
