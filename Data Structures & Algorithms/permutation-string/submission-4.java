class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int l = 0;
        int matches = 0;
        int unique = map.size();  // ✅ store before loop!

        for(int r = 0; r < s2.length(); r++){
            map.put(s2.charAt(r), map.getOrDefault(s2.charAt(r), 0) - 1);
            if(map.get(s2.charAt(r)) == 0) matches++;
            else if(map.get(s2.charAt(r)) == -1) matches--;

            if(r - l + 1 > s1.length()){
                map.put(s2.charAt(l), map.getOrDefault(s2.charAt(l), 0) + 1);
                if(map.get(s2.charAt(l)) == 1) matches--;
                else if(map.get(s2.charAt(l)) == 0) matches++;
                l++;
            }

            if(matches == unique) return true;  // ✅ compare with unique!
        }
        return false;
    }
}