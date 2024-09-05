package eni.tp.app.eni_app.dao.roles;

import eni.tp.app.eni_app.bo.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IDAORoles {


    Role login(String role, Integer isAdmin);


    Role mapRow(ResultSet rs, int rowNum);

    List<Role> selectRole();



    void saveRole(Role role);

    void deleteById(Role Role);

    Role selectRoleById(long id);
}


