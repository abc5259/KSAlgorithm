package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1956 {
    static int INF = 900000001;
    static int v,e;
    static int[][] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        table = new int[v+1][v+1];
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                if(i!=j)table[i][j] = INF;
            }
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            table[start][end] = weight;
        }

        for(int k=1; k<=v; k++){
            for(int i=1; i<=v; i++){
                for(int j=1; j<=v; j++){
                    if(i==j)continue;
                    if(table[i][k]+table[k][j] < table[i][j]){
                        table[i][j] = table[i][k] + table[k][j];
                    }
                }
            }
        }

        int answer = INF;
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                if(i==j)continue;

                if(table[i][j] != INF && table[j][i] != INF){
                    answer = Math.min(answer, table[i][j] + table[j][i]);
                }
            }
        }

        answer = (answer == INF) ? -1 : answer;

        System.out.println(answer);

    }
}
