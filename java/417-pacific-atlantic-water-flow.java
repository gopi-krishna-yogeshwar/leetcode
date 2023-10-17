class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<String> queue = new LinkedList<String>();

        for(int i = 0; i < heights[0].length; i++) {
            queue.add("0" + "_" + String.valueOf(i));
        }
        for(int i = 0; i < heights.length; i++) {
            queue.add(String.valueOf(i) + "_" + "0");
        }
        Set<String> pacific = bfs(heights, queue);
        for(int i = 0; i < heights[0].length; i++) {
            queue.add(String.valueOf(heights.length-1) + "_" + String.valueOf(i));
        }

        for(int i = 0; i < heights.length; i++) {
            queue.add(String.valueOf(i) + "_" + String.valueOf(heights[0].length-1));
        }

        Set<String> atlantic = bfs(heights, queue);
        pacific.retainAll(atlantic);
        //System.out.println(pacific.size());
        for(String s : pacific) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(Integer.valueOf(s.split("_")[0]));
            list.add(Integer.valueOf(s.split("_")[1]));
            result.add(new ArrayList<Integer>(list));
        }
            

        return result;
    }

    public Set<String> bfs(int[][] heights, Queue<String> queue) {

        Set<String> visited = new HashSet<String>();
        //System.out.println("current pos is:" + pos);
        while(!queue.isEmpty()) {
            String curr = queue.poll();
            visited.add(curr);
            List<String> neighbours = getNeighbours(heights, curr);
            for(String neighbour : neighbours) {
                if(!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
                
            }
        }

        return visited;
    }

    public List<String> getNeighbours(int[][] grid, String pos) {
        int x = Integer.valueOf(pos.split("_")[0]);
        int y = Integer.valueOf(pos.split("_")[1]);

        List<String> result = new ArrayList<String>();
        if(x-1 >= 0 && grid[x-1][y] >= grid[x][y]) result.add(String.valueOf(x-1) + "_" + String.valueOf(y));

        if(x+1 < grid.length && grid[x+1][y] >= grid[x][y]) result.add(String.valueOf(x+1) + "_" + String.valueOf(y));

        if(y+1 < grid[0].length && grid[x][y+1] >= grid[x][y]) result.add(String.valueOf(x) + "_" + String.valueOf(y+1));

        if(y-1 >= 0 && grid[x][y-1] >= grid[x][y]) result.add(String.valueOf(x) + "_" + String.valueOf(y-1));

        return result;
    }
}
