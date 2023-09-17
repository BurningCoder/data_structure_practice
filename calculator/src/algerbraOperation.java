//Boyi Zhang
public class algerbraOperation {
    public static String algebraTransform(String inputArray){
        calQueue<String> stringStore = new calQueue<>();
        stringStore = inToPost(inputArray);
        return evlPost(stringStore);
    }

    public static calQueue<String> inToPost(String inputArray){
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
    public static int optLevel(char input){
        if(input == '^') return 4;
        else if(input == '*' || input == '/'||input == '%') return 3;
        else if(input == '+'|| input == '-') return 2;
        else if(input == '(') return -1;
        return 0;
    }
    public static String evlPost(calQueue<String> inputArray){
        calStack<Double> numStore = new calStack<>();
        boolean flag = false;
        while(!inputArray.isEmpty()){
            String curNode = inputArray.pop();
            if(curNode.equals("-")||curNode.equals("+") ||curNode.equals("*")||curNode.equals("/")||curNode.equals("^")||curNode.equals("%")){
                if(numStore.size() < 2) return "A";
                String tmp = calculateOpt(numStore,curNode);
                if(!tmp.equals("")){return tmp;}
            }
            else{
                Double curNum = Double.parseDouble(curNode);
                numStore.push(curNum);
            }
        }
        return Double.toString(numStore.pop());
    }
    public static String calculateOpt(calStack<Double> numStore,String opt){
        double x1 = numStore.pop();
        double x2 = numStore.pop();
        switch (opt){
            case "+" ->{
                numStore.push(x1 + x2);
                return "";
            }
            case "-"->{
                numStore.push(x2 - x1);
                return "";
            }
            case "*"->{
                numStore.push(x2 * x1);
                return "";
            }
            case "/"->{
                if(x1 == 0){
                    return "B";
                }
                numStore.push(x2 / x1);
                return "";
            }
            case "%"->{
                if( x1 == 0) return "B";
                numStore.push(x2 % x1);
                return "";
            }
            case "^"->{
                numStore.push(Math.pow(x2,x1));
                return "";
            }
        }
        return "";
    }
}
