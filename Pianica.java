package ru.mirea;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Stack<Integer> stack_first = new Stack<>();

        System.out.print("Набор карт первого игрока:\n");
        for (int i = 0; i < 5; i++){
            stack_first.push(in.nextInt());
            System.out.print("\n");
        }

        System.out.println("Текущий стек: " + stack_first); //НАЧАЛО ПЕРВЫЙ ИГРОК

        Stack<Integer> stack_second = new Stack<>();

        System.out.print("Набор карт первого игрока:\n");
        for (int i = 0; i < 5; i++){
            stack_second.push(in.nextInt());
            System.out.print("\n");
        }

        System.out.println("Текущий стек: " + stack_second); //НАЧАЛО ВТОРОЙ ИГРОК

        int count = 0;

        while(stack_first.empty() == false && stack_second.empty() == false && count <=  106){
            if((stack_first.peek() == 9 && stack_second.peek() == 0) || (stack_first.peek() == 0 && stack_second.peek() == 9)){
                if(stack_first.peek() > stack_second.peek()){
                    stack_second.push(stack_first.pop());
                    count++;
                    System.out.println(stack_first);
                    System.out.println(stack_second);
                }
                else{
                    stack_first.push(stack_second.pop());
                    count++;
                    System.out.println(stack_first);
                    System.out.println(stack_second);
                }
            }else{
                if(stack_first.peek() < stack_second.peek()){
                    stack_second.push(stack_first.pop());
                    count++;
                    System.out.println(stack_first);
                    System.out.println(stack_second);
                }
                else{
                    stack_first.push(stack_second.pop());
                    count++;
                    System.out.println(stack_first);
                    System.out.println(stack_second);
                }
            }
        }

        System.out.println(count);

        if (count > 106) {
            System.out.println("botva\n");
        }else if(stack_second.empty() == true){
            System.out.println("First is winner, count of turns: " +count+ "\n");
        }else if(stack_first.empty() == true){
            System.out.println("Second is winner, count of turns: " +count+ "\n");
        }
    }
}
