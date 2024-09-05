package eni.tp.app.eni_app.ihm;

import eni.tp.app.eni_app.bll.AuthManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes({"loggedMember"})
@Controller
public class DemoFormController {


    private final AuthManager authManager;

    public DemoFormController(AuthManager authManager) {
        this.authManager = authManager;
    }


    @GetMapping("login")
    public String login() {
        return "auth/login-page";
    }


//    @GetMapping("login")
//        public String showLoginForm(Model model) {
//
//            //tester si déjà connecté
//            Member loggedMember = (Member) model.getAttribute("loggedMember");
//
//            if(loggedMember != null) {
//                return "auth/account";
//            }
//
//            //Préparer ce que tu vas envoyer dans le formualire par défaut
//           Member member = new Member();
//
//            //Envoyer l'aliment dans le front (dans la réponse)
//            //pour le mettre dans le formulaire
//            model.addAttribute("member", member);
//
//            //Afficher la page formulaire
//            return "auth/login-page";
//        }
//        //traiter les données qui nous serons envoyé
//        //@return


//        @PostMapping("login")
//        public String loginForm(@Valid @ModelAttribute(name ="member") Member member, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
//
//            //1 : Contrôle de Surface
//            if(bindingResult.hasErrors()) {
//                //Retourner la page avec les erreurs de validation ( le format)
//                return "auth/login-page";
//            }
//
//            //Erreur : Si Contrôle de Surface
//            //TODO : Retourner la page avec les erreurs de validation (le format)
//
//
//            //2 : Contrôle Métier (le manager)
//            EniManagerResponse<Member> response = authManager.authenticate(member.email, member.password);
//
//            //Erreur code 756 retourner la page avec l'erreur métier
//            if (response.code.equals("756")){
//                return "auth/account";
//            }
//
//
//
//            //3: Connecter l'user en session
//            //Mettre l'user dans la session
//            model.addAttribute ("loggedMember", member);
//
//
//
//           // EniIHMHelpers.sendCommonFlashMessage(redirectAttributes, EniFlashMessage.TYPE_FLASH_SUCCESS, "Vous êtes connectés !");
//            EniIHMHelpers.sendSuccessFlashMessage(redirectAttributes,   "Vous êtes connectés !");
//
//            return "redirect:/account";
//        }

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
