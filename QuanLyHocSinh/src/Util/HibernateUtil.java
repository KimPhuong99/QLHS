package Util; 
import javax.imageio.spi.ServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
       try {
       sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
           System.err.println("Initial SessionFactorycreation failed." + ex);
           throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
    return sessionFactory;
    }
}
