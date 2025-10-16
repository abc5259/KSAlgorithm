package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Info[] infos = new Info[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            infos[i] = new Info(name, day, month, year);
        }
        Arrays.sort(infos, (o1, o2) -> {
            if (o1.year == o2.year) {
                if (o1.month != o2.month) {
                    return o1.month - o2.month;
                }
                return o1.day - o2.day;
            }
            return o1.year - o2.year;
        });
        System.out.println(infos[n - 1].name);
        System.out.println(infos[0].name);
    }

    static class Info {
        String name;
        int day;
        int month;
        int year;

        public Info(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}
// S5 생일 정렬
// 3분
// 그냥 클래스로 만들어서 정렬해버리니 끝났다.
