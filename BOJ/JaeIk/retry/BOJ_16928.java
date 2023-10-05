package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
    //보드를 일차원으로 표현
    static int[] board;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //인덱스 번호를 1부터 붙이기 위해서
        board = new int[101];

        for(int i=0; i< board.length; i++){
            board[i] = i;
        }

        //사다리 정보
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        //뱀 정보
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[u] = v;
        }

        System.out.println(bfs(1));

    }

    static int bfs(int start){
        int[] check = new int[101];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = 0; //왜 1로 체크하지 않는가

        while(true){
            int curNode = q.poll();

            for(int i=1; i<7; i++){
                int newNode = curNode + i;

                if(newNode>100)continue;

                if(check[board[newNode]]==0){
                    q.offer(board[newNode]);
                    check[board[newNode]] = check[curNode]+1;
                }

                if(board[newNode]==100)return check[100];
            }
        }
    }
}
