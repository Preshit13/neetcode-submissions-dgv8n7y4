class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        for(int j = 0; j < 9; j++){
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < 9; i++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        HashSet<Character>[] boxes = new HashSet[9];
        for(int i =0; i < 9; i++){
            boxes[i] = new HashSet<>();
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int box = (i/3) * 3 + (j/3);
                if(boxes[box].contains(board[i][j])) return false;
                boxes[box].add(board[i][j]);
            }
        }
        return true;
    }
}
