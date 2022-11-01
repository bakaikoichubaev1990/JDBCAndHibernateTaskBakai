package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.model.User;
import peaksoft.util.HibernateUtil;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }

    private static SessionFactory sessionFactory = HibernateUtil.createsessionFactory();
   // private static EntityManagerFactory entityManagerFactory = HibernateUtil.createEntityManagerFactory();

    @Override
    public void createUsersTable() {

        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.createSQLQuery(
                    "create TABLE if not exists users(" +
                            "id serial primary key ," +
                            " name varchar(50) not null, " +
                            " lastname varchar(50) not null, " +
                            " age smallint not null);").executeUpdate();

            session.getTransaction().commit();
            session.close();
            System.out.println("Table tuzuldu");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void dropUsersTable() {

        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.createNativeQuery("drop table if exists users;").executeUpdate();

            System.out.println("Table drop successfully");

            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(new User(name, lastName, age));

            System.out.println("user with name " + name + "saved successfully");

            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void removeUserById(long id) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<User> getAllUsers() {

        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<User> users = session.createQuery("select u from User u").getResultList();
            session.getTransaction().commit();
            session.close();
            return users;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    @Override
    public void cleanUsersTable() {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.createNativeQuery("truncate table users").executeUpdate();

            System.out.println("Table truncate successfully");

            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }


    }
}
