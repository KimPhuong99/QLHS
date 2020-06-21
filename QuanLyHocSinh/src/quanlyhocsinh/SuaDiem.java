/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocsinh;

import dao.MonHocDAO;
import dao.SinhVienDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import pojo.MonHoc;
import pojo.SinhVien;

/**
 *
 * @author Admin
 */
public class SuaDiem extends JDialog
        implements ActionListener {

    private static SuaDiem dialog;
    private int id;

    public static void showDialog(Component frameComp
    ) {
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new SuaDiem(frame);
        dialog.setSize(500, 500);
        dialog.setVisible(true);

    }

    SuaDiem(Frame frame) {
        super(frame, "them sinh vien", true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBounds(0, 0, 500, 50);
        panel.add(panel1);
        JLabel label = new JLabel("Nhập mã lớp");
        panel1.add(label);
        label.setBounds(20, 5, 100, 30);
        JTextField text1 = new JTextField();
        panel1.add(text1);
        text1.setBounds(230, 5, 170, 30);

        final JLabel label5 = new JLabel("");
        label5.setForeground(Color.YELLOW);
        label5.setBounds(260, 35, 170, 50);
        panel.add(label5);
        JPanel panel6 = new JPanel();
        panel6.setBounds(0, 400, 500, 50);
        panel6.setBackground(Color.LIGHT_GRAY);
        panel6.setLayout(null);
        panel.add(panel6);
        JButton button12 = new JButton("OK");
        button12.setBackground(Color.GREEN);
        panel6.add(button12);
        button12.setBounds(80, 0, 100, 40);
        JButton button2 = new JButton("EXIT");
        button2.setBackground(Color.red);
        panel6.add(button2);
        button2.setBounds(260, 0, 100, 40);
        label.setBounds(20, 5, 100, 30);
        JLabel label2 = new JLabel("Nhập mã môn học");
        panel.add(label2);
        label2.setBounds(20, 60, 170, 30);
        JTextField text2 = new JTextField();
        panel.add(text2);
        text2.setBounds(230, 60, 170, 30);
        JTextField text3=new JTextField();
        panel.add(text3);
        text3.setBounds(230,120,170,30);
        JLabel label3=new JLabel("Giữa kỳ");
        panel.add(label3);
        label3.setBounds(20,120,100,30);
        
        JTextField text4=new JTextField();
        panel.add(text4);
        text4.setBounds(230,180,170,30);
        JLabel label4=new JLabel("Cuối kỳ");
        panel.add(label4);
        label4.setBounds(20,180,100,30);
        
        JTextField text5=new JTextField();
        panel.add(text5);
        text5.setBounds(230,240,170,30);
        JLabel label55;
        label55 = new JLabel("Điểm khác");
        panel.add(label55);
        label55.setBounds(20,240,100,30);
        
        JTextField text6=new JTextField();
        panel.add(text6);
        text6.setBounds(230,300,170,30);
        JLabel label6=new JLabel("Tổng kết");
        panel.add(label6);
        label6.setBounds(20,300,100,30);
        JTextField text7=new JTextField();
        panel.add(text7);
        text7.setBounds(230,360,170,30);
        JLabel label7=new JLabel("MSSV");
        panel.add(label7);
        label7.setBounds(20,360,100,30);
        id = 0;

        button12.addActionListener(new ActionListener() {

            @Override
            @SuppressWarnings("empty-statement")
            public void actionPerformed(ActionEvent e) {
                String t1 = text1.getText().toString();
                String t2 = text2.getText().toString();
                 String t3 = text3.getText().toString();
                String t4 = text4.getText().toString();
                 String t5 = text5.getText().toString();
                 String t6 = text6.getText().toString();
                String t7=text7.getText().toString();
                
                
                if (t1.length() != 0 && t2.length() != 0&&t7.length()!=0) {
                   float GK,CK,DK,TK;
                   if(t3.length()==0)
                       GK=0;
                   if(t4.length()==0)
                       CK=0;
                   if(t5.length()==0)
                       DK=0;
                   if(t6.length()==0)
                       TK=0;
                    List<MonHoc> ds=MonHocDAO.layThongTinMonHoc(Integer.parseInt(t7));
                    MonHoc employee=null;
                    for(int i=0;i<ds.size();i++){
                        if(t2.equals(ds.get(i).getMaMon()))
                             employee=ds.get(i);
                    }
                    employee.setCK(Integer.parseInt(t3));
                    employee.setDK(Integer.parseInt(t4));
                    employee.setGK(Integer.parseInt(t5));
                    employee.setTK(Integer.parseInt(t6));
                    MonHocDAO.ThemDiem(employee);
                }

            }

        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuaDiem.dialog.setVisible(false);
            }

        });

        Container contentPane = getContentPane();
        contentPane.add(panel);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
