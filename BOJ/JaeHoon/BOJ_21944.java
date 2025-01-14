package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_21944 {
    static int N;
    static TreeSet<Problem>[] arr = new TreeSet[101];
    static TreeSet<Problem> lTree = new TreeSet<>((a,b) -> {
        if(a.l == b.l) {
            return a.p - b.p;
        }
        return a.l - b.l;
    });
    static Map<Integer, Problem> problemMap = new HashMap<Integer, Problem>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<101; i++) {
            arr[i] = new TreeSet<>((a,b) -> {
                if(a.l == b.l) {
                    return a.p - b.p;
                }
                return a.l - b.l;
            });
        }
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            add(st);
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")) {
                add(st);
            }
            else if(command.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                Problem problem = problemMap.get(p);
                lTree.remove(problem);
                arr[problem.g].remove(problem);
                problemMap.remove(p);
            }
            else if(command.equals("recommend")) {
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    Problem last = arr[g].last();
                    sb.append(last.p).append('\n');
                }else {
                    Problem first = arr[g].first();
                    sb.append(first.p).append('\n');
                }
            }
            else if(command.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    Problem last = lTree.last();
                    sb.append(last.p).append('\n');
                }else {
                    Problem first = lTree.first();
                    sb.append(first.p).append('\n');
                }
            }
            else if(command.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    Problem higher = lTree.higher(new Problem(-1,L,-1));
                    if(higher != null) {
                        sb.append(higher.p).append('\n');
                    }else {
                        sb.append(-1).append('\n');
                    }
                }else {
                    Problem lower = lTree.lower(new Problem(-1,L,-1));
                    if(lower != null) {
                        sb.append(lower.p).append('\n');
                    }else {
                        sb.append(-1).append('\n');
                    }
                }
            }
        }

        System.out.println(sb);
    }

    private static void add(StringTokenizer st) {
        int p = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        Problem problem = new Problem(p, l, g);
        arr[problem.g].add(problem);
        lTree.add(problem);
        problemMap.put(problem.p, problem);
    }

    static class Problem {
        int p,l,g;

        public Problem(int p, int l, int g) {
            this.p = p;
            this.l = l;
            this.g = g;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Problem problem = (Problem) o;
            return p == problem.p;
        }

        @Override
        public int hashCode() {
            return p;
        }
    }
}
