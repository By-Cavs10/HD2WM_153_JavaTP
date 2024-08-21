package eni.tp.app.eni_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

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
    public String detailsMovies(){

        return "details-movies" ;
    }
    @GetMapping("list-movies")
    public String listMovies(){

        return "list-movies" ;
    }
}

