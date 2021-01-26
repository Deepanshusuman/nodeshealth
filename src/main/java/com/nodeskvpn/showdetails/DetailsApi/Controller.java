package com.nodeskvpn.showdetails.DetailsApi;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class Controller implements ErrorController {

    @RequestMapping("/")
    public Data index() {
        Data data = new Data();

        try {
            data.setCpu(new Usage().getCpu().trim());
            data.setSpeed(new Usage().getSpeed().trim());
        } catch (Exception e) {
            data.setCpu(null);
            data.setSpeed(null);
        }
        return data;
    }

    @RequestMapping("/error")
    public ModelAndView error() {
        return new ModelAndView("redirect:/");
    }
}
