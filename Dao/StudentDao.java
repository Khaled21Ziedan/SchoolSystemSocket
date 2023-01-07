package Dao;

import model.StudentBean;
import util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {
    public void register(StudentBean student) throws ClassNotFoundException {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isValid(String username, String password) {
        Transaction transaction = null;
        StudentBean studentBean = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            studentBean = (StudentBean)
                    session.createQuery("From StudentBean S WHERE S.userName = :userName")
                            .setParameter("userName", username).uniqueResult();
            if (studentBean != null && studentBean.getPassword().equals(password)) {
                return true;
            }
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}

