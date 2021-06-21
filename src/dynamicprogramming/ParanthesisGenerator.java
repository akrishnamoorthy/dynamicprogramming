package dynamicprogramming;

import java.util.*;

public class ParanthesisGenerator {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    public void dfs(int open, int close, String curr){
        if(open == 0 && close == 0){
            res.add(curr);
            return;
        }//3,3
        if(open > close)
            return;
        if(open > 0){
            dfs(open - 1, close, curr + "(");
        }
        if(close > 0){
            dfs(open, close - 1, curr + ")");
        }
    }

    public static  void main(String args[]){
        ParanthesisGenerator gen = new ParanthesisGenerator();
        gen.dfs(3,3,"");
    }
}
