/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.MonHoc;
import pojo.MonHocId;
import pojo.SinhVien;

public class MonHocDAO {
     public static List<MonHoc> LayDSMonHoc(){
        List<MonHoc> ds =null;
        Session ses=HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="select mh from MonHoc mh";
            Query que=ses.createQuery(hql);
            ds=que.list();
            
        }catch(HibernateException ex){
            System.err.print(ex);
        }finally{
            ses.close();
        }
        return ds;
    }
     public static void ThemSinhVienMonHoc(MonHoc mh){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
            try{
            transaction=session.beginTransaction();
            session.save(mh);
            transaction.commit();
            System.out.println("ekekeke");
            
        }catch(HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
            
        }finally{
            session.close();
        }
    }
     public static void main(String[] args) {
      SinhVien sv=new SinhVien(3,1712685,"83798217392","kahd jka","dhadhj","Nữ");
      MonHocId mhid=new MonHocId(sv,"17HCB","CT001");
      if(1==1)
      {
          MonHoc mh = new MonHoc(1,1712684,"17HCB","CT001",0,0,0,0);
          System.out.println("ekekeke");
          MonHocDAO.ThemSinhVienMonHoc(mh);
          
      }
      
    }
     
}
