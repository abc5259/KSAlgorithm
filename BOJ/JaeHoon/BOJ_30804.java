package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_30804 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            int item = Integer.parseInt(st.nextToken());
            arr[i] = item;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        if(map.size() <= 2) {
            System.out.println(N);
            return;
        }

        int low = 1;
        int high = N;

        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if(check(mid)) {
                low = mid;
            }else {
                high = mid;
            }
        }

        System.out.println(low);
    }

    public static boolean check(int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<target; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        if(map.size() <= 2) return true;
        for(int i=target; i<N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map.put(arr[i-target], map.getOrDefault(arr[i-target], 0) - 1);
            if(map.get(arr[i-target]) == 0) {
                map.remove(arr[i-target]);
            }
            if(map.size() <= 2) return true;
        }
        return false;
    }
}
