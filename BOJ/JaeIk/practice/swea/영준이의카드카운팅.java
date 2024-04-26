package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 영준이의카드카운팅 {
    static Map<String, Integer> map;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            map = new HashMap<>();
            map.put("S", 13);
            map.put("D", 13);
            map.put("H", 13);
            map.put("C", 13);

            set = new HashSet<>();

            String info = br.readLine();

            boolean flag = false;
            for(int i=0; i<info.length(); i+=3){
                String token = info.substring(i, i+3);

                if(set.contains(token)){
                    flag = true;
                    break;
                }
                set.add(token);

                String sign = token.substring(0,1);
                map.replace(sign, map.get(sign)-1);
            }

            if(flag){
                System.out.println("#"+(tc+1)+" ERROR");
            }else{
                System.out.println("#"+(tc+1)+" "+map.get("S")+" "+map.get("D")+" "+map.get("H")+" "+map.get("C"));
            }
        }
    }
}
