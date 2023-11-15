class Solution {
    public int leastInterval(char[] tasks, int n) {
       Map<Character, Integer>  countMap = new HashMap<Character, Integer>();

       for(char c : tasks) {
           countMap.put(c, countMap.getOrDefault(c, 0) + 1);
       }

       PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
       Queue<Pair<Integer, Integer>> q = new LinkedList<Pair<Integer, Integer>>();
       
       for(Character c : countMap.keySet()) {
           pq.add(countMap.get(c));
       }
       int time = 0;

       while(!pq.isEmpty() || !q.isEmpty()) {
           time += 1;
           if(!pq.isEmpty()) {
               int value = pq.poll();
               value -= 1;
               if(value > 0) {
                   q.add(new Pair(value, time+n));
               } 
           }

           if(!q.isEmpty() && q.peek().getValue() == time) {
               pq.add(q.poll().getKey());
           }

       }
       return time;
    }
}
