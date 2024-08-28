package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bll.ArticleManager;
import eni.tp.app.eni_app.bo.Movie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SessionAttributes({"loggedMember"})
@Controller
public class DemoController {

    @Autowired
    ArticleManager articleManager;

    @Autowired
    LocaleResolver localeResolver;

    @GetMapping("change-lang/{lang}")
    public String changeLang (@PathVariable ("lang") String lang, HttpServletRequest request,
                              HttpServletResponse response) {

        //Instancier la clé de la langue
        Locale locale = Locale.forLanguageTag(lang);

        //Appliquer la langue
        localeResolver.setLocale(request, response,locale);

        //rediriger
        return "redirect:/home";
    }

    //cholatine est l'URL soit le html
    @GetMapping("moviestream")
    public String hdfurhrygbc(){


        return "todo" ;
    }

    //Dans l'annotation XXXMaping, le premier paramètre => le nom de l'url
    //exemple "login" =>http://monhost:monport/login
    //donc en localhost avec le port 8080 par défaut (en dev)
    // =>http://localhost:8080/login
    @GetMapping("home")
    public String homeWeb(){

        return "hello-page" ;
    }


    @GetMapping("list-movies")
    public String listMovies(Model model){
        model.addAttribute("movies", articleManager.getMovies());

        //Envoyer la note maximale
        List<Integer> maxStar = Arrays.asList(1, 2, 3, 4, 5);
        model.addAttribute("maxStars", maxStar);
        return "list-movies" ;
    }

    @GetMapping("details-movies/{id}")

    public String showArticle(@PathVariable("id")long id, Model model){
        //Récupérer l'aliment via le manager avec omme paramètre l'id provenant de la requête (URL)
        Movie movie = articleManager.getById(id);

        if(movie == null){
            //Afficher la page erreur qui s'appelle aliment-not-found
            return "movie-not-found" ;
        }

        //Envoyer l'aliment trouvé dans la vue (dans le modèle)
        model.addAttribute("movie", movie);

        //Afficher la page detail aliment
        return "details-movies" ;



    }
}

