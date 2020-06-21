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
public class XemDSLop extends JDialog
                        implements ActionListener {
    private static XemDSLop dialog;
    private int id;
    public static void showDialog(Component frameComp
                                    ) {
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new XemDSLop(frame);
        dialog.setSize(500,500);
        dialog.setVisible(true);
        
    }

    private XemDSLop(Frame frame) {
        super(frame, "them sinh vien", true);
        JPanel panel = new JPanel();
       panel.setLayout(null);
       panel.setBackground(Color.LIGHT_GRAY);
       
       JPanel panel1= new JPanel();
       panel1.setLayout(null);
       panel1.setBackground(Color.LIGHT_GRAY);
       panel1.setBounds(0,0,500,50);
       panel.add(panel1);
       JLabel label=new JLabel("Nhập mã lớp");
       panel1.add(label);
       label.setBounds(20,5,100,30);
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
       panel6.setBounds(0,370,500,50);
       panel6.setBackground(Color.LIGHT_GRAY);
       panel6.setLayout(null);
       panel.add(panel6);
       JButton button12 = new JButton("OK");
       button12.setBackground(Color.GREEN);
       panel6.add(button12);
       button12.setBounds(80,0,100,40);
       JButton button2 = new JButton("EXIT");
       button2.setBackground(Color.red);
       panel6.add(button2);
       button2.setBounds(260,0,100,40);
       //List<MonHoc> ds=null;
       id=0;
        
     
       button12.addActionListener(new ActionListener(){
           
            @Override
            @SuppressWarnings("empty-statement")
            public void actionPerformed(ActionEvent e) {
               String t1=text1.getText().toString();
               String t2=text2.getText().toString();
               if(t1.length()!=0){
                   if(t2.length()!=0){
                       List<MonHoc> dsmh=MonHocDAO.layThongTinTheoMaMonHon(t2);
                       String column[] = { "STT","MSSV", "Họ và tên", "Giới tính","CMND",};
                       String data[][]=new String[dsmh.size()][5];
                       for (int i=0;i<dsmh.size();i++){
                           SinhVien sv=SinhVienDAO.layThongTinhSinhVien(dsmh.get(i).getmaSinhVien());
                           data[i][0]=String.valueOf(i+1);
                           data[i][1]=String.valueOf(sv.getMaSinhVien_id());
                           data[i][2]=sv.getHoTen();
                           data[i][3]=sv.getGioiTinh();
                           data[i][4]=sv.getCMND(); 
                       }
                        JTable table=new JTable(data,column);
                        JScrollPane spTable = new JScrollPane(table);
                        spTable.setBounds(5,150,470,190);
                        panel.add(spTable); 
                   }else{
                   List<SinhVien> dssv=SinhVienDAO.LayDSSVTheoMaLop(t1);
                    String column[] = { "STT","MSSV", "Họ và tên", "Giới tính","CMND",};
                       String data[][]=new String[dssv.size()][5];
                   for (int i=0;i<dssv.size();i++){
                           data[i][0]=String.valueOf(i+1);
                           data[i][1]=String.valueOf(dssv.get(i).getMaSinhVien_id());
                           data[i][2]=dssv.get(i).getHoTen();
                           data[i][3]=dssv.get(i).getGioiTinh();
                           data[i][4]=dssv.get(i).getCMND(); 
                       }
                        JTable table=new JTable(data,column);
                        JScrollPane spTable = new JScrollPane(table);
                        spTable.setBounds(5,150,470,190);
                        panel.add(spTable); 
                   
                   }
               }else{
                   label5.setText("Mã lớp không được trống");
               }
            }
           
       });
       button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                XemDSLop.dialog.setVisible(false); }
           
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


