package com.msi.panel.controller;


import com.msi.panel.entity.Customer;
import com.msi.panel.entity.Oplaty;
import com.msi.panel.entity.Order;
import com.msi.panel.entity.User;
import com.msi.panel.service.Cust_Service_Implem;
import com.msi.panel.service.OplatyServiceImplem;
import com.msi.panel.service.Order_Service_Implem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Controller
public class WebControler {

    Cust_Service_Implem cust_service_implem;
    Order_Service_Implem order_service_implem;

    @Autowired
    OplatyServiceImplem oplatyServiceImplem;



    /*
    ****************************************
     */


/*

OPLATYYY




 */

    @RequestMapping(value = "/api/oplaty")
    public ModelAndView oplaty(Model model, ModelAndView modelAndView){
        List<Oplaty> oplatyList = oplatyServiceImplem.showOplaty();
        model.addAttribute("oplaty", oplatyList);
        modelAndView.setViewName("oplaty");
        return modelAndView;
    }

    @RequestMapping(value = "/Tracker")
    public ModelAndView Tracker(Model model, ModelAndView modelAndView){
        List<Oplaty> oplatyList = oplatyServiceImplem.showOplaty();
        model.addAttribute("oplaty", oplatyList);
        modelAndView.setViewName("Tracker");
        return modelAndView;
    }

    @GetMapping (value = "/DodajOplaty")
    public ModelAndView DodajOplaty(ModelAndView modelAndView){
        modelAndView.setViewName("DodajOplaty");
        return modelAndView;
    }


    @RequestMapping(value = "/DodajOplaty", method = RequestMethod.POST)
    public ModelAndView DodajOplatyPost(ModelAndView modelAndView,
                                        @RequestParam("Miesiac") int miesiac,
                                        @RequestParam("Rok") int rok,
                                        @RequestParam("Prad") int prad,
                                        @RequestParam("Gaz") int gaz,
                                        @RequestParam("Rata") int rata,
                                        @RequestParam("Internet") int internet,
                                        @RequestParam("Inne") int inne){
       Oplaty noweOplaty = oplatyServiceImplem.createOplaty(miesiac, rok, gaz, prad, internet, rata, inne);
       oplatyServiceImplem.saveOplaty(noweOplaty);
        modelAndView.setViewName("redirect:/api/oplaty");
        return modelAndView;

    }








    /*
Site Login
 */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
