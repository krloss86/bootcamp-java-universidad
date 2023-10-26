package ar.com.educacionit.bootcamp.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.bootcamp.Rol;

public class RoleRepositoryImpl extends BaseCrud<Rol> implements RoleRepository {

	public RoleRepositoryImpl() {
		super(Rol.class, "ROL");
	}

	@Override
	public List<Rol> findByUserId(Long id) {
		String sql = "SELECT R.* FROM\r\n"
				+ "USER U INNER JOIN USERS_ROLES UR \r\n"
				+ "	ON U.ID = UR.user_id\r\n"
				+ "INNER JOIN ROL R 	\r\n"
				+ "	ON R.ID = UR.rol_id\r\n"
				+ "WHERE U.ID = " + id;
		return super.findBySQL(sql);
	}

	@Override
	protected Rol fromResultSetToEntity(ResultSet res) throws SQLException {
		Long id = res.getLong(1);
		String role = res.getString(2);
		
		return new Rol(id, role);
	}

	@Override
	protected String getSaveSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void saveEntity(Rol entidad, PreparedStatement pst) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getUpdateSQL() {		
		return "role = ?";
	}

	@Override
	protected void setUpdateSQL(Rol entity, PreparedStatement pst) throws SQLException {
		pst.setString(1, entity.getRole());		
	}

}
