import java.util.Objects;
//Boyi Zhang
public class logicOperation {
    public static String logicTransform(String inputArray){
        calQueue<String> string = postToInt(inputArray);
        String ans = evlPost(string);
        if(ans.equals("True")) return "1.00";
        else if(ans.equals("False")) return "0.00";
        return ans;
    }
    public static calQueue<String>  postToInt(String inputArray){
        calQueue<String> numStore = new calQueue<>();
        calStack<Character> optStore = new calStack<>();
        for(int i = 0; i < inputArray.length();i ++) {
            char curChar = inputArray.charAt(i);
            if((curChar <= '9' && curChar >='0' )|| curChar == '.'){
                StringBuilder num = new StringBuilder();
                int j = i;
                while(j <inputArray.length()){
                    char tmp = inputArray.charAt(j);
                    if(!((tmp <= '9' && tmp >='0' )|| tmp == '.')){
                        j--;
                        break;
                    }
                    num.append(tmp);
                    j++;
                }
                i = j;
                numStore.push(num.toString());
            }
            else if(curChar == ')'){
                while(!optStore.isEmpty()){
                    char inChar = optStore.pop();
                    if(inChar == '(') break;
                    numStore.push(Character.toString(inChar));
                }
            }
            else{
                //if( i + 1 < inputArray.length() && check(inputArray.charAt(i))) return null;
                int curlevel = optLevel(curChar);
                if(optStore.isEmpty() || curChar == '(') optStore.push(curChar);
                else {
                    while (!optStore.isEmpty() && optLevel(optStore.top()) >= curlevel){
                        numStore.push(Character.toString(optStore.pop()));
                    }
                    optStore.push(curChar);
                }
            }
        }
        while(!optStore.isEmpty()){
            numStore.push(Character.toString(optStore.pop()));
        }
        return numStore;
    }
    public static String evlPost(calQueue<String> inputArray){
        calStack<Double> numStore = new calStack<>();
        calStack<Boolean> boolStore = new calStack<>();
        while(!inputArray.isEmpty()){
            String curString = inputArray.pop();
            if(curString.equals("+")||curString.equals("-")||curString.equals("*")||curString.equals("/")||curString.equals("^")||curString.equals("%")){
                if(numStore.size() < 2) return "A";
                String tmp = algerbraOperation.calculateOpt(numStore,curString);
                if(!tmp.equals("")) return tmp;
            }
            else if(curString.equals("!")||curString.equals("&")||curString.equals("<")||curString.equals("=")||curString.equals(">")||curString.equals("|")){
                String tmp = combineOperation(numStore,boolStore,curString);
                if(tmp.equals("A")) return tmp;
            }
            else{
                double curDouble = Double.parseDouble(curString);
                numStore.push(curDouble);
            }
        }
        if(boolStore.pop()) return "True";
        else return "False";

    }
    public static int optLevel(char input){
        if(input == '^' || input == '!') return 4;
        else if(input == '*' || input == '/'||input == '%') return 3;
        else if(input == '+'|| input == '-') return 2;
        else if(input == '=' || input == '<'||input == '>') return 1;
        else if(input == '|' || input == '&') return 0;
        else if(input == '(') return -1;
        return 0;
    }


    public static String combineOperation(calStack<Double> numStore, calStack<Boolean> boolStore, String opt){
        switch (opt) {
            case "=" -> {
                if(numStore.size() < 2) return "A";
                double x1 = numStore.pop();
                double x2 = numStore.pop();
                boolStore.push(x1 == x2);
                return "";
            }
            case "<" -> {
                if(numStore.size() < 2) return "A";
                double x1 = numStore.pop();
                double x2 = numStore.pop();
                boolStore.push(x1 > x2);
                return "";
            }
            case ">" -> {
                if(numStore.size() < 2) return "A";
                double x1 = numStore.pop();
                double x2 = numStore.pop();
                boolStore.push(x1 < x2);
                return "";
            }
            case "|" -> {
                if(!numStore.isEmpty()){
                    if(numStore.top() == 1){
                        boolStore.push(true);
                        numStore.pop();
                         if(!numStore.isEmpty() && numStore.top() == 1){
                            boolStore.push(true);
                            numStore.pop();
                        }
                        else if(!numStore.isEmpty() && numStore.top() == 0){
                            boolStore.push(false);
                            numStore.pop();
                        }


                    }
                    else if(numStore.top() == 0){
                        boolStore.push(false);
                        numStore.pop();
                        if(!numStore.isEmpty() && numStore.top() == 1){
                            boolStore.push(true);
                            numStore.pop();
                        }
                        else if(!numStore.isEmpty() && numStore.top() == 0){
                            boolStore.push(false);
                            numStore.pop();
                        }
                    }
                }
                if(boolStore.size() < 2)return "A";
                boolean x = boolStore.pop();
                boolean y = boolStore.pop();
                boolStore.push(orOpt(x, y));
                return "";
            }
            case "&" -> {
                if(!numStore.isEmpty()){
                    if(numStore.top() == 1){
                        boolStore.push(true);
                        numStore.pop();
                         if(!numStore.isEmpty()&&numStore.top() == 1){
                            boolStore.push(true);
                            numStore.pop();
                        }
                        else if(!numStore.isEmpty()&&numStore.top() == 0){
                            boolStore.push(false);
                            numStore.pop();
                        }


                    }
                    else if(numStore.top() == 0){
                        boolStore.push(false);
                        numStore.pop();
                        if(!numStore.isEmpty()&&numStore.top() == 1){
                            boolStore.push(true);
                            numStore.pop();
                        }
                        else if(!numStore.isEmpty()&&numStore.top() == 0){
                            boolStore.push(false);
                            numStore.pop();
                        }
                    }
                }
                if(boolStore.size() < 2)return "A";
                boolean x = boolStore.pop();
                boolean y = boolStore.pop();
                boolStore.push(andOpt(x, y));
                return "";
            }
            case "!" -> {
                if(boolStore.isEmpty()){
                    if(numStore.top() == 1){
                        numStore.pop();
                        boolStore.push(false);
                    }
                    else if(numStore.top() == 0){
                        numStore.pop();
                        boolStore.push(true);
                    }
                    else return "A";
                    return "";
                }
                boolean x = boolStore.pop();
                boolStore.push(negate(x));
                return "";
            }
        }
        return "";
    }

    public static boolean andOpt(boolean x, boolean y){
        return x && y;
    }
    public static boolean orOpt(boolean x, boolean y){
        return x || y;
    }
    public static boolean negate(boolean x) {return !x;}
}


