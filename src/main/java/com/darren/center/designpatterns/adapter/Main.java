package com.darren.center.designpatterns.adapter;

import java.io.*;

/**
 * <h3>tank-service</h3>
 * <p>适配器设计模式</p>
 *
 * @author : Darren
 * @date : 2020年07月30日 09:42:06
 **/
public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/test.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line).append(" ");
        }
        System.out.println(stringBuilder.toString());
        bufferedReader.close();
    }

}
