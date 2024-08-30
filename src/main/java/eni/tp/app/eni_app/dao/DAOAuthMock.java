package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Member;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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
}
