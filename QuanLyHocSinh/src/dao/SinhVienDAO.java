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
import pojo.SinhVien;
import pojo.ThoiKhoaBieu;


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
    public static List<SinhVien> LayDSSVTheoMaLop(String malop){
        List<SinhVien> ds= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           Criteria crit = session.createCriteria(SinhVien.class);
           crit.add(Restrictions.eq("MaLop",malop));
           ds = crit.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    public static List<ThoiKhoaBieu> LayDSTKBTheoMaLop(String malop){
         List<ThoiKhoaBieu> ds= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           Criteria crit = session.createCriteria(ThoiKhoaBieu.class);
           crit.add(Restrictions.eq("MaLop",malop));
           ds = crit.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
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
     public static List<ThoiKhoaBieu> LayDSTKB(){
        List<ThoiKhoaBieu> ds =null;
        Session ses=HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="select tkb from ThoiKhoaBieu tkb";
            Query que=ses.createQuery(hql);
            ds=que.list();
            
        }catch(HibernateException ex){
            System.err.print(ex);
        }finally{
            ses.close();
        }
        return ds;
    }
    public static void ThemTKB(ThoiKhoaBieu tkb){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(tkb);
            transaction.commit();
            
        }catch(HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
            System.out.print("tukckkkkkkkk");
        }finally{
            session.close();
        }
    }
    
    public static void main(String[] args) {
      //SinhVien sv=new SinhVien(3,1712685,"83798217392","kahd jka","dhadhj",1);
      ThoiKhoaBieu tkb= new ThoiKhoaBieu(1,"18cct5","ct001","mon","23");
      if(1==1)
      {
          List<ThoiKhoaBieu> ds=SinhVienDAO.LayDSTKB();
          System.out.println(ds.size());
      }
      
    }
    
}