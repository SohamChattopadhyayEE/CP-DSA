/*
Algorithm:
----------------------------------------------------------------------------------
1. Store frequencies of characters of string `s` into a frequency map. 
2. Iterate through the string `t` and substract the frequency of characters
   from the map by one. 
3. While frequency of a character in the map becomes 0, remove it from the map.
4. During the iteration if a situaltion occurs, where the map does not have 
   the current character of the string `t`, then return false.
5. Return `True` if the size of the frequency map is 0, otherwise return `False`.
----------------------------------------------------------------------------------
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0)+1);
        for(char ch : t.toCharArray()){
            if(!map.containsKey(ch)) return false;
            map.put(ch, map.get(ch)-1);
            if(map.get(ch) == 0) map.remove(ch);
        }
        return map.size() == 0;
    }
}
