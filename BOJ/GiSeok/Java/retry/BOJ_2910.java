/**
 * 00:21:09 S3
 */
package BOJ.GiSeok.Java.retry;

import java.util.*;
import java.io.*;

public class BOJ_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> message = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            message.put(num,
                message.getOrDefault(num, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.size(); i++) {
            int max = 0;
            int maxKey = 0;
            for (int key : message.keySet()) {
                if (message.get(key) == -1) continue;
                if (max < message.get(key)) {
                    max = message.get(key);
                    maxKey = key;
                }
            }
            for (int j = 0; j < message.get(maxKey); j++) {
                sb.append(maxKey).append(" ");
            }
            message.put(maxKey, -1);
        }

        System.out.println(sb);
    }
}
