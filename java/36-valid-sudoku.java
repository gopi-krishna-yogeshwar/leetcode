class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<Set<Character>>();
        List<Set<Character>> columns = new ArrayList<Set<Character>>();
        List<Set<Character>> boxes = new ArrayList<Set<Character>>();

        for(int i = 0; i < board[0].length; i++) {
            columns.add(new HashSet<Character>());
            rows.add(new HashSet<Character>());
            boxes.add(new HashSet<Character>());
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char val = board[i][j];
                if(val == '.') {
                    continue;
                }
                if(rows.get(i).contains(val)) {
                    return false;
                }
                rows.get(i).add(val);
                if(columns.get(j).contains(val)) {
                    return false;
                }
                columns.get(j).add(val);
                int index = (i/3) * 3 + (j/3);
                if(boxes.get(index).contains(val)) {
                    return false;
                }
                boxes.get(index).add(val);
            }
        }
    return true;
    }
}
