package quanlyhocsinh;

import dao.SinhVienDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import pojo.SinhVien;


public class ListDialog extends JDialog
                        implements ActionListener {
    private static ListDialog dialog;
    private static String value = "";
    private JList list;
    public static String showDialog(Component frameComp
                                    ) {
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new ListDialog(frame);
        dialog.setSize(500,400);
        dialog.setVisible(true);
        return value;
    }



    private ListDialog(Frame frame) {
        super(frame, "them sinh vien", true);
       JPanel panel = new JPanel();
       panel.setLayout(null);
       panel.setBackground(Color.LIGHT_GRAY);
       
       JPanel panel1= new JPanel();
       panel1.setLayout(null);
       panel1.setBackground(Color.LIGHT_GRAY);
       panel1.setBounds(0,0,500,50);
       panel.add(panel1);
       JTextField text1=new JTextField();
       text1.setBounds(170,10,300,30);
       panel1.add(text1);
       text1.setColumns(10);
       JLabel label1 = new JLabel("MSSV");
       label1.setBounds(20,10,50,30);
       panel1.add(label1);
       
       JPanel panel2= new JPanel();
       panel2.setLayout(null);
       panel2.setBackground(Color.LIGHT_GRAY);
       panel2.setBounds(0,50,500,50);
       panel.add(panel2);
       JTextField text2=new JTextField();
       text2.setBounds(170,5,300,30);
       panel2.add(text2);
       text2.setColumns(10);
       JLabel label2 = new JLabel("Họ và tên");
       label2.setBounds(20,5,70,30);
       panel2.add(label2);
       
       
       JPanel panel3= new JPanel();
       panel3.setLayout(null);
       panel3.setBackground(Color.LIGHT_GRAY);
       panel3.setBounds(0,100,500,50);
       panel.add(panel3);
       JTextField text3=new JTextField();
       text3.setBounds(170,5,300,30);
       panel3.add(text3);
       text3.setColumns(10);
       JLabel label3 = new JLabel("CMND");
       label3.setBounds(20,5,70,30);
       panel3.add(label3);
       
       JPanel panel4= new JPanel();
       panel4.setLayout(null);
       panel4.setBackground(Color.LIGHT_GRAY);
       panel4.setBounds(0,150,500,50);
       panel.add(panel4);
       JTextField text4=new JTextField();
       text4.setBounds(170,5,300,30);
       panel4.add(text4);
       text4.setColumns(10);
       JLabel label4 = new JLabel("Lớp");
       label4.setBounds(20,5,70,30);
       panel4.add(label4);
       
       JPanel panel45 = new JPanel();
       panel45.setLayout(null);
       panel45.setBackground(Color.LIGHT_GRAY);
       panel45.setBounds(0, 200, 500, 50);
       panel.add(panel45);
       JLabel label45 = new JLabel("Giới tính");
       label45.setBounds(20,5,70,30);
       panel45.add(label45);
       JCheckBox checkbox1 = new JCheckBox("Nữ");
       checkbox1.setBounds(200, 5,50, 30);
       checkbox1.setBackground(Color.LIGHT_GRAY);
       panel45.add(checkbox1);
       JCheckBox checkbox2 = new JCheckBox("Nam");
       checkbox2.setBounds(300,5,100,30);
       checkbox2.setBackground(Color.LIGHT_GRAY);
       panel45.add(checkbox2);
       
       JLabel label5 = new JLabel("Nhập đúng thứ tự");
       label5.setForeground(Color.YELLOW);
       label5.setBounds(350,200,340,20);
       panel.add(label5);
      
       JPanel panel6 = new JPanel();
       panel6.setBounds(0,260,500,50);
       panel6.setBackground(Color.LIGHT_GRAY);
       panel6.setLayout(null);
       panel.add(panel6);
       JButton button1 = new JButton("OK");
       button1.setBackground(Color.GREEN);
       panel6.add(button1);
       button1.setBounds(80,0,100,40);
       JButton button2 = new JButton("CANCEL");
       button2.setBackground(Color.red);
       panel6.add(button2);
       button2.setBounds(260,0,100,40);
       
       button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               String t1=text1.getText().toString();
               String t2=text2.getText().toString();
               String t3=text3.getText().toString();
               String t4=text4.getText().toString();
               if(t1!=""&&t2!=""&&t3!=""&&t4!=""){
               java.util.List<SinhVien> ds =SinhVienDAO.LayDSSinhVien();
               //SinhVien sv=SinhVien(ds.size()+1,Integer.parseInt(1),)

            }}
           
       });
       Container contentPane = getContentPane();
       contentPane.add(panel);
       pack();
      
    }

    
    public void actionPerformed(ActionEvent e) {
        e.getActionCommand();
        ListDialog.dialog.setVisible(false);
    }
}
