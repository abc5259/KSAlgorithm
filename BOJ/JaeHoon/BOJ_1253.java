package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                int key = arr[i] + arr[j];
                List<int[]> list = map.getOrDefault(key, new ArrayList<>());
                list.add(new int[]{i,j});
                map.put(key, list);
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++) {
            List<int[]> list = map.get(arr[i]);
            if(list == null) continue;
            for (int[] ints : list) {
                if(ints[0] != i && ints[1] != i) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
