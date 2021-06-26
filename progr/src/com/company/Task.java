package com.company;


import java.awt.*;

public class Task {
    int ID;

    String data;
Task(int _ID,String _data){
    this.ID=_ID;

    this.data=_data;
}
Task(String str){
    String id= "";
    int curr=0;
    while(str.charAt(curr)!=' '){
        id+=str.charAt(curr);
        curr++;
    }
    this.ID=Integer.parseInt(id);
    id="";
    curr++;
    for(int i=curr;i<str.length();i++) {
        id+=str.charAt(i);
    }
    this.data=id;
}
String toStr(){
    String res=ID+" "+data;
    return res;
}

    public String toStrvis() {
        String res="ID: "+ ID+" Task: "+data;
        return res;
    }
}
