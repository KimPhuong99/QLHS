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
import javax.swing.table.DefaultTableModel;
import pojo.MonHoc;
import pojo.ThoiKhoaBieu;

/**
 *
 * @author Admin
 */
public class DialogXoaSinhVien extends JDialog
                        implements ActionListener {
    private static DialogXoaSinhVien dialog;
    public static void showDialog(Component frameComp
                                    ) {
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new DialogXoaSinhVien(frame);
        dialog.setSize(500,500);
        dialog.setVisible(true);
        
    }

    private DialogXoaSinhVien(Frame frame) {
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
       JTextField text1=new JTextField();
       panel1.add(text1);
       text1.setBounds(230,5,100,30);
       JButton button1=new JButton("OK");
       panel1.add(button1);
       button1.setBounds(330,5,70,30);
       final JLabel label5 = new JLabel("");
       label5.setForeground(Color.YELLOW);
       label5.setBounds(300,35,120,50);
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
       button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] data= null;
                String column[] = { "STT", "Mã môn", "Mã lớp","Tên môn học" };
                String t1=text1.getText().toString();
                
                List<ThoiKhoaBieu> dstkb=SinhVienDAO.LayDSTKB();
                
                List<MonHoc> ds=MonHocDAO.layThongTinMonHoc(Integer.parseInt(t1));
                
                for(int i=0;i<ds.size();i++){
                    data[i][0]=String.valueOf(i+1);
                    data[i][1]=ds.get(i).getMaMon();
                    data[i][2]=ds.get(i).getMaLop();
                    data[i][3]="";
                    System.out.println(ds.size());
                    for(int j=0;j<dstkb.size();j++){
                        if(dstkb.get(j).getMaMon().equals(ds.get(i).getMaMon())){
                            data[i][3]=dstkb.get(j).getTenMonHoc();
                            break;
                        }
                    }    
                }
                JTable table=new JTable(data,column);
                JScrollPane spTable = new JScrollPane(table);
                spTable.setBounds(5,90,470,70);
                panel.add(spTable);     
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
