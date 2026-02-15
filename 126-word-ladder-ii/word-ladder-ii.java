import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Use a Set for O(1) lookups
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        
        if (!dict.contains(endWord)) {
            return res;
        }
        
        // Map to store Child -> List of Parents (Reverse Graph)
        Map<String, List<String>> nodeNeighbors = new HashMap<>();
        
        // Use Sets for the current level to handle duplicates automatically
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);
        
        boolean found = false;
        
        // BFS
        while (!currentLevel.isEmpty() && !found) {
            // Remove words in the current level from dict to prevent revisiting
            // in future levels (ensures shortest path)
            dict.removeAll(currentLevel);
            
            Set<String> nextLevel = new HashSet<>();
            
            for (String s : currentLevel) {
                char[] chars = s.toCharArray();
                
                // Try changing each character
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) continue;
                        chars[i] = ch;
                        String neighbor = new String(chars);
                        
                        if (dict.contains(neighbor)) {
                            if (neighbor.equals(endWord)) {
                                found = true;
                            }
                            // Add to next level
                            nextLevel.add(neighbor);
                            
                            // Build Reverse Graph: neighbor (child) -> s (parent)
                            nodeNeighbors.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(s);
                        }
                    }
                    chars[i] = old; // Restore char
                }
            }
            currentLevel = nextLevel;
        }
        
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            // Start DFS from endWord backwards to beginWord
            dfs(endWord, beginWord, nodeNeighbors, path, res);
        }
        
        return res;
    }
    
    // DFS: Backtracking from End -> Start
    private void dfs(String curr, String end, Map<String, List<String>> nodeNeighbors, List<String> path, List<List<String>> res) {
        if (curr.equals(end)) {
            // We reached the start, reverse the path to get Start -> End
            List<String> resultPath = new ArrayList<>(path);
            Collections.reverse(resultPath);
            res.add(resultPath);
            return;
        }
        
        // If no parents, stop
        if (!nodeNeighbors.containsKey(curr)) {
            return;
        }
        
        for (String parent : nodeNeighbors.get(curr)) {
            path.add(parent);
            dfs(parent, end, nodeNeighbors, path, res);
            path.remove(path.size() - 1);
        }
    }
}