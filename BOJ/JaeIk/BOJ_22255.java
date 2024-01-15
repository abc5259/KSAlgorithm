package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22255 {
    static PriorityQueue<Node2> pq;
    static int n,m;
    static int sx,sy,ex,ey;
    static int[][] table;
    static int[][][] distance;
    // 상하좌우 맞춰주기
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int INF = 900000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //배열 인덱스 맞춰주기
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken())-1;
        sy = Integer.parseInt(st.nextToken())-1;
        ex = Integer.parseInt(st.nextToken())-1;
        ey = Integer.parseInt(st.nextToken())-1;

        //이동방향에 따라 비용이 달라질 수 있기 때문에
        distance = new int[n][m][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<3; k++){
                    distance[i][j][k] = INF;
                }
            }
        }

        table = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = dijkstra(sx,sy,ex,ey);

        int result = (answer==-1) ? -1 : distance[ex][ey][answer%3];

        System.out.println(result);
    }

    static int dijkstra(int sx, int sy, int ex, int ey){
        pq = new PriorityQueue<>();
        pq.offer(new Node2(sx, sy, 1, 0));
        distance[sx][sy][1] = 0;

        while(!pq.isEmpty()){
            Node2 current = pq.poll();

            if(distance[current.row][current.col][current.count%3] < current.weight)continue;
            if(current.row==ex && current.col==ey)return current.count;

            if(current.count%3 == 0){
                for(int i=0; i<4; i++)calculate(i, current);
            }
            else if(current.count%3 == 1) {
                for(int i=0; i<2; i++)calculate(i, current);
            }
            else{
                for(int i=2; i<4; i++)calculate(i, current);
            }
        }
        return -1;
    }

    static void calculate(int i, Node2 current){
        int nextRow = current.row + dr[i];
        int nextCol = current.col + dc[i];

        if(nextRow<0 || nextCol<0 || nextRow>=n || nextCol>=m)return;
        if(table[nextRow][nextCol]==-1)return;
        if(distance[nextRow][nextCol][(current.count+1)%3] <= table[nextRow][nextCol] + current.weight)return;
        distance[nextRow][nextCol][(current.count+1)%3] = table[nextRow][nextCol] + current.weight;
        pq.offer(new Node2(nextRow, nextCol, current.count+1, distance[nextRow][nextCol][(current.count+1)%3]));
    }
}

class Node2 implements Comparable<Node2>{
    int row;
    int col;
    int count;
    int weight;

    public Node2(int row, int col, int count, int weight){
        this.row = row;
        this.col = col;
        this.count = count;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node2 o) {
        return this.weight-o.weight;
    }
}
