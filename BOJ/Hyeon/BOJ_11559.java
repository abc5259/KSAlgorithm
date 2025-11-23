package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class BOJ_11559 {
    static final int row = 12, col = 6;
    static char[][] puyo;
    static boolean[][] visited;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        puyo = new char[row][col];

        for (int i = 0; i < row; i++) {
            char[] line = br.readLine().toCharArray();
            System.arraycopy(line, 0, puyo[i], 0, col);
        }
        int cnt = 0;

        while (true) {
            visited = new boolean[row][col];
            ArrayList<int[]> node = new ArrayList<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (puyo[i][j] != '.' && !visited[i][j]) {
                        list = new ArrayList<>();
                        dfs(i, j);
                        if (list.size() > 3) {
                            node.addAll(list);
                        }
                    }
                }
            }
            if (node.isEmpty()) {
                System.out.println(cnt);
                return;
            } else {
                cnt++;
                for (int[] pair : node) {
                    puyo[pair[0]][pair[1]] = '.';
                }

                for (int j = 0; j < col; j++) {
                    ArrayDeque<Character> puyoCol = new ArrayDeque<>();

                    for (int i = 0; i < row; i++) {
                        if (puyo[i][j] != '.') {
                            puyoCol.push(puyo[i][j]);
                            puyo[i][j] = '.';
                        }
                    }
                    int idx = row - 1;
                    while (!puyoCol.isEmpty()) {
                        puyo[idx--][j] = puyoCol.pop();
                    }
                }
            }
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x) {
        visited[y][x] = true;
        list.add(new int[]{y, x});

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= row || nx >= col || visited[ny][nx]) {
                continue;
            }
            if (puyo[ny][nx] == puyo[y][x]) {
                dfs(ny, nx);
            }
        }
    }
}
// G4 뿌요뿌요 DFS
// 40분
// 일단 접근 방식 자체가 뭐냐면 전체 뿌요 배열을 스캔해서 4개이상의 연속을 가질 때 이를 뿌요로 생각해서 없애고 그자리위에 있는 행들이 내려온다
// 그래서 전체 탐색을 해야되기에 BFS 나 DFS 둘다 될 거라고 생각했다.
// 그래서 방문 여부 visited 를 일단 매 반복마다 해야되고
// 뿌요가 없을때까지 돌아야 하기에 while ture 조건으로 계쏙 순회한다
// 방문 여부 및 빈 공간이 아닐경우 DFS 를 시작해서
// 끝까지 탐색하고 이때 본인과 같은 색이 연달아서 나와서 이를 list 에 저장해서 사이즈가
// 4개 이상이면 뿌요로 처리하고 아니면 그냥 넘어간다
// 그래서 이를 node 라는 while 문에서 돌고 있는 리스트에 모든 list 값을 넣어서 while 단위로
// 뿌요의 실행을 한다. 뿌요된 칸은 모두 빈공간 처리되며 위의 뿌요들이 내려와서 채워야 하기에
// 빈공간 부터만들고 그다음에 뿌요가 내려오게 해서 열단위로 차곡 채운다
// 그다음 cnt 를 늘려서 연쇄 횟수를 잰다음에 node 의 개수가 0일때 탈출한다.
// trouble shooting
// 일단 탐색 조건을 나랑 똑같은 뿌요여야 된다 이게 1번 오류고
// 연쇄는 while의 횟수이다
// 리스트의 갯수를 dfs 를 탈출해서 main에서 재야된다 재귀중에 탈출 될 수 있다.

