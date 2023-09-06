package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14889 {
    static int sum;
    static ArrayList<Integer> cPocket = new ArrayList<>();
    static ArrayList<Integer> fPocket;
    static ArrayList<Integer> tPocket = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static Boolean[] visited;
    static Boolean[] pVisited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new Boolean[n+1];
        pVisited = new Boolean[n/2];

        for(int i=0; i<n/2; i++){
            pVisited[i] = false;
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            visited[i] = false;
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0);

        System.out.println(min);
    }

    static void search(int depth){
        if(depth == n/2) {
            fPocket = new ArrayList<>();

            for(int i=1; i<=n; i++){
                if(!visited[i])fPocket.add(i);
            }

            calc(tPocket, 0);
            int result = sum;
            sum = 0;
            calc(fPocket, 0);
            result = Math.abs(result - sum);

            min = Math.min(min, result);
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                tPocket.add(i);
                search(depth+1);
                visited[i] = false;
                tPocket.remove(depth);
            }
        }
    }

    static void calc(ArrayList<Integer> pocket, int depth){

        if(depth == 2){
            sum += result(cPocket);
            return;
        }

        for(int i=0; i<n/2; i++){
            if(!pVisited[i]){
                pVisited[i] = true;
                cPocket.add(pocket.get(i));
                calc(pocket,depth+1);
                pVisited[i] = false;
                cPocket.remove(depth);
            }
        }
    }

    static int result(ArrayList<Integer> p){
        return map[p.get(0)][p.get(1)];
    }
}
