package DAO;

import java.util.List;

public interface InterfaceDAO<T> {
	void listarTodos();
	void add(T obj) throws Exception;
	void update(T obj);
	void delete(T obj);
	void getById(int id);
}
