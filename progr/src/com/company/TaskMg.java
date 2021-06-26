package com.company;

import java.io.*;
import java.util.LinkedList;

public class TaskMg {
    File data;
    TaskMg(){
        data=new File("tasks.txt");
    }
    LinkedList<Task> toList(){

        LinkedList<Task> res=new LinkedList<Task>();
        if(data.length()==0) return res;
            try(FileReader reader=new FileReader(this.data))
        {
            BufferedReader br=new BufferedReader(reader);
            String line=br.readLine();

            while (line!=null){
                res.add(new Task(line));
                line= br.readLine();
            }
            return res;
        }
        catch(IOException ex){};
        return res;
    }
    public void add(String msg) throws IOException {
LinkedList<Task> Ldata=this.toList();
int max=0;
for(int i=0;i<Ldata.size();i++){
    if(Ldata.get(i).ID>max) max=Ldata.get(i).ID;
}
max++;
    Ldata.add(new Task(max,msg));
    write(Ldata);
    }
void clear() throws FileNotFoundException {
    PrintWriter writer = new PrintWriter(this.data);
    writer.print("");
    writer.close();
}
void write(LinkedList<Task> Ldata) throws IOException {
    this.clear();
    FileWriter fw=new FileWriter(this.data,true);
    BufferedWriter bw=new BufferedWriter(fw);

   for(int i=0;i<Ldata.size();i++){
       System.out.println(Ldata.get(i).toStr());
       bw.write(Ldata.get(i).toStr());
       bw.write("\n");

   }
   bw.close();
   fw.close();

}
void del(int id) throws IOException {
    LinkedList<Task> tasks = this.toList();
   for(int i=0;i<tasks.size();i++)
       if(id==tasks.get(i).ID)
           tasks.remove(i);
       write(tasks);
}
}
