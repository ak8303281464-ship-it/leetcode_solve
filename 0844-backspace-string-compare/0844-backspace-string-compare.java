class Solution {
    public boolean backspaceCompare(String s, String t) {
      Stack<Character> stack1  = new Stack<>();
      Stack<Character> stack2 = new Stack<>();
      for(char c1: s.toCharArray()){
        if(c1!='#'){
            stack1.push(c1);
        }
        else if(!stack1.isEmpty())
        {
            stack1.pop();
        }
      }  
       for(char c2: t.toCharArray()){
        if(c2!='#'){
            stack2.push(c2);
        }
        else if(!stack2.isEmpty())
        {
            stack2.pop();
        }
      }
     return stack1.equals(stack2);
    }
}