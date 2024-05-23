package BOJ.JaeIk.programmers;

import java.util.*;

class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();

        for(int i=0; i<players.length; i++){
            rank.put(players[i], i);
        }

        for(String call : callings){
            int ranking = rank.get(call);

            String front = players[ranking-1];

            rank.replace(front, ranking);
            players[ranking] = front;

            rank.replace(call, ranking-1);
            players[ranking-1] = call;
        }

        return players;
    }
}
