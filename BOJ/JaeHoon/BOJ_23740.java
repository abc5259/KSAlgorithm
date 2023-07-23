package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_23740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Bus[] buses = new Bus[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            buses[i] = new Bus(S,E,C);
        }

        Arrays.sort(buses,(a,b) -> {
            if(a.S == b.S) return a.E - b.E;
            return a.S - b.S;
        });

        StringBuffer sb = new StringBuffer();
        int start = buses[0].S;
        int end = buses[0].E;
        int minCost = buses[0].C;
        List<Bus> results = new ArrayList<>();
        for(int i=1; i<N; i++) {
            if(buses[i].S <= end) {
                minCost = Math.min(minCost,buses[i].C);
                end = Math.max(end,buses[i].E);
            }else {
                results.add(new Bus(start,end,minCost));
                start = buses[i].S;
                end = buses[i].E;
                minCost = buses[i].C;
            }
        }
        results.add(new Bus(start,end,minCost));
        sb.append(results.size()+"\n");
        for (Bus result : results) {
            sb.append(result);
        }
        System.out.println(sb);
    }
    static class Bus {
        int S,E,C;

        public Bus(int s, int e, int c) {
            S = s;
            E = e;
            C = c;
        }

        @Override
        public String toString() {
            return S + " " + E + " " + C + "\n";
        }
    }
}
