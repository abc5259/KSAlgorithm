package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자기방으로돌아가기 {
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            visited = new int[200];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                int s = Math.min(start, end);
                int e = Math.max(start, end);

                s = (s-1)/2;
                e = (e-1)/2;

                for(int j=s; j<=e; j++){
                    visited[j]++;
                }
            }

            int result = 0;
            for(int i=0; i<200; i++){
                result = Math.max(result, visited[i]);
            }

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
