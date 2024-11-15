/**
 * 10814 - 나이순 정렬(S5) [O|00:13:44]
 * 정렬, 시도3
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_10814 {

    static class User {
        int age;
        String name;
        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<User> user = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            user.add(new User(age, name));
        }

        user.sort(Comparator.comparingInt(o -> o.age));

        for (int i = 0; i < n; i++) {
            System.out.println(user.get(i).age + " " + user.get(i).name);
        }
    }
}
