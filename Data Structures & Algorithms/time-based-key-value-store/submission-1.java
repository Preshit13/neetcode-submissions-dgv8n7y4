class TimeMap {
    HashMap<String, List<String>> values;      // ✅ class variable
    HashMap<String, List<Integer>> timestamps; // ✅ class variable

    public TimeMap() {
        values = new HashMap<>();      // ✅ initialize here
        timestamps = new HashMap<>();  // ✅ initialize here
    }
    
    public void set(String key, String value, int timestamp) {
      if(!values.containsKey(key)){
        values.put(key, new ArrayList<>());
        timestamps.put(key, new ArrayList<>());
      }
        values.get(key).add(value);
        timestamps.get(key).add(timestamp);  
    }
    
    public String get(String key, int timestamp) {
        if(!timestamps.containsKey(key)) return "";
        
        List<Integer> timeList = timestamps.get(key);
        int start = 0;
        int end = timeList.size() - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(timeList.get(mid) == timestamp){
                return values.get(key).get(mid);
            }else if(timeList.get(mid) > timestamp){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
       if(end < 0) return "";                  // ← stops here if no floor
       return values.get(key).get(end);        // ← stops here with floor value
    }
}
