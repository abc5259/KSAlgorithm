package Programmers.Hyeon.lv5;

import java.util.HashSet;
import java.util.Set;

public class 방의_개수 {

    class Solution {
        public int solution(int[] arrows) {
            int answer = 0;

            int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
            int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

            Set<String> visitNodes = new HashSet<>();
            Set<String> visitEdges = new HashSet<>();

            int cy = 0, cx = 0;

            visitNodes.add(cy + " " + cx);

            for (int next : arrows) {
                for (int i = 0; i < 2; i++) {
                    int ny = cy + dy[next];
                    int nx = cx + dx[next];

                    String nNode = ny + " " + nx;
                    String edge1 = cy + "->" + ny + " " + cx + "->" + nx;
                    String edge2 = ny + "->" + cy + " " + nx + "->" + cx;


                    if (visitNodes.contains(nNode)) {
                        if (!visitEdges.contains(edge1)) {
                            answer++;
                        }
                    } else {
                        visitNodes.add(nNode);
                    }

                    visitEdges.add(edge1);
                    visitEdges.add(edge2);

                    cy = ny;
                    cx = nx;
                }
            }
            return answer;
        }
    }
}

// lv5 방의 개수 그래프
// 50분
// 8 방향 벡터를 통해서 시작하고 좌표평면 기준으로 시작한다
// 사이클이 곧 방인데 사이클이라는 말은 해당 노드를 중복 반복하는것이고 그 반복을 했을 때 간선이 다르다면 사이클이 맞고 간선이 같다면
// 이미 지나간 곳이기에 간선에 대해서 중복 검증과 노드에 대해서 중복 검증이 필요했다
// 그래서 노드 방문 여부를 Key value 로 하려했으나 그냥 2번만 반복해도 문제라는거 생각하고 다른 노드로 인해
// 중복 사이클 생기는거 말고는 없으니까 Set 으로 노드와 간선 을 잡고
// 또 양방향을 기준으로 한게 반대방향으로 하면 간선이 달라서 사이클로 생각할까봐 양방향을 넣고
// cy ny , cx nx 로 갱신하면서 배열 반복한다
// 즉 노드는 방문했는데 간선이 다를경우만 사이클이다.
// 근데 노드랑 간선은 cy cx 에 대해서 String 으로 키를 가졌다.
