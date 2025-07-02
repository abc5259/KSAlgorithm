package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<M; i++) {
            String[] keywords = br.readLine().split(",");
            for (String keyword : keywords) {
                set.remove(keyword);
            }
            sb.append(set.size()).append("\n");
        }
        System.out.print(sb);
    }
}
