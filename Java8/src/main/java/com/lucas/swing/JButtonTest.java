package com.lucas.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonTest extends JFrame {
    private JButton button1;
    private JButton button2;
    private JTextField textField;

    public JButtonTest() {
        super("Simple Test");

        // 设置窗口的大小和布局
        setSize(600, 400);
        setLayout(new BorderLayout());

        // 创建文本框
        textField = new JTextField();

        // 创建按钮
        button1 = new JButton("11");
        button2 = new JButton("2");

        // 添加组件到按钮
        add(textField, BorderLayout.CENTER);
        add(button1, BorderLayout.NORTH);
        add(button2, BorderLayout.SOUTH);

        // 设置按钮的监听器
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "2");
            }
        });

        // 设置窗口可见
        setVisible(true);
    }
    public static void main(String[] args) {
        new JButtonTest();
    }
}
