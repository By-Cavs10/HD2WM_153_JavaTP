package eni.tp.app.eni_app.bo;

import jakarta.validation.constraints.*;

public class Movie {

    public long id;

    @NotBlank(message = "Le titre doit être renseigné")
    public String title;

    @NotNull(message = "l'année doit être renseigné")
    @Min(value = 1000, message = "Le format de l'année doit être : YYYY")
    public int year;

    @NotNull(message = "la durée doit être renseigné")
    @Min(1)
    @Max( value = 999, message = "durée erronée")
    public int duration;

    public String synopsis;
    public int note = 2;
    public String photo;


    public Movie(){}

    public Movie(long id, String title, int year, int duration, String synopsis, String photo) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.photo = photo;
    }

    public Movie(String title, int year, int duration, String synopsis, String photo) {
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

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getPhoto() {
        return photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

