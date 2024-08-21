package eni.tp.app.eni_app.bo;

public class Member extends Person {

    public String email;
    public String password;
    public boolean isAdmin;

    public Member(long id, String firstname, String lastname, String email, String password, boolean isAdmin) {
        super(id, firstname, lastname);
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }


}