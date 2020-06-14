package dao;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.SinhVien;


public class SinhVienDAO {

    public static List<SinhVien> LayDSSinhVien(){
        List<SinhVien> ds =null;
        Session ses=HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="select sv from SinhVien sv";
            Query que=ses.createQuery(hql);
            ds=que.list();
            
        }catch(HibernateException ex){
            System.err.print(ex);
        }finally{
            ses.close();
        }
        return ds;
    }
    public static SinhVien layThongTinhSinhVien(java.lang.Integer maSinhVien) {
        SinhVien sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (SinhVien) session.get(SinhVien.class,
                    maSinhVien);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }
    public static boolean ThemSinhVien(SinhVien sv){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(SinhVienDAO.layThongTinhSinhVien(sv.getMaSinhVien_id())!=null){
            return false;
        }
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(sv);
            transaction.commit();
            
        }catch(HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
            System.out.print("tukckkkkkkkk");
        }finally{
            session.close();
        }
        return true;
    }
    public static void main(String[] args) {
      //SinhVien sv=new SinhVien(3,1712685,"83798217392","kahd jka","dhadhj",1);
      if(1==1)
      {
          System.out.print(SinhVienDAO.layThongTinhSinhVien(1712685).getMaSinhVien_id());
          
      }
      
    }
    
}