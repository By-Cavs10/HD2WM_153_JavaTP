package eni.tp.app.eni_app.bll;

import eni.tp.app.eni_app.bo.Member;
import eni.tp.app.eni_app.dao.members.IDAOAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MemberService {

//    @Autowired
//    private MemberRepository memberRepository;

    @Autowired
    IDAOAuth daoAuth;

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

    public List<Member> getMembers() {

        //Récupère la couche DAO
        // IDAOAliment daoAliment = FactoryDAO.getDAOAliment();

        //récupérer les aliments de la DAO
        List<Member> members =  daoAuth.selectMember();

        return members;
    }

    public Member getById(long id) {

        Member member = daoAuth.selectMemberById(id);

        return member;
    }

    //Appelera la DAO pour sauvegarder un Aliment
    //@param aliment
    public void saveMember(Member member) {
        daoAuth.saveMember(member);
    }

    public void deleteMember(Member member) {
        daoAuth.deleteById(member);
    }
}
