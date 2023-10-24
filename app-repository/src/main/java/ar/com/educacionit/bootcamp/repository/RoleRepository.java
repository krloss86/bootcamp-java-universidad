package ar.com.educacionit.bootcamp.repository;

import java.util.List;

import ar.com.educacionit.bootcamp.Rol;

public interface RoleRepository extends BaseRepository<Rol> {
	public List<Rol> findByUserId(Long id);
}
