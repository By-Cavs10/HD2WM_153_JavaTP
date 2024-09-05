package eni.tp.app.eni_app.dao.members;

import eni.tp.app.eni_app.bo.Member;

import java.util.List;


public interface IDAOAuth {


    /**
     * Permettera de récupérer un utilisateur dans les données
     * @param email
     * @param password
     * @return
     */

    Member login (String email, String password);

    List<Member> selectMovie();

    List<Member> selectMember();

    Member selectMemberById(long id);

    void saveMember(Member member);

    void deleteById(Member member);
}
