package net.africanbank.utils;

import java.util.Arrays;

/**
 * Created by patricktchankue on 6/1/16.
 */
public class Operation {

    private boolean has_operator;
    private String operator;
    private int operand;

    private static String[] op = {"==",">=", "<=", "+", "-", "<", "/", ":",  ">", };
    public Operation(){}

    public boolean containsExpression (String input){
        boolean res = false;
        for (int i = 0; i<op.length; i++){
            if(input.contains(op[i])){
                res = true;
                operator = op[i];
                String temp = input.replace(op[i], "");
                operand = Integer.parseInt(temp);
                return res;
            }
        }

        return res;
    }
    public int getOperator(){
        return Arrays.asList(op).indexOf(operator);
    }
    public int getOperand(){
        return operand;
    }

}
