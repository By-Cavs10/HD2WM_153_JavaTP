package eni.tp.app.eni_app.bo;

public abstract class Person {

    public long id;
    public String firstname;
    public String lastname;

    public Person(long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
