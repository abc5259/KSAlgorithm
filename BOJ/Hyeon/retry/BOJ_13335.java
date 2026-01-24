package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> trucks = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new ArrayDeque<>();

        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int currentWeight = 0;

        while (!trucks.isEmpty()) {
            time++;
            currentWeight -= bridge.poll();

            if (currentWeight + trucks.peek() <= L) {
                int truck = trucks.poll();
                bridge.offer(truck);
                currentWeight += truck;
            } else {
                bridge.offer(0);
            }
        }
        System.out.println(time + w);
    }
}
// S1 트럭 큐
// 40분
// 일단 어떻게 풀어야되는지 도저히 감이 안잡혔다 이게 L과 w 를 동시에 신경써야 되다보니
// 손 코딩으로는 계속 풀리는데 어떻게 관리하지 했는데 무게가 없는 트럭을 넣고 이를 시간으로 따지면
// 최종에 넣는 트럭을 넣어서 그때의 시간을 구할 수 있었다 즉
// 다리라는 큐와 트럭이라는 큐를 통해서 트럭 큐가 다 빌때까지 하다가
// 다리라는 큐에 트럭을 넣거나 0을 넣거나해서 그때만큼의 반복적인 시간을 구한다.