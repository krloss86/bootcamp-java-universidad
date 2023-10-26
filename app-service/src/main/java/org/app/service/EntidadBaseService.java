package org.app.service;

import java.util.Collection;

public interface EntidadBaseService<T> {
	public Collection<T> buscarTodos();
	public T buscarPoId(Long id);
	public void eliminarPorId(Long id);
	public void guardar(T entity);
	void actualizar(T newUser);
}
