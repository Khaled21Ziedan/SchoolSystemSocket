package Dao;

import model.SubjectGradeBean;
import util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GradeDao {
    public void addUserGrade(SubjectGradeBean SubjectGrade) throws ClassNotFoundException {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(SubjectGrade);
            transaction.commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    public List<SubjectGradeBean> getAllUsersGrades() {
        Transaction transaction = null;
        List<SubjectGradeBean> subjectGradeBeanList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            subjectGradeBeanList = session.createQuery("from SubjectGradeBean").getResultList();
            transaction.commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return subjectGradeBeanList;
    }

    @SuppressWarnings("unchecked")
    public List<SubjectGradeBean> getStudentGrades(String username) {
        Transaction transaction = null;
        List<SubjectGradeBean> subjectGradeBeanList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            subjectGradeBeanList = (List<SubjectGradeBean>) session.createQuery("FROM SubjectGradeBean S WHERE S.userName = :userName")
                    .setParameter("userName", username).getResultList();
            transaction.commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return subjectGradeBeanList;
    }

    public double average(String subject) {
        Transaction transaction = null;
        double avg;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            avg = (double) session.createQuery("SELECT avg(grade) as avg_grade from SubjectGradeBean S WHERE S.subjectName = :subject")
                    .setParameter("subject", subject).getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return avg;
    }

    public int maxValue(String subject) {
        Transaction transaction = null;
        int maxValue;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            maxValue = (int) session.createQuery("SELECT max(grade) from SubjectGradeBean S WHERE S.subjectName =:subject")
                    .setParameter("subject", subject)
                    .getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return maxValue;
    }
    public int minValue(String subject) {
        Transaction transaction = null;
        int minValue;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            minValue = (int) session.createQuery("SELECT min(grade) from SubjectGradeBean S WHERE S.subjectName=:subject")
                    .setParameter("subject",subject)
                    .getSingleResult();
            transaction.commit();
        }
        catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return minValue;
    }
}
