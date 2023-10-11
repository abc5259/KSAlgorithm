package BOJ.JaeIk.retry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class City{
    int end; int weight;

    public City(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}

public class BOJ_11657 {
    static final int INF = 987654321;
    static long[] distance;
    static ArrayList<ArrayList<City>> map;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new long[N+1];
        map = new ArrayList<>();
        for(int i=0; i<=N; i++){
            map.add(new ArrayList<>());
            distance[i] = INF;
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map.get(start).add(new City(end, weight));
        }

        if(belmanford()){
            sb.append("-1\n");
        }else{
            for(int i=2; i<=N; i++){
                if(distance[i] == INF){
                    sb.append("-1\n");
                }
                else{
                    sb.append(distance[i] + "\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static boolean belmanford(){
        distance[1] = 0;
        boolean isUpdated = false;

        //정점의 갯수 - 1 만큼 최단 거리 초기화 작업 반복
        //루프를 나가기 위해서는 가중치 업데이트 여부를 판단한다
        //만약 M=6000 C=-10000일 경우 N * -60000000이 21억을 넘으므로 distance 배열을 long 타입으로 지정한다.
        for(int i=1; i<N; i++){
            isUpdated = false;

            for(int j=1; j<=N; j++){
                //시작 정점 까지의 가중치가 INF가 아니고
                //다음 정점까지의 가중치로 저장된 값이 시작정점에서 다음정점을 잇는 가중치보다 크다면
                //가중치를 업데이트한 후
                //update를 true로 switch한다
                for(City city : map.get(j)){
                    if(distance[j]!=INF && distance[city.end] > distance[j] + city.weight){
                        distance[city.end] = distance[j] + city.weight ;
                        isUpdated = true;
                    }
                }
            }
            //만약 가중치가 더 이상 업데이트 되지 않는다면 루프를 빠져나간다
            if(!isUpdated)break;
        }

        //가중치가 없데이트 된 후 한번 더 순회를 해본다
        //그 결과 가중치가 다시 업데이트 된다면 음수사이클이 존재하는것이다
        //음수사이클이 존재하는 경우 true를 반환한다
        if(isUpdated){
            for(int j=1; j<=N; j++){
                for(City city : map.get(j)){
                    if(distance[j]!=INF && distance[city.end] > distance[j] + city.weight){
                        return true;
                    }
                }
            }
        }
        //존재하지 않으면 false를 반환한다
        return false;
    }
}

//long때문에 출력 초과??????????????????????????????????????????
