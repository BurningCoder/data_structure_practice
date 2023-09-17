
public class preOperation {
    // check is the math operation is correct in parentheses
    public static String mainOpt(String inputString){
        inputString = inputString.replaceAll(" ","");
        if(!parenthesesCheck(inputString)) return "there is an parentheses error in the input";
        String ans;
        boolean flag = preOperation.logicalCheck(inputString);
        if(flag) ans = logicOperation.logicTransform(inputString);
        else ans  = algerbraOperation.algebraTransform(inputString);
        if(ans.equals("A")) return "there are redundant operators, or operator position is wrong";
        if(ans.equals("B")) return "Zero can not be the denominator in calculation";
        else return ans;
        //
    }
    public static boolean parenthesesCheck(String inputString) {
        calStack<String> stringStore = new calStack<String>();
        for (int i = 0; i < inputString.length(); i++) {
            String tmp = Character.toString(inputString.charAt(i));
            if (tmp.equals("(")) {
                stringStore.push(tmp);
            } else if (tmp.equals(")")) {
                if (stringStore.isEmpty()) return false;
                else stringStore.pop();
            }
        }
        return stringStore.isEmpty();
    }

    public static boolean logicalCheck(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            String tmp = Character.toString(inputString.charAt(i));
            if (tmp.equals("!") || tmp.equals("=") || tmp.equals("&") || tmp.equals("|")||tmp.equals("<")||tmp.equals(">")) return true;
        }
        return false;
    }

}
