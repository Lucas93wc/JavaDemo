package com.lucas.designpatterns.interpreter;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-11-08 10:39
 */
public class Client {
    /**
     * 构建解析树
     */
    public static Expression buildInterpreterTree() {
        // Literal
        Expression terminal1 = new TerminalExpression("A");
        Expression terminal2 = new TerminalExpression("B");
        Expression terminal3 = new TerminalExpression("C");
        Expression terminal4 = new TerminalExpression("D");
        // B Or C
        Expression alternation1 = new OrExpression(terminal2, terminal3);
        // A Or (B Or C)
        Expression alternation2 = new OrExpression(terminal1, alternation1);
        // D And (A Or (B Or C))
        return new AndExpression(terminal4, alternation2);
    }

    public static void main(String[] args) {
        Expression define = buildInterpreterTree();
        String context1 = "D A";
        String context2 = "A B";
        System.out.println(define.interpret(context1));
        System.out.println(define.interpret(context2));
    }
}
