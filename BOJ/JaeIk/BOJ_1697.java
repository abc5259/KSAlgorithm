package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int result;
    static boolean[] visited;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        bfs(n);

        System.out.println(result);
    }

    static void bfs(int start){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 0));
        visited[start] = true;

        while(!queue.isEmpty()){
            Pair currentNode = queue.poll();
            int current = currentNode.node;
            int depth = currentNode.depth;

            if(current==k){
                result = depth;
                break;
            }

            int previous = current-1;
            int next = current+1;
            int teleport = current * 2;

            if(0<=previous && previous<=100000 && !visited[previous]){
                queue.offer(new Pair(previous, depth+1));
                visited[previous] = true;
            }
            if(0<=next && next<=100000 && !visited[next]){
                queue.offer(new Pair(next, depth+1));
                visited[next] = true;
            }
            if(0<=teleport && teleport<=100000 && !visited[teleport]){
                queue.offer(new Pair(teleport, depth+1));
                visited[teleport] = true;
            }
        }
    }
}

class Pair{
    int node;
    int depth;

    Pair(int node, int depth){
        this.node = node;
        this.depth = depth;
    }
}
