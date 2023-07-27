class TimeMap {
    Map<String, TreeMap<Integer, String>> keyValue;
    public TimeMap() {
        this.keyValue = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(this.keyValue.containsKey(key)) {
            this.keyValue.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> map = new TreeMap<Integer, String>();
            map.put(timestamp, value);
            this.keyValue.put(key, map);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!this.keyValue.containsKey(key)) {
            return "";
        }
        Integer floorKey = this.keyValue.get(key).floorKey(timestamp);
        if(floorKey == null) {
            return "";
        }

        return this.keyValue.get(key).get(floorKey);
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
