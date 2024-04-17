package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        

        // 얘는 투 포인터 방식
        int W = Integer.parseInt(st.nextToken());
        int[] map = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++)
            map[i] = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        for (int idx = 1; idx < W-1; idx++) {
            int left = 0, right = 0;

            for (int i = 0; i < idx; i++)
                left = Math.max(left, map[i]);
            
            for (int i = idx + 1; i < W; i++)
                right = Math.max(right, map[i]);
            
            if (map[idx] < left && map[idx] < right)
                ans += (Math.min(left, right) - map[idx]);
        }

        System.out.println(ans);
    }
}
