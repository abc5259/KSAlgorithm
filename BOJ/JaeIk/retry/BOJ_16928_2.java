package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_2 {
    static int[] sequence = new int[101];
    static int[] board;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[101];
        for(int i=1; i<board.length; i++){
            board[i] = i;
        }

        //사다리
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            board[start] = end;
        }

        //뱀
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            board[start] = end;
        }

        bfs();

        System.out.println(sequence[100]);

    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        sequence[1] = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i=1; i<=6; i++){
                int next = current + i;

                if(next<=100 && sequence[board[next]]==0){
                    queue.offer(board[next]);
                    sequence[board[next]] = sequence[current] + 1;
                }
                if(board[next]==100)return;
            }
        }
    }
}