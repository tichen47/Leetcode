package array;

public class Alphabet_Board_Path_1138 {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int cur_h = 0, cur_v = 0;
        for(int i = 0; i < target.length(); i++){
            int next = target.charAt(i) - 'a';
            int next_h = next / 5;
            int next_v = next % 5;
            
            int move_h = next_h - cur_h;
            int move_v = next_v - cur_v;
            
            // if next char is 'z' and cur char is not 'z', move to 'u' first and one step down
            if(next_h == 5 && cur_h != 5) { 
                move(sb, move_h - 1, move_v);
                sb.append('D');
            }
            else{
                move(sb, move_h, move_v);
            }
            
            sb.append('!');
            
            cur_h = next_h;
            cur_v = next_v;
        }
        return sb.toString();
    }
    
    public void move(StringBuilder sb, int h, int v){
        char h_move = h > 0 ? 'D' : 'U';
        char v_move = v > 0 ? 'R' : 'L';
        for(int i = 0; i < Math.abs(h); i++){
            sb.append(h_move);
        }
        for(int i = 0; i < Math.abs(v); i++){
            sb.append(v_move);
        }
    }
}
