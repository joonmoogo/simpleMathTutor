package MathTutor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
    /*
    Author: jun muk o
    E-mail: junemuk@hknu.ac.kr
    Course: Java Programming
    Assignment: Programming Assignment 1
    Due date: 04/28/2021
    File: MathTutorGUI.java
    Purpose: Java application that implements an online specialty pizza shop
    Compiler/IDE: Java SE Development Kit 8u181/IntelliJ IDEA
    Operating system: MS Windows 10
    Reference(s): Java 8 API - Oracle Documentation
    (http://docs.oracle.com/javase/8/docs/api/);
    (Include ALL additional references (Web page, etc.) here.)
    */
public class MathTutorGUI extends JFrame implements ActionListener, KeyListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button = new JButton();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JTextArea textArea2 = new JTextArea();
    int answer;
    int count=1;
    int userAnswer;


    public static void main(String[] args) {
        MathTutorGUI mathTutorGUI = new MathTutorGUI();
        mathTutorGUI.go();
        System.out.println("2017245060_오준묵");
    }
    public void go(){
        frame.setBounds(100,100,300,150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.add(panel);
        textField.setSize(40,20);
        textField.setLocation(20,50);
        panel.add(textField);
        textArea.setText("Hi Math Tutor");
        panel.add(textArea);
        textArea2.setText("Just click the button");
        panel.add(textArea2);
        textArea.setBounds(10,10,200,20);
        textArea2.setBounds(10,30,200,20);
        panel.add(button);
        button.setText("New Problem");
        button.setBounds(100,50,150,20);
        button.addActionListener(this);
        textField.addKeyListener(this);
    } //시작

    public void generateProblem(){
        int number1 =(int)(Math.random()*10+1);
        int number2 =(int)(Math.random()*10+1);
        int number3 =(int)(Math.random()*2);
        String arithmetic[] = {"+","-"};
        textArea.setText("how much is "+number1+" "+arithmetic[number3]+" "+number2+" ?");
        if(number3==0){
            answer=number1+number2;
        }
        else if(number3==1){
            answer=number1-number2;
        }
        else if(number3==2){
            answer=number1*number2;
        }
        else if(number3==3){
            answer=number1/number2;
        }
        textArea2.setText("Please enter your answer");
        textField.setText("");
    }
    //문제 생성
    public void checkUserAnswer(int uAnswer){
        if(uAnswer==answer){
            textArea2.setText("very good! it only took you "+count+ " tries");
            count=1;
        }
        else{
            textArea2.setText("I'm sorry but no, Try again");
            count++;
        }
    }
    //정답 체크
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            generateProblem();
        }
    }
    // 버튼 이벤트 감지

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                userAnswer = Integer.parseInt(textField.getText());
                checkUserAnswer(userAnswer);
                textField.setText("");
            }
            catch (Exception ex){
                textField.setText("");
                textArea2.setText("you need to enter the Integer");
            }
        }
    }
    //클릭 이벤트 감지


}
