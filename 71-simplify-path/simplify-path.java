class Solution {
    public String simplifyPath(String path) {
        String[] strArr = path.split("/");
        Deque<String> dir = new ArrayDeque<>();
        for(String str:strArr){
            if(str.isEmpty() || str.equals(".")){
                continue;
            }
            else if(str.equals("..")){
                if(!dir.isEmpty()){
                    dir.removeLast();
                }
            }
            else{
                dir.addLast(str);
            }
        }
        String newStr = String.join("/", dir);
        return "/"+newStr;
    }
}