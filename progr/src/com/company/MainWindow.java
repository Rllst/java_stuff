package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

public class MainWindow extends JFrame implements ActionListener  {
    TaskMg TM=new TaskMg();
    LessonMg LM=new LessonMg();
   JMenuBar menu;
JMenu TaskManager;
JMenu LessonsManager;
JMenu Exit;
JMenuItem ExitItem;
JMenuItem LessonsChange;
JMenuItem LessonsShow;
JMenuItem TaskShow;
JMenuItem TaskAdd;
JMenuItem TaskDone;
JMenuItem TaskDel;
Font font=new Font("Monaco",Font.BOLD,16);
   private void initMenu(){
    menu=new JMenuBar();
    TaskManager=new JMenu("TaskManager");
    TaskShow=new JMenuItem("Show");
    TaskAdd=new JMenuItem("Add");;
    TaskDone=new JMenuItem("Done");;
    TaskDel=new JMenuItem("Delete");;
    TaskManager.add(TaskShow);
    TaskManager.add(TaskAdd);
    //TaskManager.add(TaskDone);
    TaskManager.add(TaskDel);

    menu.add(TaskManager);
       TaskShow.addActionListener(this);
       TaskDel.addActionListener(this);
       TaskAdd.addActionListener(this);
    LessonsManager=new JMenu("LessonsManager");
    LessonsChange=new JMenuItem("Change");
    LessonsShow=new JMenuItem("Show");
    LessonsManager.add(LessonsShow);
    LessonsShow.addActionListener(this);
       LessonsChange.addActionListener(this);
    LessonsManager.add(LessonsChange);
    menu.add(LessonsManager);

    Exit=new JMenu("Exit");
    ExitItem=new JMenuItem("Exit");
    Exit.add(ExitItem);
    ExitItem.addActionListener(this);
    menu.add(Exit);



    this.setJMenuBar(menu);
}
MainWindow() throws IOException {
    this.setSize(300,60);
   this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
this.setResizable(false);
    this.initMenu();
   // this.initLessons();
    this.setVisible(true);
}
private void initLessons() throws IOException {

Week temp=LM.read();
    JFrame ls=new JFrame();
   /* String[] columnsHeader = new String[] {"Пн", "Вт",
            "Ср", "Чт", "Пт"};
    String[][] array=new String[][]{temp.getday(0),temp.getday(5),temp.getday(10),temp.getday(15)};

    JTable table=new JTable(array,columnsHeader);
    table.setRowHeight(50);

 table.setFont(font);

 ls.add(new JScrollPane(table));
 ls.setSize(1400,350);
 ls.setVisible(true);*/
   JPanel panel = new JPanel(new GridLayout(5, 5, 5, 5));
   JTextArea Mon=new JTextArea("ПН");
           Mon.setFont(new Font("Monaco",Font.BOLD,30));

    panel.add(Mon);
    JTextArea Tue=new JTextArea("ВТ");
    Tue.setFont(new Font("Monaco",Font.BOLD,30));

    panel.add(Tue);
    JTextArea Wed=new JTextArea("СР");
   Wed.setFont(new Font("Monaco",Font.BOLD,30));

    panel.add(Wed);
    JTextArea Thu=new JTextArea("ЧТ");
    Thu.setFont(new Font("Monaco",Font.BOLD,30));

    panel.add(Thu);
    JTextArea Fri=new JTextArea("ПТ");
    Fri.setFont(new Font("Monaco",Font.BOLD,30));

    panel.add(Fri);
    for (int i = 0; i <= 15; i+=5) {
        String[] temp1=temp.getday(i);
        for(int j=0;j<=4;j++){
            JTextArea jt=new JTextArea(temp1[j]);
            jt.setFont(font);
            jt.setLineWrap(true);
            jt.setWrapStyleWord(false);
        panel.add(jt);

    }}
   ls.add(panel);
   ls.setSize(1200, 700);
    ls.setVisible(true);


}
void initTask(){
       JFrame tsk=new JFrame("Tasks");
       DefaultListModel<String> list=new DefaultListModel<String>();
    LinkedList<Task> data =TM.toList();
    for(int i=0;i<data.size();i++){
        list.add(0, data.get(i).toStrvis());
    }
    JList dta=new JList(list);
   // JPanel panel=new JPanel();
    JScrollPane scr=new JScrollPane(dta);
    dta.setFont(font);
   // panel.add(dta);
    tsk.add(scr);
    tsk.setSize(420,420);
    tsk.setResizable(false);
    tsk.setVisible(true);

}
void tskdel(){
       JFrame frame=new JFrame("Add Task");
       LinkedList<Task> Ldata=TM.toList();
    int max=0;
    for(int i=0;i<Ldata.size();i++){
        if(Ldata.get(i).ID>max) max=Ldata.get(i).ID;
    }
       SpinnerNumberModel spiner=new SpinnerNumberModel(max,0,max,1);
    JPanel panel=new JPanel();
    JSpinner sp=new JSpinner(spiner);
    panel.add(sp);
    JButton button =new JButton("Delete");
    button.setSize(100,50);
    panel.add(button);
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id=sp.getValue().toString();
            try {
                TM.del(Integer.parseInt(id));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    });
    frame.add(panel);
    frame.setSize(200,120);
    frame.setResizable(false);
    frame.setVisible(true);
}
void addTask(){
        JFrame adder =new JFrame("AddTask");
    JTextField _name = new JTextField("Task", 25);
    JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
    contents.add(_name);
    JButton button=new JButton("Add");
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                TM.add(_name.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    });
    contents.add(button);
    adder.add(contents);
    adder.setSize(290,100);
    adder.setVisible(true);

    }
void changeLs(){
       JFrame changer =new JFrame("Change Lesson");
       changer.setFont(font);
    JTextField _name = new JTextField("Name", 25);
    JTextField _teacher = new JTextField("Teacher", 25);
    JTextField _link = new JTextField("Link", 25);

    SpinnerNumberModel id=new SpinnerNumberModel(0,0,19,1);
    JSpinner _id=new JSpinner(id);
JButton button=new JButton("Change");
button.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        String str=_name.getText()+" "+_teacher.getText()+" "+_link.getText();
        String val= _id.getValue().toString();

        try {
            LM.change(Integer.parseInt(val),str);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
});



    JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
    contents.add(_name);
    contents.add(_teacher);
    contents.add(_link);
    contents.add(_id);
    contents.add(button);

    setContentPane(contents);
    changer.add(contents);
    changer.setSize(290,150);
    changer.setResizable(false);
    changer.setVisible(true);


}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==LessonsShow){
            try {
                initLessons();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if(e.getSource()==ExitItem){
            System.exit(0);
        }
        if(e.getSource()==LessonsChange){
            changeLs();
        }
        if(e.getSource()==TaskShow) initTask();
        if(e.getSource()==TaskDel) tskdel();
        if(e.getSource()==TaskAdd) addTask();
    }
}


