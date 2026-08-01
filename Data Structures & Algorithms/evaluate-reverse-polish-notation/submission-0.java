class Solution {
    public int evalRPN(String[] tokens) {
     Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int b = stack.pop();  // second number
                int a = stack.pop();  // first number

                if(tokens[i].equals("+")) stack.push(a + b);
                if(tokens[i].equals("-")) stack.push(a - b);
                if(tokens[i].equals("*")) stack.push(a * b);
                if(tokens[i].equals("/")) stack.push(a / b);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();   
    }
}
