class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        for(char ch:path.toCharArray()){
            if(sb.isEmpty()){
                sb.append('/');
                continue;
            }
            else if(ch=='/'){
                if(sb.charAt(sb.length()-1)=='/'){
                    continue;
                }
            }
            sb.append(ch);
        }
        System.out.println(sb.toString());
        String newString = sb.toString();
        String[] strArr = newString.split("/");
        List<String> list = new ArrayList<>();
        for(String str:strArr){
            if(str.equals(".")){
                continue;
            }
            else if(str.equals("..")){
                if(list.size()==0){
                    continue;
                }
                list.remove(list.size()-1);
            }
            else{
                list.add(str);
            }
        }
        if(list.size()==0){
            return "/";
        }
        sb.setLength(0);
        for(int i=0; i<list.size(); i++){
            sb.append("/").append(list.get(i));
        }
        sb.deleteCharAt(0);
        if(sb.isEmpty() || sb.charAt(0) != '/'){
            sb.insert(0, '/');
        }
        return sb.toString();
    }
}