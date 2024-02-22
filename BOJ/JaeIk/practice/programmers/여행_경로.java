package BOJ.JaeIk.practice.programmers;

import java.util.*;

class 여행_경로 {
    static boolean[] visited;
    static ArrayList<String> travelRoute = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        int depth = 0;

        dfs("ICN", "ICN", tickets, depth);

        Collections.sort(travelRoute);

        answer = travelRoute.get(0).split(" ");

        return answer;
    }

    static void dfs(String start, String route, String[][] tickets, int depth){
        if(depth == tickets.length){
            travelRoute.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0])){
                if(visited[i])continue;

                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, depth+1);
                visited[i] = false;
            }
        }
    }
}
