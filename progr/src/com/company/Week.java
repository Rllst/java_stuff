package com.company;

public class Week {
    Lesson[] lesson = new Lesson[20];
String[] getday(int i){
    String[] temp=new String[5];

   /* if(this.lesson[i]==null) temp="пар нема";
    else temp= ((int) (i) / 5 + 1) +". "+ this.lesson[i].toStrviev();*/

    for(int j=0;j<=4;j++){
        if(this.lesson[i+j]==null) temp[j]="пари нема";
        else{ temp[j]=Integer.toString((int)(i+j)/5 +1)+". "+ this.lesson[i+j].toStrviev();
            System.out.println(temp[j]);
    }}
    return temp;
    }

}
