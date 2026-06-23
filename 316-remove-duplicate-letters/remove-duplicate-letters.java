class Solution {
    public String removeDuplicateLetters(String s) {
        int[] pos = new int[26];
        for(int i=0; i<s.length(); i++){
            pos[s.charAt(i)-'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        HashSet<Character> hset = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            while(!stack.isEmpty() && stack.peekLast()-'a'>curr-'a' && pos[stack.peekLast()-'a']>i && !hset.contains(curr)){
                hset.remove(stack.peekLast());
                stack.removeLast();
            }
            if(!hset.contains(curr)){
                stack.addLast(curr);
                hset.add(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        sb.reverse();
        return sb.toString();
    }
}