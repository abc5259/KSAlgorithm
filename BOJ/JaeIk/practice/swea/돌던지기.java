package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 돌던지기
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int people = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dist = new int[100001];
            for(int i=0; i<people; i++) {
                int spot = Integer.parseInt(st.nextToken());
                int distance = Math.abs(spot);
                dist[distance]++;
            }

            int answer=0;
            int count = 0;
            for(int i=0; i<dist.length; i++) {
                if(dist[i]>0) {
                    answer = i;
                    count = dist[i];
                    break;
                }
            }

            System.out.println("#"+(tc+1)+" "+answer+" "+count);
        }

    }


}


