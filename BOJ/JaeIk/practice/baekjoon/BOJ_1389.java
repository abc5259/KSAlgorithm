package BOJ.JaeIk.practice.baekjoon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    static List<Integer>[] relation;
    static int n, m;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        relation = new List[n+1];
        for(int i=1; i<n+1; i++) {
            relation[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a].add(b);
            relation[b].add(a);
        }
        for(int i=1; i<=n; i++) {
            Collections.sort(relation[i]);
        }

        System.out.println(getAnswer());
    }

    static int getAnswer() {
        int answer=0;
        int min = Integer.MAX_VALUE;

        for(int start=1; start<=n; start++) {
            Queue<Integer[]> queue = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            queue.add(new Integer[] {start, 0});
            visited[start] = true;

            int bacon = 0;
            while(!queue.isEmpty()) {
                Integer[] now = queue.poll();
                int node = now[0];
                int count = now[1];

                for(int i=0; i<relation[node].size(); i++) {
                    int next = relation[node].get(i);

                    if(visited[next])continue;

                    bacon += count+1;
                    visited[next] = true;
                    queue.add(new Integer[] {next, count+1});
                }
            }

            if(min > bacon) {
                min = bacon;
                answer = start;
            }
        }

        return answer;
    }
}