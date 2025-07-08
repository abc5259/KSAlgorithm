/**
 * 00:15:10 S4
 * 00:06:29 S4
 */
package BOJ.GiSeok.Java.retry;

import java.util.*;
import java.io.*;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> pokemonDocs = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String pokemonName = br.readLine();
            pokemonDocs.put(pokemonName, String.valueOf(i));
            pokemonDocs.put(String.valueOf(i), pokemonName);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(pokemonDocs.get(br.readLine()));
        }
    }
}
