package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5635_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Students[] s = new Students[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            s[i] = new Students(name, day, month, year);
        }
        Arrays.sort(s);

        System.out.println(s[n - 1].name);
        System.out.println(s[0].name);
    }

    static class Students implements Comparable<Students> {
        String name;
        int day;
        int month;
        int year;

        public Students(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Students o1) {
            if (this.year == o1.year) {
                if (this.month == o1.month) {
                    return this.day - o1.day;
                }
                return this.month - o1.month;
            }
            return this.year - o1.year;
        }
    }
}
// S5 생일 정렬 복습
// 15분
// trouble shooting
// Comparable 이랑 Comparator 를 헷갈리게 쓰면 안됨 자동완성에 절여져서,,
// Comparable 비교 가능한 인터페이스
// 클래스 자체가 비교가능한 정렬 기준을 가지게 된다.
// 일단 Arrays.sort 에 객체를 1개를 넘길 경우 Comparable 을 통해서 내가 가지고 있는 this 객체와
// 넘겨진 s 객체를 비교하여 정렬한다. 배열 s 객체는 걍 정렬이 알아서
// Comparator 비교하는 것
// 익명 클래스로 Arrays.sort 에 2개의 매개변수를 통해서 비교한다
// 비교 가능한은 1개의 객체와 this 자기 자신이었는데 여기서는 2개의 객체로 비교해서 정렬하면서 비교한다.