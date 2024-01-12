package com.lucas.designpatterns.interpreter;

import java.util.StringTokenizer;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-11-08 10:37
 */
public class TerminalExpression extends Expression {
    private String literal = null;

    public TerminalExpression(String str) {
        literal = str;
    }

    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
