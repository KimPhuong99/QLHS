/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
     public static List<MonHoc> layThongTinMonHoc(java.lang.Integer maSinhVien) {
        List<MonHoc> ds= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
           Criteria crit = session.createCriteria(MonHoc.class);
           crit.add(Restrictions.eq("maSinhVien",maSinhVien));
           ds = crit.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
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
           
            
        }catch(HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
            
        }finally{
            session.close();
        }
    }
     public static void main(String[] args) {
     
      if(1==1)
      {
         List<MonHoc> mh=MonHocDAO.layThongTinMonHoc(1742001);
         
         for(int i=0;i<mh.size();i++){
             System.out.println(mh.get(i).getMaMon());
         }
          
      }
      
    }
     
}
