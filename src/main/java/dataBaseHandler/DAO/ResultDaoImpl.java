package dataBaseHandler.DAO;

import dataBaseHandler.ResultEntity;
import dataBaseHandler.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ResultDaoImpl implements resultDao {

    @Override
    public List<ResultEntity> showAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            // Используем HQL для выборки всех записей из таблицы
            Query<ResultEntity> query = session.createQuery("FROM ResultEntity", ResultEntity.class);
            List<ResultEntity> results = query.list();



            System.out.println("All Results:");
            for (ResultEntity result : results) {
                System.out.println(result);
            }

            tx.commit();
            return results;
        } catch (Exception e) {
            System.err.println("Can't show all");
        }
        return null;
    }

    @Override
    public void save(ResultEntity result) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(result);
            tx.commit();
        } catch (Exception e) {
            System.err.println("can't save this result");
        }
    }

    @Override
    public void delete(ResultEntity result) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(result);

            tx.commit();
        } catch (Exception e) {
            System.err.println("Can't delete the file");;
        }
    }
    @Override
    public void cleanAll(){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Query<?> query = session.createQuery("DELETE FROM ResultEntity");

            query.executeUpdate();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
