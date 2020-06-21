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
import pojo.ThoiKhoaBieu;

/**
 *
 * @author Admin
 */
public class DialogThemSinhVienMonHoc extends JDialog
                        implements ActionListener {
    private static DialogThemSinhVienMonHoc dialog;
    private int id;
    public static void showDialog(Component frameComp
                                    ) {
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new DialogThemSinhVienMonHoc(frame);
        dialog.setSize(500,500);
        dialog.setVisible(true);
        
    }

    private DialogThemSinhVienMonHoc(Frame frame) {
        super(frame, "them sinh vien", true);
        JPanel panel = new JPanel();
       panel.setLayout(null);
       panel.setBackground(Color.LIGHT_GRAY);
       
       JPanel panel1= new JPanel();
       panel1.setLayout(null);
       panel1.setBackground(Color.LIGHT_GRAY);
       panel1.setBounds(0,0,500,50);
       panel.add(panel1);
       JLabel label=new JLabel("Nhập MSSV");
       panel1.add(label);
       label.setBounds(20,5,70,30);
       JLabel label2=new JLabel("Nhập mã môn học");
       panel.add(label2);
       label2.setBounds(20,90,170,30);
       JTextField text2 = new JTextField();
       panel.add(text2);
       text2.setBounds(230,90,170,30);
       JTextField text1=new JTextField();
       panel1.add(text1);
       text1.setBounds(230,5,170,30);
       
       final JLabel label5 = new JLabel("");
       label5.setForeground(Color.YELLOW);
       label5.setBounds(260,35,170,50);
       panel.add(label5);
       JPanel panel6 = new JPanel();
       panel6.setBounds(0,300,500,50);
       panel6.setBackground(Color.LIGHT_GRAY);
       panel6.setLayout(null);
       panel.add(panel6);
       JButton button12 = new JButton("OK");
       button12.setBackground(Color.GREEN);
       panel6.add(button12);
       button12.setBounds(80,0,100,40);
       JButton button2 = new JButton("CANCEL");
       button2.setBackground(Color.red);
       panel6.add(button2);
       button2.setBounds(260,0,100,40);
       //List<MonHoc> ds=null;
       id=0;
         List<ThoiKhoaBieu> dstkb=SinhVienDAO.LayDSTKB();
         System.out.println(dstkb.size());
       String column[] = { "STT", "Mã môn", "Mã lớp","Tên môn học","Phòng học" };
       String[][] data= new String[dstkb.size()][5];
        for(int i=0;i<dstkb.size();i++){
                    data[i][0]=String.valueOf(i+1);
                    data[i][1]=dstkb.get(i).getMaMon();
                    data[i][2]=dstkb.get(i).getMaLop();
                    data[i][3]=dstkb.get(i).getTenMonHoc();
                    data[i][4]=dstkb.get(i).getPhongHoc();
                }
         JTable table=new JTable(data,column);
         JScrollPane spTable = new JScrollPane(table);
         spTable.setBounds(5,150,470,70);
         panel.add(spTable);   
     
       button12.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                String t1=text1.getText().toString();
                String t2=text2.getText().toString();
                if(t1.length()!=0&&t2.length()!=0){
                    
                    List<MonHoc> dsmh=MonHocDAO.LayDSMonHoc();
                    int id=dsmh.get(0).getId();
                    for(int j=0;j<dsmh.size();j++){
                        if(id<dsmh.get(j).getId())
                            id=dsmh.get(j).getId();
                    }
                    SinhVien sv=SinhVienDAO.layThongTinhSinhVien(Integer.parseInt(t1));
                    
                    MonHoc mh=new MonHoc(id+1,Integer.parseInt(t1),sv.getMaLop(),t2,0,0,0,0);
                    MonHocDAO.ThemSinhVienMonHoc(mh);
                    DialogThemSinhVienMonHoc.dialog.setVisible(false);
                }
                label5.setText("Dữ liệu nhập trống.");
            }
           
       });
       button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogThemSinhVienMonHoc.dialog.setVisible(false); }
           
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

