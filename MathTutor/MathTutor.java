package MathTutor;

import java.util.Scanner;

//CLI version

public class MathTutor {
    int answer;
    int count=1;
    public static void main(String[] args) {

       MathTutor mathTutor = new MathTutor();
       mathTutor.go();
        System.out.println("2017245060_오준묵");


    }
    public void go(){
        generateProblem();
    }
    public void generateProblem(){
        int number1 =(int)(Math.random()*10+1);
        int number2 =(int)(Math.random()*10+1);
        int number3 =(int)(Math.random()*3+1);
        String arithmetic[] = {"+","-","*","/"};
        System.out.println("how much is "+number1+" "+arithmetic[number3]+" "+number2+" ?");
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
        getUserAnswer();


    }
    public void getUserAnswer(){
        try {
            Scanner sc = new Scanner(System.in);
            int userAnswer = sc.nextInt();
            checkUserAnswer(userAnswer);
        }
        catch (Exception e){
            System.out.println("please enter integer");
            getUserAnswer();
        }
    }
    public void checkUserAnswer(int uAnswer){
        if(uAnswer==answer){
            System.out.println("good job , You've tried "+count+" times");
        }
        else{
            System.out.println("Think about it");
            count++;
            getUserAnswer();
        }

    }
}
