package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17825 {
    static int[] arr;
    static int[] posArr = new int[4];
    static List<List<Integer>> graph = new ArrayList<>();
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[10];
        initLoad();
        for(int i=0; i<10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(max);
    }
    static void dfs(int depth, int sum) {
        if(depth == 10) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int cnt = arr[depth];
            int temp = posArr[i];
            if(temp == -1) {
                continue;
            }
            move(i, cnt);

            boolean check = true;
            if(posArr[i] != -1) {
                for(int j=0; j<4; j++) {
                    if(i == j) continue;
                    if(posArr[i] == posArr[j]) {
                        check = false;
                        break;
                    }
                }
            }
            if(!check) {
                posArr[i] = temp;
                continue;
            }
            dfs(depth+1, sum + map.getOrDefault(posArr[i], 0));
            posArr[i] = temp;
        }
    }

    private static void move(int i, int cnt) {
        if(graph.get(posArr[i]).size() == 2) { // 무조건 파란줄로
            cnt--;
            posArr[i] = graph.get(posArr[i]).get(1);
        }
        while(cnt-- > 0) {
            if(graph.get(posArr[i]).isEmpty()) { // 끝
                posArr[i] = -1;
                break;
            }
            posArr[i] = graph.get(posArr[i]).get(0);
        }
    }

    static void initLoad() {
        for(int i=0; i<=32; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=1; i<=19; i++) {
            graph.get(i).add(i+1);
        }
        graph.get(0).add(1);
        graph.get(5).add(21);
        graph.get(21).add(22);
        graph.get(22).add(23);
        graph.get(23).add(24);

        graph.get(15).add(27);
        graph.get(27).add(26);
        graph.get(26).add(25);
        graph.get(25).add(24);

        graph.get(10).add(28);
        graph.get(28).add(29);
        graph.get(29).add(24);

        graph.get(24).add(30);
        graph.get(30).add(31);
        graph.get(31).add(20);
    }
    static Map<Integer, Integer> map = Map.ofEntries(
            Map.entry(0, 1),
            Map.entry(1, 2),
            Map.entry(2, 4),
            Map.entry(3, 6),
            Map.entry(4,8),
            Map.entry(5, 10),
            Map.entry(6, 12),
            Map.entry(7, 14),
            Map.entry(8, 16),
            Map.entry(9, 18),
            Map.entry(10, 20),
            Map.entry(11, 22),
            Map.entry(12, 24),
            Map.entry(13, 26),
            Map.entry(14, 28),
            Map.entry(15, 30),
            Map.entry(16, 32),
            Map.entry(17, 34),
            Map.entry(18, 36),
            Map.entry(19, 38),
            Map.entry(20, 40),
            Map.entry(21, 13),
            Map.entry(22, 16),
            Map.entry(23, 19),
            Map.entry(24, 25),
            Map.entry(25, 26),
            Map.entry(26, 27),
            Map.entry(27, 28),
            Map.entry(28, 22),
            Map.entry(29, 24),
            Map.entry(30, 30),
            Map.entry(31, 35)
    );
}
