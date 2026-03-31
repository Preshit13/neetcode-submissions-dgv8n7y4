class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> keys = new ArrayList<>();
        int[] result = new int[k];

        for(int i =0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        for(int key : map.keySet()){
            keys.add(key);
        }

        for(int i = 1; i < keys.size(); i++){
            int j = i - 1;
            while(j >=0 && map.get(keys.get(j)) < map.get(keys.get(j+1))){
            int temp = keys.get(j+1);
            keys.set(j+1, keys.get(j));
            keys.set(j, temp);
            j--;
            }
        }

        // Instead of insertion sort this can be used: 
        //Collections.sort(keys, (a, b) -> map.get(b) - map.get(a));

        for(int i = 0; i < k; i++){
            result[i]=keys.get(i);
        }

        return result;
    }
}
