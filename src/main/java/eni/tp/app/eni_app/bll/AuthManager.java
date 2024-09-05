package eni.tp.app.eni_app.bll;

import eni.tp.app.eni_app.bo.Member;
import eni.tp.app.eni_app.dao.members.IDAOAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager {

    @Autowired
    IDAOAuth daoAuth;

    public EniManagerResponse<Member> authenticate( String email,  String password) {

        //On essaye de trouver le membe qui a l'email et le password envoyés
        Member foundMember = daoAuth.login( email, password );


        //Si couple email/mot de passe incorrect Erreur code 756
        if ( foundMember == null ) {
            return EniManagerResponse.performResponse("756", "Couple email/mot de passe incorrect", null);
        }

        //Sinon code 200
        return EniManagerResponse.performResponse("200", "Vous êtes connecté(e)s avec succès", null);
    }

}
