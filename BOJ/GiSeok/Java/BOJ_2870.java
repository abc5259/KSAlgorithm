/**
 * 2870 - 수학숙제 [성공|01:01:17]
 * 실버4, 구현/정렬, 시도5
 * 
 * 조건에 부합하는 로직을 작성하고 정렬만 잘하면 되는 문제임.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class BOJ_2870 {
    // 숫자와 알파벳 소문자로 되어있는 글자 N줄
    // 숫자를 모두 찾아 비내림차순(오름차순)으로 정리
    // 숫자 앞 0이면 생략
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String n = br.readLine();

            String ret = "";
            for (int j = 0; j < n.length(); j++) {
                if (n.charAt(j) == '0') {
                    if (ret.length() == 0) ret += n.charAt(j);
                    else {
                        if (!ret.startsWith("0")) ret += n.charAt(j);
                    }
                } else if (n.charAt(j) > '0' && n.charAt(j) <= '9') {
                    ret += n.charAt(j);
                    if (ret.length() > 0 && ret.startsWith("0"))
                        ret = ret.substring(1, ret.length());
                }
                else {
                    if (ret.length() > 0) list.add(ret);
                    ret = "";
                }

                if (j == (n.length() - 1))
                    if (ret.length() > 0) list.add(ret);
            }
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() > b.length())
                    return 1;
                else if (a.length() < b.length())
                    return -1;
                else 
                    return a.compareTo(b);
            }
        });
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
