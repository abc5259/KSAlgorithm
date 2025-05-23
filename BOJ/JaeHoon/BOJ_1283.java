package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ_1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        Map<String, Character> map = new java.util.HashMap<>();
        Set<Character> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            arr[i] = str;
            String[] strings = str.split(" ");
            int index = 0;
            for (String string : strings) {
                char c = Character.toLowerCase(string.charAt(0));
                if(set.contains(c)) {
                    index += string.length()+1;
                    continue;
                }
                index++;
                set.add(c);
                map.put(str, c);
                break;
            }
            if(map.containsKey(str)) {
                append(str, index-1, sb);
                continue;
            }

            index = 0;
            for (String string : strings) {
                boolean isOk = false;
                int cnt = 0;
                for(int j=0; j<string.length(); j++) {
                    cnt++;
                    char c = Character.toLowerCase(string.charAt(j));
//                    System.out.println(set + " c = " + c);
                    if(set.contains(c)) {
                        continue;
                    }
                    set.add(c);
                    map.put(str, c);
                    isOk = true;
                    break;
                }
                if(isOk) {
                    append(str, index+cnt-1, sb);
                    break;
                }
                index += string.length()+1;
            }
            if(!map.containsKey(str)) {
                sb.append(str).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void append(String str, int index, StringBuffer sb) {
        for(int j = 0; j< str.length(); j++) {
            if(index == j) {
                sb.append("[").append(str.charAt(j)).append("]");
            }else {
                sb.append(str.charAt(j));
            }
        }
        sb.append("\n");
    }
}
