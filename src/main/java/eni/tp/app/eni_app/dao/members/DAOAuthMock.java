package eni.tp.app.eni_app.dao.members;

import eni.tp.app.eni_app.bo.Member;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Profile("mock")
@Component
public class DAOAuthMock implements IDAOAuth{

    //Deux fauc users
    List<Member> members = Arrays.asList(
            new Member("stephanois.pipi@gi.com","123"),
            new Member("izilife@92i.com","b2o")
    );


    @Override
    public Member login(String email, String password) {
        Member foundMember = members.stream().filter(
                        member -> member.email.equals(email) && member.password.equals(password))
                .findFirst().orElse(null);


        return foundMember;
    }

    @Override
    public List<Member> selectMovie() {
        return List.of();
    }

    @Override
    public List<Member> selectMember() {
        return List.of();
    }

    @Override
    public Member selectMemberById(long id) {
        return null;
    }

    @Override
    public void saveMember(Member member) {

    }

    @Override
    public void deleteById(Member member) {

    }
}
