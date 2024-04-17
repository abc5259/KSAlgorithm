package BOJ.JaeIk;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657 {
    static boolean[] visited;
    static int n, m;
    static int[] arr;
    static int[] part;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arr = new int[n];
        part = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solve(0, 0);

        System.out.print(sb);
    }

    static void solve(int depth, int foreNum){
        if(depth == m){
            for(int i=0; i<depth; i++){
                sb.append(part[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i=0; i<n; i++){
            if(arr[i]>=foreNum){
                part[depth] = arr[i];
                solve(depth+1, part[depth]);
            }
        }
    }
}
