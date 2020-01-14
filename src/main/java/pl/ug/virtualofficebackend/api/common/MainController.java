package pl.ug.virtualofficebackend.api.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }

}
