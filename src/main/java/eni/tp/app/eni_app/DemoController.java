package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bll.ArticleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Controller
public class DemoController {

    @Autowired
    ArticleManager articleManager;

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
    @GetMapping("details-movies")
    public String detailsMovies(Model model){

        model.addAttribute("movies", articleManager.getMovies());

        return "details-movies" ;
    }
    @GetMapping("list-movies")
    public String listMovies(Model model){
        model.addAttribute("movies", articleManager.getMovies());

        //Envoyer la note maximale
        List<Integer> maxStar = Arrays.asList(1, 2, 3, 4, 5);
        model.addAttribute("maxStars", maxStar);
        return "list-movies" ;
    }
}

