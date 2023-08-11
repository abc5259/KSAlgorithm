package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {

    static int board[] = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        board = new int[101];
        for (int i = 1; i < board.length; i++) {
            board[i] = i;
        }

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        System.out.println(bfs(1));
    }

    static int bfs(int start){
        int[] check = new int[101];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        //처음 시작점을 기준으로 0부터 시작한다
        check[start] = 0;

        while(true){
            int visitedNum = q.poll();

            for(int i=1; i<7; i++){
                int newNode = visitedNum+i;
                if(newNode>100)continue;
                if(check[board[newNode]]==0){
                    q.offer(board[newNode]);
                    check[board[newNode]] = check[visitedNum]+1;
                }
                if(board[newNode]==100){
                    return check[100];
                }
            }
        }
    }
}
