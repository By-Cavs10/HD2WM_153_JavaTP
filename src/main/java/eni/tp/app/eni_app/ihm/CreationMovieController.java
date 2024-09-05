package eni.tp.app.eni_app.ihm;

import eni.tp.app.eni_app.bll.ArticleManager;
import eni.tp.app.eni_app.bll.IGenreManager;
import eni.tp.app.eni_app.bo.Genre;
import eni.tp.app.eni_app.bo.Movie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@SessionAttributes({"loggedMember"})
@Controller
public class CreationMovieController {

    @Autowired
    IGenreManager genreManager;

    @Autowired
    ArticleManager articleManager;

    //Soit je vais dans la page formulaire avec un id (donc edition)
    //Soit je vais dans la page formulaire sans id ( donc création)
    //@param model
    //@return

    @GetMapping({"creation/{id}", "creation"})
    public String showCreationForm(@PathVariable(required = false) Long id, Model model) {

        //tester si déjà connecté
//        Member loggedMember = (Member) model.getAttribute("loggedMember");
//
//        if (loggedMember == null) {
//            return "redirect:/login";
//        }

        //Préparer ce que tu vas envoyer dans le formualire par défaut
        Movie movie = new Movie();

        // Si y'a un id, le film on le récupère grace à l'id
        // PS: On écrase le film vide qu'on voulait afficher dans le form
        // Donc on affichera un film existant dans le formulaire
        if (id != null) {
            movie = articleManager.getById(id);
        }


        //Envoyer l'aliment dans le front (dans la réponse)
        //pour le mettre dans le formulaire
        model.addAttribute("movie", movie);

        //Envoyer les catégories à la vue pour les afficher dans la liste déroulante
        List<Genre> genres = genreManager.getGenres();
        model.addAttribute("genres", genres);

        //Afficher la page formulaire
        return "creation";
    }
    //traiter les données qui nous serons envoyé
    //@return


    @PostMapping("creation")
    public String creationForm(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        System.out.println("voici le film :" + movie);

        //Obectif tester la validité de la donnée (ontrôle de surface)
        if (bindingResult.hasErrors()) {
            System.out.println("Erreur de contrôle surface");
            return "/creation";
        }

        //Todo : on sauvegarde l'aliment dans la BDD

        articleManager.saveMovie(movie);

        System.out.println(String.format("Le film %s a été sauvegardé", movie.title));

        model.addAttribute("createdMovie", movie);


        // EniIHMHelpers.sendCommonFlashMessage(redirectAttributes, EniFlashMessage.TYPE_FLASH_SUCCESS, "Vous êtes connectés !");
        EniIHMHelpers.sendSuccessFlashMessage(redirectAttributes, "votre film a bien été créé !");

        return "redirect:/list-movies";
    }


}
