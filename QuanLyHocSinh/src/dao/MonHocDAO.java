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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
     public static List<MonHoc> layThongTinTheoMaMonHon(String mamon){
          List<MonHoc> ds= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
           Criteria crit = session.createCriteria(MonHoc.class);
           crit.add(Restrictions.eq("MaMon",mamon));
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
     public static void ThemDiem(MonHoc sv){
          Session session = HibernateUtil.getSessionFactory().openSession();
      try{
            session.beginTransaction();
            List<MonHoc> ds=MonHocDAO.layThongTinMonHoc(sv.getmaSinhVien());
            MonHoc employee=null;
            for(int i=0;i<ds.size();i++){
                if(sv.getMaMon().equals(ds.get(i).getMaMon())){
                    employee=ds.get(i);
                }
            }
            if(employee==null){
            System.out.println(sv.getmaSinhVien());}
            employee.setCK(sv.getCK());
            employee.setDK(sv.getDK());
            employee.setGK(sv.getGK());
            employee.setTK(sv.getTK());
            session.update(employee); 
            session.getTransaction().commit();
      }catch (HibernateException e) {
          e.printStackTrace();
            session.getTransaction().rollback();
      }finally {
         session.close(); 
      }
     }
     public static void XoaSinhVienMonHoc(int id){
        
         Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            MonHoc employee = (MonHoc) session.get(MonHoc.class, id);
            session.delete(employee);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }
     public static void main(String[] args) {
     
      if(1==1)
      {
         MonHocDAO.XoaSinhVienMonHoc(14);
          
      }
      
    }
     
}
