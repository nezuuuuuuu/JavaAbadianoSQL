package com.example.csit228f2_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char c=scanner.nextLine().charAt(0);
        while(c!='x'){
            c=scanner.nextLine().charAt(0);
            switch (c){
                case 'i':
                    String name=scanner.nextLine();
                    String email=scanner.nextLine();
                    InsertData.insertData(name,email);
                    break;
                case 'd':


                    break;
            }
        }
    }
}
