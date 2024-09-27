package BOJ.JaeHoon;

import java.util.*;
import java.io.*;
class Event implements Comparable<Event> {
    int time, what;
    Event(int time, int what) {
        this.time = time;
        this.what = what;
    }
    public int compareTo(Event that) {
        if (this.time < that.time) {
            return -1;
        } else if (this.time == that.time) {
            if (this.what < that.what) {
                return -1;
            } else if (this.what == that.what) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
    public boolean equals(Event that) {
        return this.time == that.time && this.what == that.what;
    }
}
public class BOJ_28284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        ArrayList<Integer> a_min = new ArrayList<>();
        ArrayList<Integer> a_max = new ArrayList<>();
        line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            int x = Integer.parseInt(line[i]);
            a_min.add(x);
            a_max.add(x);
        }
        Collections.sort(a_min);
        Collections.sort(a_max);
        Collections.reverse(a_max);
        a_min.add(0, 0);
        a_max.add(0, 0);
        long[] pre_min = new long[n+1];
        long[] pre_max = new long[n+1];
        for (int i=1; i<=n; i++) {
            pre_min[i] = pre_min[i-1] + a_min.get(i);
            pre_max[i] = pre_max[i-1] + a_max.get(i);
        }
        ArrayList<Event> a = new ArrayList<>();
        for (int i=0; i<m; i++) {
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            a.add(new Event(u, 1));
            a.add(new Event(v+1, 0));
        }
        Collections.sort(a);
        System.out.println(Arrays.toString(pre_min));
        System.out.println(Arrays.toString(pre_max));
        long ans_min = 0;
        long ans_max = 0;

        int cnt = 0;

        int last = 0;

        m *= 2;

        for (int i=0; i<m; i++) {
            int t = a.get(i).time;
            int what = a.get(i).what;
            int cur = Math.min(cnt, n);
            long ansMin = pre_min[cur] * (t - last);
            long ansMax = pre_max[cur] * (t - last);
            ans_min += ansMin;
            ans_max += ansMax;
            if (what == 0) {
                cnt -= 1;
            } else {
                cnt += 1;
            }
            last = t;
        }
        System.out.println(ans_min + " " + ans_max);
    }
}