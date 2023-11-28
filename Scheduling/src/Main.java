import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int menu = -1;

        while (true){
            try{
                System.out.println("----------------------------");
                System.out.println("안녕하세요. 아갤폰 고객 센터 입니다.");
                System.out.println("수리 순서를 정해드리겠습니다. 원하는 메뉴를 입력해주세요. ex) 1");
                System.out.println("1. FIFO (선착순) 2. SJF (수리 시간 적게 걸리는 순) 3. 나가기");
                System.out.print("메뉴 선택 : ");
                menu = sc.nextInt(); //엔터 -> 버퍼 비워주기
                sc.nextLine();
            }catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
                System.out.println("1,2,3의 숫자를 입력해주세요.");
                continue;
            }
            if (menu < 0 || menu > 3 ){
                System.out.println("잘못된 입력입니다.");
                System.out.println("1,2,3의 숫자를 입력해주세요.");
                continue;
            }
            else if (menu ==1 || menu ==2 ){
                System.out.println("계산할 데이터를 입력해주세요.(이름 도착시간 수리소요시간)");
                System.out.println("ex) 이영주 0 1\n" + "이종찬 2 12\n" + "장호윤 5 5\n" + "문찬욱 6 6\n" +
                        "김찬규 7 3\n" + "손민우 9 1\n" + "송예진 10 3");
                System.out.println("--------------------------------------------");

                ArrayList<String> lines = new ArrayList<>();

                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.isEmpty()) {
                        break;  // 빈 줄이 입력되면 입력 종료
                    }
                    lines.add(line);
                }

                if (menu ==1){
                    Fifo fifo = new Fifo();
                    fifo.solution(lines);
                }
                else {
                    Sjf sjf = new Sjf();
                    sjf.solution(lines);
                }
                break;
            }
            else {
                break;
            }

        }
    }
}
