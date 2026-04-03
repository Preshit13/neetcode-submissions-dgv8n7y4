class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(int i =0; i < strs.size(); i++){
            result = result + strs.get(i).length() + "#" + strs.get(i);
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j+1, j+1+length);

            i = j + 1 + length;
            result.add(word);
        }

        return result;
    }
}
