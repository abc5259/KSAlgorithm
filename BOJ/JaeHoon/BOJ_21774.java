package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_21774 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Long>> logs = new ArrayList<>();
        for(int i=0; i<7; i++) logs.add(new ArrayList<>());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(),"#");
            String s = st.nextToken();
            int lv = Integer.parseInt(st.nextToken());
            logs.get(lv).add(Long.parseLong(s.replaceAll("[- :]","")));
        }

        for(int i=1; i<=6;i++) {
            if(logs.get(i).size() > 1)
                Collections.sort(logs.get(i));
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine(),"#");
            long start = Long.parseLong(st.nextToken().replaceAll("[- :]",""));
            long end = Long.parseLong(st.nextToken().replaceAll("[- :]",""));
            int level = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for(int lv=level; lv<=6; lv++) {
                if(logs.get(lv).size() < 1) continue;
                int low = -1;
                int high = logs.get(lv).size();

                while (low + 1 < high) {
                    int mid = (low + high) / 2;
                    if(logs.get(lv).get(mid) >= start) {
                        high = mid;
                    }else {
                        low = mid;
                    }
                }

                int l = high;


                low = -1;
                high = logs.get(lv).size();

                while (low + 1 < high) {
                    int mid = (low + high) / 2;
                    if(logs.get(lv).get(mid) <= end) {
                        low = mid;
                    }else {
                        high = mid;
                    }
                }
                int r = low;
                cnt += r - l + 1;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }



}





//1 1
//2021-04-05 17:12:11#1
//2021-04-05 17:17:11#2021-04-05 17:18:10#1
