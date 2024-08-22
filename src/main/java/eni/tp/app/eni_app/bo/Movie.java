package eni.tp.app.eni_app.bo;

public class Movie {

    public long id;
    public String title;
    public int year;
    public int duration;
    public String synopsis;
    public int note = 2;
    public String photo;

    public Movie(long id, String title, int year, int duration, String synopsis, String photo) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.photo = photo;
    }

    public int getNote() {
        //Plus tatd quand on va supprimer le int note
        //La note sera la moyenne des avis
        return note;
    }
}

