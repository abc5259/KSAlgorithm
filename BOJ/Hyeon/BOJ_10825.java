package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Info> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int mat = Integer.parseInt(st.nextToken());
            list.add(new Info(name, kor, eng, mat));
        }
        Collections.sort(list);

        for (Info info : list) {
            sb.append(info.name).append("\n");
        }
        System.out.println(sb);
    }

    static class Info implements Comparable<Info> {
        private String name;
        private int kor;
        private int eng;
        private int mat;

        public Info(String name, int kor, int eng, int mat) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
        }

        @Override
        public int compareTo(Info o) {
            if (this.kor == o.kor) {
                if (this.eng == o.eng) {
                    if (this.mat == o.mat) {
                        return this.name.compareTo(o.name);
                    }
                    return o.mat - this.mat;
                }
                return this.eng - o.eng;
            }
            return o.kor - this.kor;
        }
    }
}

// S4 국영수 정렬
// Comparable 과 자료형이 다른 것들을 class로 묶어서 객체화 시켜서 처리하는것
// 비교 구현이 주류 문제
// arraylist 등 다양한 자료구조 사용가능.