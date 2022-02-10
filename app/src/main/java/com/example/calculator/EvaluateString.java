package com.example.calculator;
import java.util.*;
class EvaluateString {

    public static Float evaluate(String expression) {

        char[] tokens = expression.toCharArray();    // convert String to char of array

        Stack<Float> values = new Stack<Float>();    // use built  stack for Number

        Stack<Character> ops = new Stack<Character>();  // use built  stack for Sign


        for (int i = 0; i < tokens.length; i++) {


            if (tokens[i] == ' ')                     //  Skip the distance
                continue;


            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {     // store Number in String Buffer
                    sbuf.append(tokens[i++]);
                }

                values.push( Float.parseFloat(sbuf.toString()));
            } else if (tokens[i] == '(')
                ops.push(tokens[i]);                                        // store in the  stack a  operator (


            else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.push( applyOp(ops.pop(), values.pop(), values.pop()));  // push value
                }
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '×' || tokens[i] == '÷') {

                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));        //push value
                }

                ops.push(tokens[i]);            // push sign
            }
        }


        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));   // push value
        }

        return values.pop();                                                // pop value
    }




    public static boolean hasPrecedence(char op1, char op2) {    // priorities
        if (op2 == '(' || op2 == ')')
            return false;

        if ((op1 == '×' || op1 == '÷') && (op2 == '+' || op2 == '-'))
            return false;

        else
            return true;
    }




    public static float applyOp(char op, double b, double a) {      // mathematical calculations

        switch (op) {

            case '+':
                return (float) (a + b);

            case '-':
                return (float) (a - b);

            case '×':
                return (float) (a * b);

            case '÷':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return (float) (a / b);
        }
        return 0;
    }
}
