package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                String p1 = str.substring(0, i + 1);
                String p2 = str.substring(i + 1, j + 1);
                String p3 = str.substring(j + 1);

                StringBuilder sb1 = new StringBuilder(p1);
                StringBuilder sb2 = new StringBuilder(p2);
                StringBuilder sb3 = new StringBuilder(p3);

                list.add(sb1.reverse() + sb2.reverse().toString() + sb3.reverse());
            }
        }
        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
// S5 단어 나누기 완탐
// 다시 풀기