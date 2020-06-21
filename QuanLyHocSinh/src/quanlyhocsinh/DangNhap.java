/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocsinh;

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
import javax.swing.JTextField;
import pojo.SinhVien;

/**
 *
 * @author Admin
 */
public class DangNhap extends JDialog
        implements ActionListener{
 private static DangNhap dialog;
    private int id;

    public static void showDialog(Component frameComp
    ) {
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new DangNhap(frame);
        dialog.setSize(500, 300);
        dialog.setVisible(true);

    }
     DangNhap(Frame frame) {
        super(frame, "them sinh vien", true);
        JPanel panel=new JPanel(null);
         panel.setBackground(Color.LIGHT_GRAY);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBounds(0, 0, 500, 50);
        panel.add(panel1);
        JLabel label = new JLabel("UserName");
        panel1.add(label);
        label.setBounds(20, 5, 100, 30);
        JTextField text1 = new JTextField();
        panel1.add(text1);
        text1.setBounds(230, 5, 170, 30);
        JLabel label2 = new JLabel("Password");
        panel.add(label2);
        label2.setBounds(20, 90, 170, 30);
        JTextField text2 = new JTextField();
        panel.add(text2);
        text2.setBounds(230, 90, 170, 30);
        JButton button =new JButton("OK");
        panel.add(button);
        button.setBounds(210,170,120,30);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String t1=text1.getText().toString();
                String t2=text2.getText().toString();
                if(t1.length()!=0&&t2.length()!=0){
                    if(t1.equals("giaovu")&&t2.equals("giaovu")){
                        DangNhap.dialog.setVisible(false);
                    }
                    List<SinhVien> dssv=SinhVienDAO.LayDSSinhVien();
                    for(SinhVien v:dssv){
                        String t=String.valueOf(v.getMaSinhVien_id());
                        if(t1.equals(t)&&t2.equals(t)){
                             DangNhap.dialog.setVisible(false);
                        }
                    }
                }
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
