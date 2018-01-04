import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.SourceType;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class main {
    public static void main(String[] args) {
         Alien a1 = new Alien();

        a1.setAname("BBB");
        a1.setColor("white");

        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        ServiceRegistry service = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(service);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
                session.save(a1);
                tx.commit();
        System.out.println();
    }

}
