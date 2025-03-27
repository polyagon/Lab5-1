package org.example.MyCollection.DataClasses;

import org.example.MyCollection.Exceptions.InvalidFieldValue;

public class ISBNmark {
    private String prefix;
    private String country_code;
    private String publishing_code;
    private String control_count;


    public String get_prefix(){
        return prefix;
    }

    public String getCountry_code(){
        return country_code;
    }

    public String getPublishing_code(){
        return publishing_code;
    }

    public String getControl_count(){
        return control_count;
    }

    public void setPrefix(String x) throws InvalidFieldValue{
        if(x.length() != 3){
            throw new InvalidFieldValue("ISBN", x);
        }
        this.prefix = x;
    }

    public void setControl_count(String control_count) throws InvalidFieldValue {
        if(control_count.length() != 1){
            throw new InvalidFieldValue("ISBN", control_count);
        }
        this.control_count = control_count;
    }

    public void setPublishing_code(String publishing_code) throws InvalidFieldValue {
        if(control_count.length() != 5){
            throw new InvalidFieldValue("ISBN", publishing_code);
        }
        this.publishing_code = publishing_code;
    }

    public void setCountry_code(String country_code) throws InvalidFieldValue {
        if(country_code.length() != 1){
            throw new InvalidFieldValue("ISBN", country_code);
        }
        this.country_code = country_code;
    }

    public String getISBN(){
        return prefix + "-" + country_code + "-" + publishing_code + "-" + control_count;
    }


}
