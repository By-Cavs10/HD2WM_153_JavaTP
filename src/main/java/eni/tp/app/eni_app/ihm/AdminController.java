package eni.tp.app.eni_app.ihm;

import eni.tp.app.eni_app.bll.AuthManager;
import eni.tp.app.eni_app.bll.MemberService;
import eni.tp.app.eni_app.bo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/manage")
    public String manageMembers(Model model) {
        model.addAttribute("members", memberService.getMembers());
        model.addAttribute("member", new Member()); // Pour le formulaire d'ajout
        return "admin/manage";
    }

    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member) {
        memberService.saveMember(member);
        return "redirect:/admin/manage";
    }

    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable Member member) {
        memberService.deleteMember(member);
        return "redirect:/admin/manage";
    }
}