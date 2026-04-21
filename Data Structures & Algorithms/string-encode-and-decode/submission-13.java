class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "";
        }
        StringBuilder strBuilder = new StringBuilder();
        for(String str : strs){
            if(str!=""){
                strBuilder.append(str);
                strBuilder.append("😊");
            }else{
                strBuilder.append("❤️");
                strBuilder.append("😊");
            }     
        }
        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        String [] str1 = str.split("😊");
        if(str1.length==1 && str1[0]==""){
            return Collections.emptyList();
        }
        return Arrays.stream(str1)
                            .flatMap(s -> Arrays.stream(s.split("😊")))
                            .map(s -> s.contains("❤️")? "" : s)            
                            .toList();
    }
}
