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
                //시작 정점 까지의 가중치가 INF가 아니고
                //다음 정점까지의 가중치로 저장된 값이 시작정점에서 다음정점을 잇는 가중치보다 크다면
                //가중치를 업데이트한 후
                //update를 true로 switch한다
                for(City c : a.get(j)){
                    if(dist[j]!=INF && dist[c.end] > dist[j] + c.weight){
                        dist[c.end] = dist[j] + c.weight;
                        update = true;
                    }
                }
            }
            //만약 가중치가 더 이상 업데이트 되지 않는다면 루프를 빠져나간다
            if(!update)break;
        }

        //가중치가 없데이트 된 후 한번 더 순회를 해본다
        //그 결과 가중치가 다시 업데이트 된다면 음수사이클이 존재하는것이다
        //음수사이클이 존재하는 경우 true를 반환한다
        if(update){
            for(int i=1; i<=N; i++) {
                for(City c : a.get(i)){
                    if(dist[i] != INF && dist[c.end] > dist[i] + c.weight){
                        return true;
                    }
                }
            }
        }
        //존재하지 않으면 false를 반환한다
        return false;
    }

}


