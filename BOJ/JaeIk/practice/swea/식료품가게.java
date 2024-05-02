package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 식료품가게 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            Long[] arr = new Long[n*2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n*2; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }

            boolean[] visited = new boolean[n*2];
            List<Long> result = new ArrayList<>();
            for(int i=0; i<arr.length-1; i++){
                for(int j=i+1; j< arr.length; j++){
                    if(visited[i] || visited[j])continue;

                    if((arr[i]/3)*4 == arr[j]){
                        visited[i] = true;
                        visited[j] = true;
                        result.add(arr[i]);
                    }
                }
            }

            Collections.sort(result);

            System.out.print("#"+(tc+1)+" ");
            for(int i=0; i<result.size(); i++){
                System.out.print(result.get(i)+" ");
            }
            System.out.println();
        }
    }
}
