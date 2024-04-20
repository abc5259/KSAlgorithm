package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        int[] schedule = new int[K];
        String[] used = br.readLine().split(" ");
        for (int i = 0; i < K; i++)
            schedule[i] = Integer.parseInt(used[i]);
        
        int ans = 0;
        int cnt = 0;
        boolean[] use = new boolean[101];

        for (int i = 0; i < K; i++) {
            int idx = schedule[i];

            if (!use[idx]) {
                if (cnt < N) { use[idx] = true; cnt++; }
                else {
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
        }

        System.out.println(ans);
    }
}
