package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Country[] countries = new Country[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries[i] = new Country(id, gold, silver, bronze);
        }

        Arrays.sort(countries);
        int grade = 0;
        int cnt = 1;
        Country prev = null;
        for(int i=0; i<N; i++) {
            if(prev == null) {
                grade++;
            }
            else if(countries[i].compareTo(prev) != 0) {
                grade+=cnt;
                cnt = 1;
            }
            else {
                cnt++;
            }
            if(countries[i].id == K) {
                System.out.println(grade);
                break;
            }
            prev = countries[i];
        }
    }
    static class Country implements Comparable<Country> {
         int id, gold, silver, bronze;

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if(o.gold == this.gold) {
                if(o.silver == this.silver) {
                    return o.bronze - this.bronze;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }
}