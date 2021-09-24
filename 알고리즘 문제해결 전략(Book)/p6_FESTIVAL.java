import java.util.Scanner;

public class p6_FESTIVAL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테스트케이스 수 입력
        System.out.print(">> 테스트케이스 : ");
        int nC = sc.nextInt();

        for(int i=0; i<nC; i++){
            // 값 입력
            System.out.print("(" + (i+1) + ") 대여할 수 있는 날 : ");
            int nN = sc.nextInt();
            System.out.print("(" + (i+1) + ") 섭외된 공연팀의 수 : ");
            int nL = sc.nextInt();
            int[] arrCost = new int[nN];
            System.out.print("(" + (i+1) + ") 공연장 비용 : ");
            for(int j=0; j<nN; j++){
                arrCost[j] = sc.nextInt();
            }

            // 최소 대여비용을 담을 min변수
            double dMin = Double.MAX_VALUE;
            // 섭외된 공연팀(nL)부터 최대 대여가능날(nN)까지 반복
            for(int k=nL; k<=nN; k++){
                // 대여일(k)을 기준으로 평균비용 계산 반복
                for(int m=0; m<=nN-k; m++){
                    double dSum = 0.0;
                    for(int n=m; n<(m+k); n++) dSum += arrCost[n];
                    // 최솟값 선별
                    if(dSum/k < dMin) dMin = dSum/k;
                }
            }
            // 최종 최솟값을 result배열에 추가
            System.out.print(">> answer : ");
            System.out.println(String.format("%.8f",dMin));
        }

        sc.close();
    }
}


/**
 * 책에 나오는 첫 연습문제이지만 너무나 오랜 시간이 걸렸던 문제 ...
 * 왜냐면.. 일단 알고리즘을 짜는데까지는 문제 없었는데
 * for문 반복할때 <=을 <로 써서 틀리고 또, dSum을 초기화해주는 부분이 틀려서 계속 오답처리됐다,,
 * 기본예시로는 계속 통과가 돼서 아무 생각 없이 넘어갔다ㅠㅠ
 * 얼마나 생각없이 코드를 집어 넣는지에 대한 방증,,
 * 
 * 그다음엔 정답용 배열에 저장해서 맨 마지막에 출력해줄려했더니
 * 알고스팟이 원하는 정답 출력 위치랑 달라서 계속 오답이 나서 머리 빠지는줄 알았다.
 * 프로그래머스 너,, 제법 좋은 플랫폼이었구나?
 */