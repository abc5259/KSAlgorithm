package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static final int MIN = 0;
    static final int MAX = 100_001;
    static final int FORWARD = 1;
    static final int BACK = -1;
    static final int TELEPORT = 2;
    static List<Integer> graph;
    static int[] check;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        check = new int[MAX];

        int answer = (n==k) ? 0 : bfs(n);

        System.out.println(answer);
    }

    static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = 1;

        while(!queue.isEmpty()){
            int current = queue.poll();
            int before = current+BACK;
            int forward = current+FORWARD;
            int teleport = current*TELEPORT;
            int[] next = {before, forward, teleport};

            for(int nextNode : next){
                if(nextNode == k){
                    return check[current];
                }

                if(nextNode>=MIN && nextNode<MAX){
                    if(check[nextNode]==0){
                        queue.add(nextNode);
                        check[nextNode] = check[current]+1;
                    }
                }
            }
        }
        return -1;
    }
}
