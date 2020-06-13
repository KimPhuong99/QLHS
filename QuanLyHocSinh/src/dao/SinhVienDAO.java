package dao;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
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
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
