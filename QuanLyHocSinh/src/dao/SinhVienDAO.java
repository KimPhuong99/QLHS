package dao;

import Util.HibernateUtil;
import java.io.UnsupportedEncodingException;
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
import pojo.TaoPhucKhao;
import pojo.ThoiKhoaBieu;
import pojo.phucKhao;


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
    public static void themPhucKhao(phucKhao pk){
        Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction = session.beginTransaction();
            session.save(pk);
            transaction.commit();
            
        }catch(HibernateException ex){
            transaction.rollback();
            System.err.print(ex);
        }finally{
            session.close();
    }}
    public static void themTaoPhucKhao(TaoPhucKhao pk){
         Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction = session.beginTransaction();
            session.save(pk);
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
    public static phucKhao LayThongTinPK(java.lang.Integer MSSV){
         phucKhao sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (phucKhao) session.get(phucKhao.class,
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
    public static void SuaPK(int MSSV,int tt){
        Session session = HibernateUtil.getSessionFactory().openSession();
      try{
            session.beginTransaction();
            phucKhao dn=SinhVienDAO.LayThongTinPK(MSSV);
           dn.setSTT(tt);
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
    public static List<phucKhao> LayDSPK(){
        List<phucKhao> ds =null;
        Session ses=HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="select pk from phucKhao pk";
            Query que=ses.createQuery(hql);
            ds=que.list();
            
        }catch(HibernateException ex){
            System.err.print(ex);
        }finally{
            ses.close();
        }
        return ds;
    }
    public static List<TaoPhucKhao> LayDSTPK(){
         List<TaoPhucKhao> ds =null;
        Session ses=HibernateUtil.getSessionFactory().openSession();
        try{
            String hql="select pk from TaoPhucKhao pk";
            Query que=ses.createQuery(hql);
            ds=que.list();
            
        }catch(HibernateException ex){
            System.err.print(ex);
        }finally{
            ses.close();
        }
        return ds;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
      //DangNhap dn=new DangNhap(12,"12");
      //SinhVienDAO.themMatKhau(dn);
     
      String str1 = "18HCB";
      String str2 = "17HCB";
      byte[] arr = str1.getBytes("UTF8");
      byte[] brr = str2.getBytes("UTF8");
      
      List<SinhVien> ds= SinhVienDAO.LayDSSinhVien();
      
      String cvstring=new String(brr,"UTF8");
         System.out.println(cvstring.compareTo(ds.get(3).getMaLop()));
         
    }   
}