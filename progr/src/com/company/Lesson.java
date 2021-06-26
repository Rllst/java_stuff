package com.company;

public class Lesson {
    String name,teatcher,link;
    Lesson(){
        name= "`";
        teatcher="`";
        link="`";
    }
    Lesson(String _name, String _teatcher,String _link){
        name= _name;
        teatcher=_teatcher;
        link=_link;
    }
    String toStr(){
        return name+" "+teatcher+" "+link;
    }
 String toStrviev(){
     return name+"    "+teatcher+"\n\n "+link;
 }
    Lesson(String str){
        String res="";
        int curr=0;
        while(str.charAt(curr)!=' '){
            res+=str.charAt(curr);
            curr++;
        }
        this.name=res;
        res="";
        curr++;
        while(str.charAt(curr)!=' '){
            res+=str.charAt(curr);
            curr++;
        }
        this.teatcher=res;
        res="";
        curr++;
        for(int i=curr;i<str.length();i++)
            res+=str.charAt(i);
        this.link=res;

    }
}

