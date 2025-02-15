package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        List<String> arr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            if(s.length() >= M) {
                if(!map.containsKey(s)) {
                    arr.add(s);
                }
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        arr.sort((a,b) -> {
            if(map.get(a) == map.get(b)) {
                if(a.length() == b.length()) {
                    return a.compareTo(b);
                }
                return b.length() - a.length();
            }
            return map.get(b) - map.get(a);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}
