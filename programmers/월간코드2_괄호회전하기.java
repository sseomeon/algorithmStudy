import java.util.Stack;
import java.util.HashMap;

class 월간코드2_괄호회전하기 {
    // 괄호 짝을 확인해줄 해시맵
    static HashMap<Character, Character> bracketMatch = new HashMap<Character, Character>() {
        {
            put('(',')');
            put('[',']');
            put('{','}');
        }
    };
    
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            // 정상적인 괄호일 경우 answer에 +1. chkBracket 함수로 체크.
            answer += (chkBracket(s.toString().toCharArray()) ? 1 : 0);
            // 왼쪽으로 문자 한 칸씩 밀어주기.
            String tmpStr = s.substring(0,1);
            s = s.substring(1) + tmpStr;
        }
        return answer;
    }
    
    public boolean chkBracket(char[] s){
        // 열림괄호('(', '{', '[')를 넣어줄 스택
        Stack<Character> openStack = new Stack<Character>();
        
        for(char ch : s){
            if(openStack.isEmpty() && (ch == ')' || ch == ']' || ch == '}')){
                // 열림괄호가 없는 상태에서 닫힘괄호가 나올경우 false.
                return false;
            }else {
                if(ch == '(' || ch == '[' || ch == '{'){
                    // 열림괄호면 푸시.
                    openStack.push(ch);
                }else {
                    // 닫힘괄호면 해시맵을 통해 짝 확인 후 같지 않을 경우 false.
                    if(ch != bracketMatch.get(openStack.pop())) return false;
                }
            }
        }
        
        // 문자가 끝났는데 열림괄호가 있을 경우 false.
        if(!openStack.isEmpty()) return false;
        
        return true;
    }
}

/*
 * 맨 처음엔 아래와 같이 배열을 이용해서 풀려고 했다.
 * int[] chkArr = {0, 0, 0}; int lastIdx = 0;
 * switch (ch) {
 *      case '(' : lastIdx++; chkArr[0] = lastIdx; break;
 *      case ')' : if(chkArr[0] == 0 || chkArr[0] != lastIdx) return false; 
 *                 else chkArr[0] = 0; lastIdx--; break;
 * 
 * 그랬더니 괄호가 닫히기 전에 연속으로 나오는 경우(ex. "[{[[[]]])}]")는 배열이 1개이므로 해결할 수 없었다.
 * 도저히 생각이 안나서 사람들 질문을 구경하다가 스택을 쓴다는 힌트를 보고 풀 수 있었다.
 * 처음엔 스택?? 하면서 알고리즘 책의 스택 파트를 봤는데 거기 예시에 이 문제가 그대로 있어서 황급히 닫았다.
 * 스스로 풀어야 되는데 풀이까지 다 있었기 때문에,, 화들짝
*/
