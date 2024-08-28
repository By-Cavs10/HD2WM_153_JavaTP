package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bll.ArticleManager;
import eni.tp.app.eni_app.bo.Member;
import eni.tp.app.eni_app.bo.Movie;
import eni.tp.app.eni_app.ihm.EniIHMHelpers;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes({"loggedMember"})
@Controller
public class CreationMovieController {


    @Autowired
    ArticleManager articleManager;


        @GetMapping("creation")
        public String showCreationForm(Model model) {

            //tester si déjà connecté
            Member loggedMember = (Member) model.getAttribute("loggedMember");

            if(loggedMember == null) {
                return "redirect:/login";
            }

            //Préparer ce que tu vas envoyer dans le formualire par défaut
            Movie movie = new Movie();

            //Envoyer l'aliment dans le front (dans la réponse)
            //pour le mettre dans le formulaire
            model.addAttribute("movie", movie);

            //Afficher la page formulaire
            return "creation";
        }
        //traiter les données qui nous serons envoyé
        //@return


        @PostMapping("creation")
        public String creationForm(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

            //Obectif tester la validité de la donnée (ontrôle de surface)
            if(bindingResult.hasErrors()){
                System.out.println("Erreur de contrôle surface");
                  return "/creation";
            }

            //Todo : on sauvegarde l'aliment dans la BDD

            articleManager.saveMovie(movie);

            System.out.println(String.format("Le film %s a été sauvegardé", movie.title));

            model.addAttribute ("createdMovie", movie);



            // EniIHMHelpers.sendCommonFlashMessage(redirectAttributes, EniFlashMessage.TYPE_FLASH_SUCCESS, "Vous êtes connectés !");
            EniIHMHelpers.sendSuccessFlashMessage(redirectAttributes,   "votre film a bien été créé !");

            return "redirect:/list-movies";
        }




}
