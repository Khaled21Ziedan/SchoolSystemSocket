package Dao;

import model.InstructorBean;
import util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InstructorDao {
    public void register(InstructorBean instructor) throws ClassNotFoundException {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(instructor);
            transaction.commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isValid(String username, String password) {
        Transaction transaction = null;
        InstructorBean instructorBean = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            instructorBean = (InstructorBean)
                    session.createQuery("From InstructorBean S WHERE S.userName = :userName")
                            .setParameter("userName", username).uniqueResult();
            if (instructorBean != null && instructorBean.getPassword().equals(password)) {
                return true;
            }
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
