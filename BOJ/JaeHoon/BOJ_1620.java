package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620 {

    public static void main(String[] args) throws IOException {
        //1:03
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            map1.put(s, i+1);
            map2.put(i+1, s);
        }
        for(int i=0; i<m; i++) {
            String s = br.readLine();
            if(map1.containsKey(s)) {
                sb.append(map1.get(s)).append('\n');
            }
            else if(map2.containsKey(Integer.parseInt(s))) {
                sb.append(map2.get(Integer.parseInt(s))).append('\n');
            }
        }
        System.out.print(sb);
    }
}
