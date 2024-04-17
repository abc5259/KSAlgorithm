package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1062 {

    static int N;
    static int K;
    static int max = -1;
    static String[] words;
    static boolean[] sentence = new boolean[26];

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        words = new String[N];
        for (int i = 0; i < N; i++)
            words[i] = br.readLine().replace("anta", "").replace("tica", "");

        setInit();
        if (K < 5) max = 0;
        else if (K == 26) max = N;
        else wordMaker(0, 0);
        
        System.out.println(max);
    }

    static void wordMaker(int alpha, int depth) {
        if (depth == (K - 5)) {
            int ans = 0;
            for (String word : words) {
                boolean isNotWord = false;
                for (int i = 0; i < word.length(); i++) {
                    if (!sentence[word.charAt(i) - 'a']) {
                        isNotWord = true;
                        break;
                    }
                }

                if (!isNotWord) ans++;
            }

            max = Math.max(max, ans);
        }

        for (int i = alpha; i < 26; i++) {
            if (!sentence[i]) {
                sentence[i] = true;
                wordMaker(i, depth + 1);
                sentence[i] = false;
            }
        }
    }

    static void setInit() {
        sentence['a' - 'a'] = true;
        sentence['n' - 'a'] = true;
        sentence['t' - 'a'] = true;
        sentence['c' - 'a'] = true;
        sentence['i' - 'a'] = true;
    }
}
