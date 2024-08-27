package eni.tp.app.eni_app.ihm;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class EniIHMHelpers {

    public static void sendCommonFlashMessage(RedirectAttributes redirectAttributes, int type, String message) {

        redirectAttributes.addFlashAttribute("flashMessage",
                new EniFlashMessage(type, message));
    }
//Version plus courte
    public static void sendSuccessFlashMessage(RedirectAttributes redirectAttributes, String message) {

        EniIHMHelpers.sendCommonFlashMessage(redirectAttributes, EniFlashMessage.TYPE_FLASH_SUCCESS, message);
    }
}
