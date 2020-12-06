package com.beadando.controller;

import com.beadando.exceptions.*;
import com.beadando.model.Bd;
import com.beadando.model.Rate;
import com.beadando.service.BdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class BdController {
@Autowired
@Qualifier("bdService")
    BdService service;

@ModelAttribute(value = "bd1")
public Bd create(){
    return new Bd();
}



/*public void printAll(){
    System.out.println(service.getEveryBd());
}*/
@GetMapping(value="/bds")
public ModelAndView getBds(Model model){
    ModelAndView mav=new ModelAndView("bdList");
    model.addAttribute("rate",Rate.values());
    mav.addObject("bds",service.getEveryBd());
    return mav;
}

    @GetMapping(value = "/bd/{id}")
    public String getBdById(@PathVariable String id, Model model) throws BdNotFound {
        model.addAttribute("bd",service.getBdById(id));
        return "bdDetails";
    }

    @PostMapping(value="/searchById")
    public ModelAndView searchById(String id) throws BdNotFound {
    Bd result=service.getBdById(id);
    Collection<Bd> resultList=new ArrayList<Bd>();
    resultList.add(result);
    ModelAndView mav=new ModelAndView("bdList");
    mav.addObject("bds",resultList);
    return mav;
    }

    @GetMapping(value = "/addBd")
    public String addBdForm(Model model){
        model.addAttribute("Rate", Rate.values());
        return "bdForm";
    }

    @PostMapping(value = "addBd")
    public String addBd(@ModelAttribute("bd") Bd bd, Model model, BindingResult result){
        try {
            service.addBd(bd);
        } catch (BdAddedBefore bdAddedBefore) {
            bdAddedBefore.printStackTrace();
        }
        if(result.hasErrors()){
            result.getAllErrors();
        }
        return "redirect:bd/"+bd.getId();
    }

    @GetMapping(value = "/modifyBd/{id}")
    public String modifyBdForm(@PathVariable String id,Model model) throws BdNotFound {
        Bd object=service.getBdById(id);
        model.addAttribute("bd2",object);
        model.addAttribute("Rate1",Rate.values());
        //model.addAttribute("bd1",new Bd());
        return "bdModify";
    }

    @PostMapping(value = "/modify")
    public String modifyBd(@ModelAttribute("bd2") Bd bd,Model model){
        try {
            service.updateBd(bd.getId(),bd.getName(),bd.getReleaseDate(),bd.getNumOfDisc(),bd.getRate(),bd.getDistributor());
        } catch (BadDiscNumber badDiscNumber) {
            badDiscNumber.printStackTrace();
        } catch (ReleaseDateBad releaseDateBad) {
            releaseDateBad.printStackTrace();
        } catch (DistributorEmpty distributorEmpty) {
            distributorEmpty.printStackTrace();
        } catch (NameEmpty nameEmpty) {
            nameEmpty.printStackTrace();
        } catch (BdNotFound bdNotFound) {
            bdNotFound.printStackTrace();
        }
        return "redirect:bd/"+bd.getId();
    }


    @GetMapping(value = "/removeBd/{id}")
    public String removeBd(@PathVariable String id) throws BdNotFound {
        service.removeBd(id);
        return "bdList";
    }

    @PostMapping(value="/byRate")
    public ModelAndView getBdByRate(Rate rate){
        ModelAndView mav=new ModelAndView("bdList");
        mav.addObject("bds",service.getEveryBdByRate(rate));
        return mav;
    }
}
