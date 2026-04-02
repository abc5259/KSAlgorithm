package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> enter = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                enter.add(name);
            } else {
                enter.remove(name);
            }
        }

        List<String> now = new ArrayList<>(enter);
        now.sort(Comparator.reverseOrder());

        for (int i = 0; i < now.size(); i++) {
            System.out.println(now.get(i));
        }

        // 1.
        // Baha enter
        // Baha leave
        // Baha enter
        // 인 경우 실패함
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            String name = st.nextToken();
//            String status = st.nextToken();
//
//            if (status.equals("enter")) {
//                enter.add(name);
//            } else {
//                leave.add(name);
//            }
//        }
//
//        enter.removeAll(leave);
//        List<String> now = new ArrayList<>(enter);
//
//        now.sort(Comparator.reverseOrder());
//
//        for (int i = 0; i < now.size(); i++) {
//            System.out.println(now.get(i));
//        }
    }
}
