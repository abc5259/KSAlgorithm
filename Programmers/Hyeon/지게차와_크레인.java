package Programmers.Hyeon;

import java.util.ArrayDeque;

public class 지게차와_크레인 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.solution(new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"}, new String[]{"A", "BB", "A"});
        System.out.println(res); // 출력: 11
    }

    static int rows, cols;
    static char[][] c;

    static class Solution {
        public int solution(String[] storage, String[] requests) {
            rows = storage.length;
            cols = storage[0].length();
            c = new char[rows][cols];

            // 2D 배열로 변환
            for (int i = 0; i < rows; i++) {
                c[i] = storage[i].toCharArray();
            }

            // 각 요청 처리
            for (String request : requests) {
                char tgt = request.charAt(0);
                if (request.length() > 1) {
                    performCrane(tgt);
                } else {
                    forklift(tgt);
                }
            }
            return countItems();
        }
    }

    // 방향 벡터 (상, 하, 좌, 우)
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    // 남아 있는 아이템 개수 계산
    static int countItems() {
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (c[i][j] != ' ') { // 빈 공간이 아닌 경우 카운트
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 크레인: 특정 타입의 모든 컨테이너 제거
    static void performCrane(char tgt) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (c[i][j] == tgt) {
                    c[i][j] = ' '; // 해당 타입 제거
                }
            }
        }
    }

    // 지게차: 가장자리에서 접근 가능한 컨테이너만 제거
    static void forklift(char tgt) {
        boolean[][] visited = new boolean[rows][cols];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 가장자리에서 접근 가능한 컨테이너 또는 빈 공간을 찾아 큐에 추가
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && (c[i][j] == tgt || c[i][j] == ' ')) {
                    queue.offer(new int[]{i, j, c[i][j]});
                    visited[i][j] = true;
                    c[i][j] = ' '; // 제거
                }
            }
        }

        // BFS 실행
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1];

            // 현재 위치가 타겟 컨테이너가 아니라 빈 공간이면 인접한 칸 탐색
            if (cur[2] != tgt) {
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < rows && nx < cols && !visited[ny][nx] && (c[ny][nx] == tgt || c[ny][nx] == ' ')) {
                        queue.offer(new int[]{ny, nx, c[ny][nx]});
                        visited[ny][nx] = true;
                        c[ny][nx] = ' '; // 제거
                    }
                }
            }
        }
    }
}