/**
 * [S5 집합] 임스와 함께하는 미니게임 - O, 00:09:24
 * 시도 1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        int ret = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(br.readLine());
        if (game == 'Y') ret = set.size();
        else if (game == 'F') ret = set.size() / 2;
        else ret = set.size() / 3;

        System.out.println(ret);
    }
}
