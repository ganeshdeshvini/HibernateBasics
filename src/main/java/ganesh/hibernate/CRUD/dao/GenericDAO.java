package ganesh.hibernate.CRUD.dao;

import java.util.List;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;

public class GenericDAO<T> implements DAOContract<T> {
    private Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T save(T entity) {
        runWithinTransaction((session) -> {
            session.save(entity);
        });
        return entity;
    }

    public void update(String query) {
        runWithinTransaction((session) -> {
            int nosUpdated = session.createQuery(query).executeUpdate();
            System.out.println("No of rows updated: " + nosUpdated);
        });
    }

    public void delete(T entity) {
        runWithinTransaction((session) -> {
            session.delete(entity);
        });
    }

    public T findOne(int id) {
        return (T) runWithinTransaction((session) -> {
            return session.get(clazz, id);
        });
    }

    public List<T> findAll(String query) {
        return (List<T>) runWithinTransaction((session) -> {
            return session.createQuery(query).getResultList();
        });
    }

    public List<T> findAll() {
        return findAll("from Student");
    }
}
