package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼성시의버스노선 {
    static int p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());

            int[][] path = new int[N][2];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                path[i][0] = Integer.parseInt(st.nextToken());
                path[i][1] = Integer.parseInt(st.nextToken());
            }

            p = Integer.parseInt(br.readLine());

            int[] busStop = new int[p];
            for(int j=0; j<p; j++){
                busStop[j] = Integer.parseInt(br.readLine());
            }

            int[] check = new int[busStop.length];

            for(int k=0; k<busStop.length; k++){
                for(int l=0; l<N; l++){
                    if(checkBusStop(busStop[k], path[l])){
                        check[k]++;
                    }
                }
            }

            System.out.print("#"+(tc+1)+" ");
            for(int i=0; i<check.length; i++){
                System.out.print(check[i]+" ");
            }
            System.out.println();
        }
    }

    static boolean checkBusStop(int busStop, int[] path){
        for(int i=path[0]; i<=path[1]; i++){
            if(busStop==i)return true;
        }

        return false;
    }
}
