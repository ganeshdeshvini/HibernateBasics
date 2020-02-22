package ganesh.hibernate.CRUD.dao;

import java.util.List;

public interface DAOContract<T> {
	T save(T entity);

	void update(String query);

	void delete(T entity);

	T findOne(int id);

	List<T> findAll();

	List<T> findAll(String query);
}
