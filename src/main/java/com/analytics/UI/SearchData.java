
package com.analytics.UI;

import static com.fasterxml.classmate.types.ResolvedPrimitiveType.all;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Mo
 */
public class SearchData {
    
    private RestTemplate restTemplate = new RestTemplate();
    
    private String Host="N/A";
    private String Path="";
    
    
    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }
    
    public String tryConnecting(String Host){
        String ResPath="/hello/";
        String ping = restTemplate.getForObject(Host+Path+ResPath, String.class);
        
        return ping;
    }
    
    public String getSource(){
        String ResPath="/get/source/";
        String source = restTemplate.getForObject(Host+Path+ResPath, String.class);
        
        return source;
    }
    
    public String[] getAllCountryList(){
        String ResPath="/country/list/";
        String[] countriesNames = restTemplate.getForObject(Host+Path+ResPath, String[].class);
        
        return countriesNames;
    }
    
    public Country[] getAllCountries(){
        String ResPath="/country/all/";
        Country[] countriesData = restTemplate.getForObject(Host+Path+ResPath, Country[].class);
        
        return countriesData;
    }
    
    public Country getCountry(Request request){
        String ResPath="/country/";
        Country country = restTemplate.getForObject(Host+Path+ResPath, Country.class);
        
        return country;
    }
    
    public Collection<LocalDate> getAllDates(){
        String ResPath="/dates/";
        LocalDate[] dates = restTemplate.getForObject(Host+Path+ResPath, LocalDate[].class);
        Collection<LocalDate> datesAL = Arrays.asList(dates);
        return datesAL;
    }
    
    
    public Data[] getDataByCountry(Request request){
        String ResPath="/country/data/";
        Data[] countryData = restTemplate.postForObject(Host+Path+ResPath,request, Data[].class);
        
        return countryData;
    }
    
    public Data[] getDataFromDateToDate(Request request){
        String ResPath="/country/data/dates/";
        Data[] countryData = restTemplate.postForObject(Host+Path+ResPath,request, Data[].class);
        
        return countryData;
    }
    
    public Data[] getAllDataByDate(Request request){
        String ResPath="/data/date/";
        Data[] countriesData = restTemplate.postForObject(Host+Path+ResPath,request, Data[].class);
        
        return countriesData;
    }
    
    public Data getCountryDataByDate(Request request){
        String ResPath="/country/data/date/";
        Data countryData = restTemplate.postForObject(Host+Path+ResPath,request, Data.class);
        
        return countryData;
    }
    
    public boolean isDateValid(LocalDate date){
        return getAllDates().contains(date);
    }

}
