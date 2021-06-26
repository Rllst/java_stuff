package com.company;

import java.io.*;
import java.lang.reflect.Field;

public class LessonMg {
Week week;
File data;
LessonMg(){
    week=new Week();
    data=new File("lessons.txt");
}
void change(int ls, String n, String l, String t) throws IOException {
    week.lesson[ls]=new Lesson(n,t,l);
    this.write();
}
Week read() throws IOException {
    Week res=new Week();
if(data.length()==0) return res;
   FileReader fr=new FileReader(this.data);
   BufferedReader br=new BufferedReader(fr);
    String line=br.readLine();
    int curr=0;
    String temp="";
    while (line!=null){
        curr=0;
        temp="";

      /*  i=Integer.parseInt(String.valueOf(line.charAt(0)));
        if(line.length()>2)
        res.lesson[i]=new Lesson(line.substring(2));*/
        line+="  ";
       while (line.charAt(curr)!=' '){
           temp+=line.charAt(curr);
           curr++;

       }
       curr++;
       if(line.charAt(curr)!=' ') res.lesson[Integer.parseInt(temp)]=new Lesson(line.substring(curr));
        line= br.readLine();
    }
    return res;
}
    void clear() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(this.data);
        writer.print("");
        writer.close();
    }
void write() throws IOException {
    this.clear();
    FileWriter fw=new FileWriter(this.data,true);
    BufferedWriter bw=new BufferedWriter(fw);

        for(int j=0;j<20;j++){
            if (week.lesson[j]==null){
                bw.write(Integer.toString(j));
                bw.write("\n");
            }else{
            bw.write(j+" "+ week.lesson[j].toStr());
            bw.write("\n");}
        }
    bw.close();
    fw.close();
    }
    void change(int l,String str) throws IOException {
//Week temp=this.read();
        this.week=this.read();
this.week.lesson[l]=new Lesson(str);

this.write();

}

}
