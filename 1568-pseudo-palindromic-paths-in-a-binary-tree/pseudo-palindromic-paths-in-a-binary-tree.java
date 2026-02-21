/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root, new ArrayList<>(), new HashMap<>(), 0);
        return count;
    }
    public void helper(TreeNode root, List<Integer> list, HashMap<Integer, Integer> hmap, int countOdd){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(hmap.isEmpty() || !hmap.containsKey(root.val)){
            countOdd++;
        }
        else if(hmap.get(root.val)%2==0){
            countOdd++;
        }
        else if(hmap.get(root.val)%2!=0){
            countOdd--;
        }
        hmap.put(root.val, hmap.getOrDefault(root.val, 0)+1);
        if(root.left!=null){
            helper(root.left, list, hmap, countOdd);
        }
        if(root.right!=null){
            helper(root.right, list, hmap, countOdd);
        }
        if(root.left==null && root.right==null){
            if(countOdd<=1){
                count++;
            }
        }
        int lastEle = list.get(list.size()-1);
        hmap.put(lastEle, hmap.get(lastEle)-1);
        if(hmap.get(lastEle)%2 !=0){
            countOdd--;
        }
        list.remove(list.size()-1);
    }
    public boolean check(List<Integer> list){
        int[] arr = new int[10];
        int size=list.size();
        for(int i=0; i<list.size(); i++){
            arr[list.get(i)]++;
        }
        int odd_count=0, even_count=0;
        for(int i=1; i<10; i++){
            if(arr[i]==0){
                continue;
            }
            if(arr[i]%2==0){
                even_count++;
            }
            else{
                odd_count++;
            }
        }
        if(odd_count>1){
            return false;
        }
        if(odd_count==0){
            return true;
        }
        if(odd_count==1 && (size%2 != 0)){
            return true;
        }
        return false;
    }
}