class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    count += 1;
                }
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int result = 0;
        while(!queue.isEmpty() && count != 0) {
            int size = queue.size();
            result += 1;
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for(int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        queue.add(new int[] {x,y});
                        grid[x][y] = 2;
                        count -= 1;
                    }
                }
            }
        }
        
        return count > 0 ? -1 : result;
    }
}
