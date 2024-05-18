package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대상금3 {
    static int answer;
    static int[] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] input = st.nextToken().toCharArray();
            n = Integer.parseInt(st.nextToken());

            map = new int[input.length];
            for(int i=0; i<map.length; i++){
                map[i] = input[i]-'0';
            }

            n = Math.min(n, map.length);

            answer = 0;
            dfs(0);

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static void dfs(int depth){
        if(depth == n){
            StringBuilder sb = new StringBuilder();
            for(int num : map){
                sb.append(num);
            }

            answer = Math.max(Integer.parseInt(sb.toString()), answer);
            return;
        }

        for(int i=0; i<map.length-1; i++){
            for(int j=i+1; j<map.length; j++){
                int temp = map[i];
                map[i] = map[j];
                map[j] = temp;

                dfs(depth+1);

                temp = map[i];
                map[i] = map[j];
                map[j] = temp;
            }
        }
    }
}
