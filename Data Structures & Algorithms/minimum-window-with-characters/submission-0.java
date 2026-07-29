class Solution {
    public String minWindow(String s, String t) {
                if(s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int matches = 0;
        int unique = map.size();
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        for(int r = 0; r < s.length(); r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);
            if(map.get(s.charAt(r)) == 0) matches++;  // ✅ only when exactly 0!

            while(matches == unique){
                if(r - l + 1 < minLength){
                    minLength = r - l + 1;
                    start = l;
                }
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
                if(map.get(s.charAt(l)) == 1) matches--;  // ✅ only when goes to 1!
                l++;
            }
        }

        if(minLength == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLength);
    }
}
