class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys, (a,b) -> map.get(b) - map.get(a));
        
        for(int i = 0; i < k; i++){
            result[i] = keys[i];
        }

        return result;
    }
}
