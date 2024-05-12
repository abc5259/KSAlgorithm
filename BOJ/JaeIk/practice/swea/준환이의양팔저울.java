package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 준환이의양팔저울 {
    static int answer;
    static int n;
    static int[] weight;
    static int[] sorted;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            answer = 0;
            n = Integer.parseInt(br.readLine());

            weight = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                weight[i] = Integer.parseInt(st.nextToken());
            }

            sorted = new int[n];
            visited = new boolean[n];
            sequence(0);

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static void sequence(int depth){
        if(depth == n){
            subset(0, 0, 0);
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                sorted[depth] = weight[i];

                sequence(depth+1);

                visited[i] = false;
            }
        }
    }

    static void subset(int depth, int left, int right){
        if(left<right){
            return;
        }

        if(depth == n){
            answer++;
            return;
        }

        subset(depth+1, left, right+sorted[depth]);
        subset(depth+1, left+sorted[depth], right);
    }
}
