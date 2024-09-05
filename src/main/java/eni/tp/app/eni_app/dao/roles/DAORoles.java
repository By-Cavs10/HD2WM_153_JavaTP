package eni.tp.app.eni_app.dao.roles;

import eni.tp.app.eni_app.bo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DAORoles implements IDAORoles {

    @Override
    public Role login(String role, Integer isAdmin) {
        List<Role> roles = jdbcTemplate.query("SELECT * FROM ROLES WHERE role = ? AND isAdmin = ?", ROLE_ROW_MAPPER, role, isAdmin);
        return roles.isEmpty() ? null : roles.get(0);
    }



    @Override
    public Role mapRow(ResultSet rs, int rowNum) {
        return null;
    }


    @Autowired
    JdbcTemplate jdbcTemplate;

    /*
    Le code qui permet de savoir comment convertir/mapper un résultat en SQL en

    Comment mppaer un résultat SQL en Aliment
     */

    static final RowMapper<Role> ROLE_ROW_MAPPER = new RowMapper<Role>() {

        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role = new Role();

            role.setRole( rs.getString ("role"));
            role.setIsAdmin( rs.getInt ("IS_ADMIN"));


            return role;
        }
    };



    @Override
    public List<Role> selectRole() {

        return jdbcTemplate.query("SELECT * FROM ROLES", ROLE_ROW_MAPPER);

    }


    @Override
    public void saveRole(Role role) {



        //Insérer en base un aliment

        jdbcTemplate.update("INSERT INTO roles SET role,is_admin) VALUES (?,?)", role.getRole(), role.getIsAdmin());



    }

    @Override
    public void deleteById(Role Role) {

    }

    @Override
    public Role selectRoleById(long id) {
        return null;
    }
}
