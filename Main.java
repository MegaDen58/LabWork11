package com.company;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.*;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Exception{
        String regexp1 = "((((25[0-5])|(2[0-4]\\d))|((1\\d{2})|(\\D(\\d{1,2}))))\\.((((((25[0-5])|(2[0-4]\\d))|((1\\d{2})|(\\d{1,2})))\\.)){2})(((25[0-5])|(2[0-4]\\d))|(((1\\d{2}))|(\\d{1,2}))))(\\D|$)";
        Pattern pattern = Pattern.compile(regexp1);
        Scanner in = new Scanner(System.in);
        System.out.print("Введите предложение: ");
        String word = in.nextLine();
        Matcher m = pattern.matcher(word);
        try{
            FileWriter fileWriter = new FileWriter("output.txt");
            if(m.find()){
                    String result = "Корректный IP адрес: " + m.group();
                    fileWriter.write(result);
                    fileWriter.flush();
            }
            else{
                    fileWriter.write("Корректные IP-адресы не найдены.");
                    fileWriter.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
