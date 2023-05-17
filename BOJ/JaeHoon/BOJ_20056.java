package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20056 {
    static int N,M,K;
    static Fireball[][] map;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static Map<String, Stack<Fireball>> fireballMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Fireball[N][N];


        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r  = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            fireballMap.put(r + " " + c,new Stack<>());
            fireballMap.get(r + " " + c).push(new Fireball(
                    r,c,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        for(int i=0; i<K; i++) {
            move();
            clear();
        }

        int answer = 0;
        Iterator<String> keys = fireballMap.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            Stack<Fireball> fireballs = fireballMap.get(key);
            if(fireballs.size() > 0) {
                while (!fireballs.isEmpty()) {
                    Fireball curr = fireballs.pop();
                    answer += curr.m;
                }
            }
        }

        System.out.println(answer);
    }
    public static void clear() {

        for (Map.Entry<String, Stack<Fireball>> entry : fireballMap.entrySet()) {
            Stack<Fireball> fireballs = entry.getValue();

            if(fireballs.size() > 1) {
                int size = fireballs.size();
                int totalM = 0;
                int totalS = 0;
                boolean isAllEven = true;
                boolean isAllOdd = true;
                int r = fireballs.peek().r;
                int c = fireballs.peek().c;
                while (!fireballs.isEmpty()) {
                    Fireball curr = fireballs.pop();
                    totalM += curr.m;
                    totalS += curr.s;
                    if(curr.d % 2 != 0 && isAllEven) isAllEven = false;
                    if(curr.d % 2 == 0 && isAllOdd) isAllOdd = false;
                }

                int m = totalM / 5;
                int s = totalS / size;

                if(m == 0) continue; //질량이 0이면 없어짐

                if(isAllEven || isAllOdd) {
                    for(int i=0; i<=6; i+=2) {
                        fireballs.add(new Fireball(r,c,m,s,i));
                    }
                }
                else {
                    for(int i=1; i<=7; i+=2) {
                        fireballs.add(new Fireball(r,c,m,s,i));
                    }
                }
            }
        }
    }
    public static void move() {
        Iterator<String> keys = fireballMap.keySet().iterator();
        Stack<Fireball> nextFireballStack = new Stack<>();
        while (keys.hasNext()) {
            String key = keys.next();
            Stack<Fireball> fireballs = fireballMap.get(key);
            while (!fireballs.isEmpty()) {
                Fireball curr = fireballs.pop();
                int nextR = (curr.r + dx[curr.d] * curr.s) % N;
                int nextC = (curr.c + dy[curr.d] * curr.s) % N;
                if(nextR < 0) nextR = N + nextR;
                if(nextC < 0) nextC = N + nextC;
                curr.r = nextR;
                curr.c = nextC;
                nextFireballStack.push(curr);
            }
        }

        while (!nextFireballStack.isEmpty()) {
            Fireball curr = nextFireballStack.pop();
            String key = curr.r + " " + curr.c;
            if(fireballMap.containsKey(key)) {
                fireballMap.get(key).push(curr);
            }else {
                Stack<Fireball> stack = new Stack<>();
                stack.push(curr);
                fireballMap.put(key,stack);
            }
        }
    }
    static class Fireball {
        int r,c,m,s,d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Fireball{" +
                    "r=" + r +
                    ", c=" + c +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    '}';
        }
    }
}
