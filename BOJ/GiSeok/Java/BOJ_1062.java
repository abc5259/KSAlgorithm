package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1062 {

    static int N;
    static int K;
    static int[] words;

    static int max = 0;
    static int sentence = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        words = new int[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++)
                words[i] |= (1 << (s.charAt(j) - 'a'));

        }

        setInit();
        if (K < 5) max = 0;
        else if (K == 26) max = N;
        else wordMaker(0, 0);
        
        System.out.println(max);
    }

    static void wordMaker(int alpha, int depth) {
        if (depth == (K - 5)) {
            int ans = 0;
            for (int i = 0; i < words.length; i++) {
                if ((sentence & words[i]) == words[i])
                    ans++;
            }

            max = Math.max(max, ans);
        }

        for (int i = alpha; i < 26; i++) {
            if ((sentence & (1 << i)) == 0) {
                sentence = sentence | (1 << i);
                wordMaker(i, depth + 1);
                sentence = sentence & ~(1 << i);
            }
        }
    }

    static void setInit() {
        sentence = sentence | (1 << ('a' - 'a'));
        sentence = sentence | (1 << ('n' - 'a'));
        sentence = sentence | (1 << ('t' - 'a'));
        sentence = sentence | (1 << ('i' - 'a'));
        sentence = sentence | (1 << ('c' - 'a'));
    }
}
