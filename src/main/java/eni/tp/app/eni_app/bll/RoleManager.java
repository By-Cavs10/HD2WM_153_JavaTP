package eni.tp.app.eni_app.bll;

import eni.tp.app.eni_app.bo.Member;
import eni.tp.app.eni_app.bo.Role;
import eni.tp.app.eni_app.dao.members.IDAOAuth;
import eni.tp.app.eni_app.dao.roles.IDAORoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleManager {

    @Autowired
    IDAORoles daoRole;

//    public List<Member> getAllMembers() {
//        return daoAuth.findAll();
//    }
//
//    public void saveMember(Member member) {
//        daoAuth.save(member);
//    }
//
//    public void deleteMember(Long id) {
//        daoAuth.deleteById(id);
//    }

    public List<Role> getRoles() {

        //Récupère la couche DAO
        // IDAOAliment daoAliment = FactoryDAO.getDAOAliment();

        //récupérer les aliments de la DAO
        List<Role> roles =  daoRole.selectRole();

        return roles;
    }

    public Role getById(long id) {

       Role role = daoRole.selectRoleById(id);

        return role;
    }

    //Appelera la DAO pour sauvegarder un Aliment
    //@param aliment
    public void saveRole(Role role) {
        daoRole.saveRole(role);
    }

    public void deleteRole(Role role) {
        daoRole.deleteById(role);
    }
}


