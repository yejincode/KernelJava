import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Fifo implements Strategy{
    @Override
    public void solution(ArrayList<String> lines) {
        String[][] splitData = new String[lines.size()][3];
        int i = 0;

        for (String line : lines) {
            splitData[i] = line.split(" ");
            i++;
        }
        // 도착시간 순으로 오름차순 정렬하기
        Arrays.sort(splitData, (o1, o2) -> Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]));

        int serviceStart = 0;
        int wait = 0;

        for (String[] temp : splitData) {
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
