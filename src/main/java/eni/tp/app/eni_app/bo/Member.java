package eni.tp.app.eni_app.bo;

public class Member extends Person {

    public String email;
    public String password;
    public boolean isAdmin;


    public Member (){}


    public Member(long id, String firstname, String lastname, String email, String password) {
        super(id, firstname, lastname);
        this.email = email;
        this.password = password;
    }

    public Member(long id, String firstname, String lastname, String email, String password, boolean isAdmin) {
        super(id, firstname, lastname);
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}