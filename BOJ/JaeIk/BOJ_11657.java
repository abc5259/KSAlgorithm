package BOJ.JaeIk;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class City {
    int end;
    int weight;

    City(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class BOJ_11657 {
    static ArrayList<ArrayList<City>> a;
    static long dist[];
    static final int INF = 987654321;
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new ArrayList<>();
        dist = new long[N+1];

        for(int i=0; i<=N; i++){
            a.add(new ArrayList<>());
            dist[i] = INF;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B =Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            a.get(A).add(new City(B, C));
        }

        StringBuilder sb = new StringBuilder();
        if(bellmanford()){
            sb.append("-1\n");
        }
        else{
            for(int i=2; i<=N; i++){
                if(dist[i] == INF){
                    sb.append("-1\n");
                }
                else{
                    sb.append(dist[i] + "\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static boolean bellmanford(){
        dist[1] = 0;
        boolean update = false;

        //정점의 갯수 - 1 만큼 최단 거리 초기화 작업 반복
        for(int i=1; i<N; i++){
            update = false;

            for(int j=1; j<=N; j++){
                for(City c : a.get(j)){
                    if(dist[j]!=INF && dist[c.end] > dist[j] + c.weight){
                        dist[c.end] = dist[j] + c.weight;
                        update = true;
                    }
                }
            }
            if(!update)break;
        }

        if(update){
            for(int i=1; i<=N; i++) {
                for(City c : a.get(i)){
                    if(dist[i] != INF && dist[c.end] > dist[i] + c.weight){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}


