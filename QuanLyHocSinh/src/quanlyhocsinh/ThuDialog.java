/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocsinh;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ThuDialog extends JDialog
                        implements ActionListener {
    private static ThuDialog dialog;
    public static void showDialog(Component frameComp
                                    ) {
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new ThuDialog(frame);
        dialog.setSize(500,500);
        dialog.setVisible(true);
        
    }

    private ThuDialog(Frame frame) {
        super(frame, "them sinh vien", true);
        JPanel panel=new JPanel();
        panel.setLayout(null);
        JPanel panel2=new JPanel();
        panel.add(panel2);
        panel.add(panel2);
       panel2.setBounds(0,90,500,300);
       panel2.setBackground(Color.red);
       String data[][] = { { "101", "Tran Van Minh", "6000" }, 
                { "102", "Phan Van Tai", "8000" }, 
                { "101", "Do Cao Hoc", "7000" } };
                String column[] = { "ID", "NAME", "SALARY" };
 
        JTable table=new JTable(data,column);
        JScrollPane spTable = new JScrollPane(table);
        panel2.add(spTable);
       
        Container contentPane = getContentPane();
       contentPane.add(panel);
       pack();

    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

