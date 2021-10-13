public class 월간코드1_삼각달팽이 {
    public int[] solution(int n) {
        int[][] answer = new int[n][n];
        int row = -1, col = 0;
        int num = 1;
        
        for(int i=n; i>0; i-=3) {
            // 세로 방향
            for(int v=0; v<i; v++) answer[++row][col] = num++;
            // 가로 방향
            for(int h=0; h<i-1; h++) answer[row][++col] = num++;
            // 대각선 방향
            for(int d=0; d<i-2; d++) answer[--row][--col] = num++;
        }
        
        int[] realAnswer = new int[--num];
        num = 0;

        // 일차원 배열로 전환
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                realAnswer[num++] = answer[i][j];
            }
        }

        return realAnswer;
    }
}

/**
 * 규칙적인 삼각형을 만든다는걸 깨닫고 
 * 맨처음에는 n=4일 경우 세로로 3칸 가로로 3칸 대각선으로 3칸 이렇게 해줄려했더니
 * 그러면 전위후위 연산자가 섞여서 헷갈린다는걸 깨닫고 방향을 바꿧다
 * 삼각형 자체를 그린다는 생각은 했지만 계속 헤매다가 결국,, 다른 사람 글에서 힌트를 얻었다ㅠ
 * n=4일 경우 방향을 바꿔주며 4칸>3칸>2칸>1칸으로 추가하면 된다는걸 꺠닫고 코딩..
 * 마지막 해답방향이 생각 안나서 연습장에 계속 이찬원배열로 값을 넣어보고 머리 아팠다
 * 여러 시도가 있었지만 완성코드가 제일 깔끔한 형태가 된 것 같아서 만족
 * 근데 완성하고 힌트를 얻은 사람 글에 있는 코드를 보는데 비슷한 형태더라,, 쩝
 * 내가 스스로 떠올렸다면 좋았을텐데.. 좀 더 노력해야지
 */