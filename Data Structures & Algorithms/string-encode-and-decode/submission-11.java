class Solution {

    public String encode(List<String> strs) {
        String seperator = "😊";
        if(strs.isEmpty()){
            return "";
        }
        StringBuilder strBuilder = new StringBuilder();
        for(String str : strs){
            if(str!=""){
                strBuilder.append(str);
                strBuilder.append(seperator);
            }else{
                strBuilder.append("❤️");
                strBuilder.append(seperator);
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
