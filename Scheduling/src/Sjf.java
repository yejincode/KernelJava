import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Sjf implements Strategy{
    @Override
    public void solution(ArrayList<String> lines) {

        String[][] splitData = new String[lines.size()][3];
        int i = 0;

        for (String line : lines){
            splitData[i] = line.split(" ");
            i++;
        }

        // 요청시간 순으로 오름차순 정렬하기 -> 요청 시간이 순서대로 들어오지 않을 수 있기 때문. (인덱스1에 요청시간 있음)
        Arrays.sort(splitData, Comparator.comparingInt(o -> Integer.parseInt(o[1])));

        // 수리시간 순으로 오름차순 정렬하기.
        PriorityQueue<String[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> Integer.parseInt(o[2])));
        pq.addAll(Arrays.asList(splitData));

        int serviceStart = 0;
        int wait = 0;

        while (!pq.isEmpty()) {
            String[] temp = pq.poll();
            // 서비스 시작 시간 계산
            int currentServiceStart = Math.max(serviceStart, Integer.parseInt(temp[1]));
            int waitingTime = currentServiceStart - Integer.parseInt(temp[1]);

            // 이름, 서비스 시작 시간, 기다린 시간 출력
            System.out.println(temp[0] + ", 서비스 시작 시간: " + currentServiceStart + ", 기다린 시간: " + waitingTime);

            serviceStart = currentServiceStart + Integer.parseInt(temp[2]);
            wait += waitingTime;
        }
        // 총 기다린 시간, 총 걸린 시간 출력
        System.out.println("총 기다린 시간: " + wait);
        System.out.println("총 걸린 시간: " + serviceStart);
    }
}
