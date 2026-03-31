class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> result = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(result.containsKey(c)){
                result.put(c, result.get(c)+1);
            }else{
                result.put(c, 1);
            }
        }

        for(int j = 0; j < t.length(); j++){
            char c = t.charAt(j);
            if(result.containsKey(c)){
                result.put(c, result.get(c)-1);
                if(result.get(c) < 0){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
