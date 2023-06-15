class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);  
            String key = new String(array);
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(strs[i]);
        }
        
        return new ArrayList(map.values());
    }
}
