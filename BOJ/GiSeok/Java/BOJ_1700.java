package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] use = new boolean[101];

        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        int[] schedule = new int[K];
        String[] things = br.readLine().split(" ");

        int cnt = 0;
        for (int i = 0; i < K; i++) {
            schedule[i] = Integer.parseInt(things[i]);
            if (cnt < N && !use[schedule[i]]) { use[schedule[i]] = true; cnt++; }
        }
        
        int ans = 0;
        for (int i = N; i < K; i++) {
            int idx = schedule[i];

            if (!use[idx]) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = i + 1; j < K; j++) {
                    if (use[schedule[j]] && !list.contains(schedule[j]))
                        list.add(schedule[j]);
                }

                if (list.size() != N) {
                    for (int j = 0; j < i; j++) {
                        if (use[schedule[j]] && !list.contains(schedule[j])) {
                            use[schedule[j]] = false;
                            break;
                        }
                    }
                } else
                    use[list.get(list.size() - 1)] = false;

                use[idx] = true;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
