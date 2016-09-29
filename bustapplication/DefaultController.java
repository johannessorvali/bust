package wad.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import wad.domain.Arrest;

import wad.repository.ArrestRepository;


@Controller
public class DefaultController {
    
    @Autowired
    private ArrestRepository arrestRepository;
    
    private double cocainetotal = 0;
    
    private double methtotal = 0;
    
    private double amphetaminetotal = 0;
    
    private double herointotal = 0;
    
    private double lsdtotal = 0;
    
    private double ecstacytotal = 0;
    
    private double othertotal = 0;
    
    private double marijuanatotal = 0;
    
    
    /*
    @RequestMapping("/")
    public String handleDefault() {
        return "menu";
    }
    */
    
    
    @PostConstruct
    public void init() throws ParseException {
        
        Arrest arrest1 = new Arrest();
        
        
        
        
        arrest1.setCopName("Harry Callahan");
        arrest1.setCriminalName("Peblo Escabor");
        arrest1.setDrugName("cocaine");
        arrest1.setAmount(34.5);
        this.cocainetotal += 34.5;
        arrestRepository.save(arrest1);
        
       
        
        Arrest arrest2 = new Arrest();
        arrest2.setCopName("Clint Westwood");
        arrest2.setCriminalName("Tomothy Larry");
        arrest2.setDrugName("lsd");
        arrest2.setAmount(0.12);
        this.lsdtotal += 0.12;
        arrestRepository.save(arrest2);
        
        
        
        
        Arrest arrest3 = new Arrest();
        arrest3.setCopName("Brace Wollis");
        arrest3.setCriminalName("Bab Morley");
        arrest3.setDrugName("marijuana");
        arrest3.setAmount(4.5);
        this.marijuanatotal += 4.5;
        arrestRepository.save(arrest3);
        
        Arrest arrest4 = new Arrest();
        arrest4.setCopName("Phillip Morliwe");
        arrest4.setCriminalName("Snape Dagg");
        arrest4.setDrugName("marijuana");
        arrest4.setAmount(34.8);
        this.marijuanatotal += 34.8;
        arrestRepository.save(arrest4);

        
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("arrests", arrestRepository.findAll());
        return "arrests";
    }
    
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String post(@RequestParam String arrestDate, @RequestParam String copName, @RequestParam String criminalName, 
            @RequestParam String drugName, @RequestParam Double amount) throws ParseException {
        
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(arrestDate);
        
        
            Arrest arrest = new Arrest();
            arrest.setArrestDate(date);
            arrest.setCopName(copName);
            arrest.setCriminalName(criminalName);
            arrest.setDrugName(drugName);
            arrest.setAmount(amount);
            
            
            
            arrestRepository.save(arrest);
            
            
            if (drugName.equals("cocaine")) {
                this.cocainetotal = this.cocainetotal + amount;
            }
            if (drugName.equals("methamphetamine")) {
                this.methtotal = this.methtotal + amount;
            }
            if (drugName.equals("amphetamine")) {
                this.amphetaminetotal = this.amphetaminetotal + amount;
            }
            if (drugName.equals("heroin")) {
                this.herointotal = this.herointotal + amount;
            }
            if (drugName.equals("lsd")) {
                this.lsdtotal = this.lsdtotal + amount;
            }
            if (drugName.equals("ecstacy")) {
                this.ecstacytotal = this.ecstacytotal + amount;
            }
            if (drugName.equals("marijuana")) {
                this.marijuanatotal = this.marijuanatotal + amount;
            }
            if (drugName.equals("othar")) {
                this.othertotal = this.othertotal + amount;
            }

        return "redirect:/";
    }
    
    
    
    @RequestMapping(value = "/storage", method = RequestMethod.GET)
    public String storage(Model model) {
        
        List<Double> amounts = new ArrayList<>();
        amounts.add(this.cocainetotal);
        amounts.add(this.methtotal);
        amounts.add(this.amphetaminetotal);
        amounts.add(this.herointotal);
        amounts.add(this.lsdtotal);
        amounts.add(this.ecstacytotal);
        amounts.add(this.marijuanatotal);
        amounts.add(this.othertotal);
        
        model.addAttribute("amounts", amounts);
        
        return "storage";
    }
}

