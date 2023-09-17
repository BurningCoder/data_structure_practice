public class URCalculator {
    public static void main(String[] args) throws Exception {
        In a = new In(args[0]);
        String x = a.readAll();
        String[] inputArray = x.split("\\r?\\n");
        String[] ans = new String[inputArray.length];
        for(int i = 0; i < inputArray.length; i++){
            String tmp = inputArray[i];
            tmp = preOperation.mainOpt(tmp);
            System.out.println(tmp);
            ans[i] = tmp;
        }
        fileGen.addFile(ans,args[1]);
        new calculatorLayout().init();
    }
}
