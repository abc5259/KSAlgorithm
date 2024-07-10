/**
 * 9375 - 패션왕 신해빈, 시도3 [실패]
 * 조합, 실버3
 * 해당 문제를 정석적인? 조합으로 풀려고만 시도한 것이 문제였다.
 * 아무것도 안입는 경우의 수를 포함시켜서 계산을 하면 되는데 자꾸 따로 계산을 하려했던 것이 패착의 원인
 * 2C1 * 1C1 + 2C0 * 1C1 + 2C1 * 1C0 = 5 와 같이 계산하려고 했는데, 정답을 보니
 * 그냥 안 뽑는 경우의 수를 옷 종류 각각에 포함시키면 된다.
 * 3C1 * 2C1 = 6 - 1(아무것도 안입게 되는 경우의 수) = 5
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_9375 {

    static HashMap<String, Integer> map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            map = new HashMap<>();
            n = Integer.parseInt(br.readLine());

            for (int x = 0; x < n; x++) {
                String key = br.readLine().split(" ")[1];
                if (map.containsKey(key)) map.put(key, map.get(key) + 1);
                else map.put(key, 1);
            }

            int cnt = 1;
            for (String key : map.keySet()) cnt *= (map.get(key) + 1);
            
            System.out.println(cnt - 1);
        }
    }
}
