package dao;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.DangNhap;
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
    public static String LayTenMonHoc(String mamon){
         List<ThoiKhoaBieu> ds= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           Criteria crit = session.createCriteria(ThoiKhoaBieu.class);
           crit.add(Restrictions.eq("MaMon",mamon));
           ds = crit.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds.get(0).getTenMonHoc();
        
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
    public static void themMatKhau(DangNhap dn){
        //DangNhap d=new DangNhap(12,"12");
        Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction = session.beginTransaction();
            session.save(dn);
            transaction.commit();
            
        }catch(HibernateException ex){
            transaction.rollback();
            System.err.print(ex);
        }finally{
            session.close();
        }
    }
    public static DangNhap LayThongTinDN(java.lang.Integer MSSV){
        DangNhap sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (DangNhap) session.get(DangNhap.class,
                    MSSV);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }
    public static void SuaMatKhau(java.lang.Integer MSSV, String pass){
         Session session = HibernateUtil.getSessionFactory().openSession();
      try{
            session.beginTransaction();
            
            DangNhap dn=SinhVienDAO.LayThongTinDN(MSSV);
           dn.setPass(pass);
            
            
            session.update(dn); 
            session.getTransaction().commit();
      }catch (HibernateException e) {
          e.printStackTrace();
            session.getTransaction().rollback();
      }finally {
         session.close(); 
      }
    }
    
    public static List<DangNhap> LayDSMK(){
         List<DangNhap> ds =null;
        Session ses=HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="select dn from DangNhap dn";
            Query que=ses.createQuery(hql);
            ds=que.list();
            
        }catch(HibernateException ex){
            System.err.print(ex);
        }finally{
            ses.close();
        }
        return ds;
    }
    
    
    public static void main(String[] args) {
      DangNhap dn=new DangNhap(12,"12");
      SinhVienDAO.themMatKhau(dn);
      
    }
    
}