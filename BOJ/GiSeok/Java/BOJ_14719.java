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
        
        int W = Integer.parseInt(st.nextToken());
        int[] map = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++)
            map[i] = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        for (int i = 0; i < W; i++) {
            for (int j = i + 2; j < W; j++) {
                int min = Math.min(map[i], map[j]);
                for (int z = i + 1; z < j; z++) {
                    if (map[z] < min) {
                        ans += (min - map[z]);
                        map[z] += (min - map[z]);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
