package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bll.ArticleManager;
import eni.tp.app.eni_app.bo.Member;
import eni.tp.app.eni_app.ihm.EniFlashMessage;
import eni.tp.app.eni_app.ihm.EniIHMHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes({"loggedMember"})
@Controller
public class DemoFormController {



        @GetMapping("login")
        public String showLoginForm(Model model) {

            //tester si déjà connecté
            Member loggedMember = (Member) model.getAttribute("loggedMember");

            if(loggedMember != null) {
                return "auth/account";
            }

            //Préparer ce que tu vas envoyer dans le formualire par défaut
           Member member = new Member();

            //Envoyer l'aliment dans le front (dans la réponse)
            //pour le mettre dans le formulaire
            model.addAttribute("member", member);

            //Afficher la page formulaire
            return "auth/login-page";
        }
        //traiter les données qui nous serons envoyé
        //@return


        @PostMapping("login")
        public String loginForm(@ModelAttribute("member") Member member, Model model, RedirectAttributes redirectAttributes) {

            model.addAttribute ("loggedMember", member);



           // EniIHMHelpers.sendCommonFlashMessage(redirectAttributes, EniFlashMessage.TYPE_FLASH_SUCCESS, "Vous êtes connectés !");
            EniIHMHelpers.sendSuccessFlashMessage(redirectAttributes,   "Vous êtes connectés !");

            return "redirect:/account";
        }

        @GetMapping("account")

    public String showAccount() {
            return "auth/account";
        }

        @GetMapping("logout")
    public String logout(SessionStatus sessionStatus) {
            //nettoyer la session (se déconnecter)
            sessionStatus.setComplete();

            //rediriger à la page d'acceuil
            return "redirect:/home";
        }
}
