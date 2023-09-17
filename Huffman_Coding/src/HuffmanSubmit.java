// Import any package as required


import java.io.FileWriter;
import java.util.*;

public class HuffmanSubmit implements Huffman {
    /*
    hufNode is the basic node for the huffman compression tree.
    cap means the number of appearances of ascii code in the file.
    huffCode represents the code of certain ascii code after compression
    Since hufNode is a tree node, it contains left and right children.
     */
    public static class hufNode{
        private int cap;
        private String ascii, huffCode;
        private hufNode left, right;
        hufNode(){
            cap = 0;
            left = null;
            right = null;
        }
        hufNode(String asc){
            cap = 1;
            ascii = asc;
            left = null;
            right = null;
            huffCode = new String();
        }
        hufNode(String asc, int x){
            cap = x;
            ascii = asc;
            left =null;
            right = null;
            huffCode = new String();
        }

        hufNode(int x, hufNode r, hufNode l){
            cap = x;
            left = l;
            right = r;
        }
        public int getCap(){
            return cap;
        }
        public hufNode getLeft() {
            return left;
        }
        public hufNode getRight(){
            return right;
        }

        public String getAscii() {
            return ascii;
        }


        public void setRight(hufNode right) {
            this.right = right;
        }

        public void setLeft(hufNode left) {
            this.left = left;
        }
        public void addCap() {
            cap++;
        }
        public void setCap(int cap){
            this.cap = cap;
        }

        public void setAscii(String ascii) {
            this.ascii = ascii;
        }
    }
    // a node comparator class to ensure Arrays.sort to operate properly
    public class huffmanComparator implements Comparator<hufNode>{

        @Override
        public int compare(hufNode o1, hufNode o2) {
            return Integer.compare(o1.cap, o2.cap);
        }
    }
    private HashMap<String,hufNode> nodeHolder = new HashMap<>();
    private ArrayList<hufNode> nodeArrayList = new ArrayList<>();

	// Feel free to add more methods and variables as required.

    // main encode method
	public void encode(String inputFile, String outputFile, String freqFile) throws Exception {
        nodeArrayList.clear();
        nodeHolder.clear();
        //clear the nodeArrayList and nodeHolder to ensure no previous exists in the function
        readString(inputFile); // read the inputfile into nodeHolder
        //adding node into the ArrayList inorder to sorting the node based on its appearance
        for(Map.Entry<String,hufNode> e : nodeHolder.entrySet()){
            nodeArrayList.add(e.getValue());
        }
        nodeArrayList.sort(new huffmanComparator());
        //generate frequency file
        addFile(nodeArrayList,freqFile);
        // complete tree building
        hufNode root = build_tree(nodeArrayList);
        String x = "";
        traverse(root,x);
        //output the compression file
        compress(inputFile,outputFile);
    }
    //main decode method
   public void decode(String inputFile, String outputFile, String freqFile){
       //clear the nodeArrayList and nodeHolder to ensure no previous exists in the function
       nodeHolder.clear();
       nodeArrayList.clear();
       //read the frequency file and construct the huffman tree
       readFreq(freqFile);
       hufNode root = build_tree(nodeArrayList);
       //output the decompression file based on the huffman tree.
       decompressing(inputFile,outputFile,root);
		// TODO: Your code here
   }
   //  read the inputfile into nodeHolder
   private void readString(String inputFile){

        BinaryIn a = new BinaryIn(inputFile);
        int cnt = 0;
        StringBuilder string = new StringBuilder();
        while(!a.isEmpty()){
            boolean x = a.readBoolean();
            if(x) string.append("1");
            else string.append("0");
            cnt ++;
            if(cnt == 8){
                cnt = 0;
                String ascii = string.toString();
                string = new StringBuilder();
                if(nodeHolder.containsKey(ascii)){
                    nodeHolder.get(ascii).addCap();
                }
                else{
                    hufNode newNode = new hufNode(ascii);
                    nodeHolder.put(ascii,newNode);
                }
            }
        }
   }
   // addFile method output the frequency file for the input file
    private   void addFile(ArrayList<hufNode> inputArray, String fileName) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        for(hufNode e: inputArray){
            writer.write(e.ascii+":"+e.cap+"\n");
        }
        writer.close();
    }
    // turn the hufNode into a huffman compression tree
    private hufNode build_tree(ArrayList<hufNode> inputArray){
        while(inputArray.size() > 1){
            hufNode x = inputArray.get(0);
            inputArray.remove(0);
            hufNode y = inputArray.get(0);
            inputArray.remove(0);
            int newSum = x.cap + y.cap;
            hufNode parent = new hufNode(newSum, x, y);
            inputArray.add(parent);
            inputArray.sort(new huffmanComparator());
        }
        return inputArray.get(0);
    }
    //output the compression file
   private void compress(String inputFile, String outPut){
       BinaryIn a = new BinaryIn(inputFile);
       BinaryOut b = new BinaryOut(outPut);
       int cnt = 0;
       StringBuilder string = new StringBuilder();
       while(!a.isEmpty()){
           boolean x = a.readBoolean();
           if(x) string.append("1");
           else string.append("0");
           cnt ++;
           if(cnt == 8){
               String tmp = string.toString();
               string = new StringBuilder();
               cnt = 0;
               hufNode curNode = nodeHolder.get(tmp);
               String y = curNode.huffCode;
               for(int i = 0; i < y.length();i++){
                   b.write(y.charAt(i) == '1');
               }
           }
       }
       b.flush();
   }
   // decompress the enc file based on the huffman tree and output the decompress file
   private void decompressing(String input, String output, hufNode root){
        BinaryIn a = new BinaryIn(input);
        BinaryOut b = new BinaryOut(output);
        hufNode curNode = root;
        int cnt = 0, total = root.getCap();
        while(!a.isEmpty() && cnt < total){
            if(curNode.getLeft() == null && curNode.getRight() == null){
                cnt++;
                String ascii = curNode.getAscii();
                curNode = root;
                for(int i = 0; i < ascii.length(); i ++){
                    b.write(ascii.charAt(i) == '1');
                }
            }
            else {
                boolean boolTmp = a.readBoolean();
                if(boolTmp){
                    curNode = curNode.getRight();
                }
                else{
                    curNode = curNode.getLeft();
                }
            }
        }
        b.flush();
   }
   // traverse down the tree to assign each hufCode to each ascii node.
   private void traverse(hufNode node, String x){
        if(node.left == null && node.right == null){
            node.huffCode = x;
            return;
        }
        String left = x + "0";
        String right = x +"1";
        traverse(node.getLeft(),left);
        traverse(node.getRight(),right);
   }
   // read the frequency file and to construct huffman code and build a tree
   private void readFreq(String inputFile){
       BinaryIn x = new BinaryIn(inputFile);
       String[] tmp = x.readString().split("\\r?\\n");
       for (String s : tmp) {
           int cap = Integer.parseInt(s.substring(9));
           String ascii = s.substring(0, 8);
           hufNode newNode = new hufNode(ascii, cap);
           nodeArrayList.add(newNode);
       }
       nodeArrayList.sort(new huffmanComparator());
   }

   public static void main(String[] args) throws Exception {
      Huffman  huffman = new HuffmanSubmit();
      huffman.encode("nys.txt", "ur.enc", "freq.txt");
      huffman.decode("ur.enc", "test.txt", "freq.txt");
      // After decoding, both ur.jpg and ur_dec.jpg should be the same.
       // On linux and mac, you can use `diff' command to check if they are the same.
   }

}
