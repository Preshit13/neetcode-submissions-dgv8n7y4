class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        result[temperatures.length - 1] = 0;
        for(int i = 0; i < temperatures.length - 1; i++){
            int days = 0;
            for(int j = i + 1; j < temperatures.length; j++){
                if(temperatures[i] < temperatures[j]){
                    days = j - i;
                    break;
                }
            }
            result[i] = days;
        }
        return result;  
    }
}
