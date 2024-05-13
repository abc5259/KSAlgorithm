package BOJ.JaeIk.practice.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합2 {
    static int result;
    static boolean[] visited;
    static int[] arr;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];
            visited = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result=0;
            dfs(0, 0, -1);

            System.out.println("#"+(tc+1)+" "+result);
        }
    }

    static void dfs(int sum, int depth, int foreIdx){
        if(depth==n){
            if(sum==k){
                result++;
                return;
            }else return;
        }

        if(sum==k){
            result++;
            return;
        }
        else if(sum>k)return;

        for(int i=foreIdx+1; i<n; i++) {
            dfs(sum + arr[i], depth + 1, i);
        }
    }
}
