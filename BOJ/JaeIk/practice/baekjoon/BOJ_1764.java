package BOJ.JaeIk.practice.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class BOJ_1764
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            String name = br.readLine();
            set.add(name);
        }

        int count = 0;
        List<String> list = new ArrayList<>();
        for(int i=0; i<m; i++) {
            String name = br.readLine();

            if(set.contains(name)) {
                list.add(name);
                count++;
            }
        }

        Collections.sort(list);

        String answer = "";
        answer += count+"\n";
        for(int i=0; i<list.size(); i++) {
            answer += list.get(i)+"\n";
        }

        System.out.print(answer);
    }
}
