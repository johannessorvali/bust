package wad.domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.Temporal;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TemporalType;


@Entity
public class Arrest {
    
    private String copName;  //The cop that made the arrest
    private String criminalName;    //The criminal arrested for possesstion of drugs
    
    
    private String identifier;
    private String drugName;   
    private double amount;
    
    //@Temporal(TemporalType.TIMESTAMP)
    private Date arrestDate;
    @Id
    private Long id;
    
    
    public Arrest() throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
        
        
        
        this.arrestDate = sdf.parse(sdf.format(new Date()));
        
        
        
        
         
        Random gen = new Random();

        this.id = gen.nextLong(); 
    }
    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    
    
    public Date getArrestDate() {
        return arrestDate;
    }

    public void setArrestDate(Date arrestDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
        
        
        
        this.arrestDate = sdf.parse(sdf.format(arrestDate));
        
        
        
        //this.arrestDate = arrestDate;
    }
    
    public String getCopName() {
        return this.copName;
    }

    public void setCopName(String copName) {
        this.copName = copName;
    }

    public String getCriminalName() {
        return this.criminalName;
    }

    public void setCriminalName(String criminalName) {
        this.criminalName = criminalName;
    }
    
     public String getDrugName() {
        return this.drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
    
     public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
