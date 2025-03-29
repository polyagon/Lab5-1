package org.example.MyCollection.Data;

import org.example.MyTools.Validators.GreaterThen;
import org.example.MyTools.Validators.NotEmptyString;
import org.example.MyTools.Validators.NotNull;
import org.example.MyTools.Validators.StringSize;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Supplier;

public class Person extends Entity implements Cloneable, Comparable{
    @NotNull
    @NotEmptyString
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле может быть null
    @NotNull
    @GreaterThen("0")
    private Float height; //Поле не может быть null, Значение поля должно быть больше 0
    @NotNull
    @GreaterThen("0")
    private Float weight; //Поле не может быть null, Значение поля должно быть больше 0
    @StringSize("37")
    private String passportID; //Длина строки не должна быть больше 37, Поле может быть null


    public Person(String name, java.util.Date birthday, Float height, Float weight, String passportID){
            setName(name);
            setBirthday(birthday);
            setHeight(height);
            setWeight(weight);
            setPassportID(passportID);
    }

    public Person() {

    }


    //public setPerson()


    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


    public java.util.Date getBirthday(){
        return this.birthday;
    }
    public void setBirthday(java.util.Date birthday){
        this.birthday = birthday;
    }


    public Float getHeight(){
        return this.height;
    }
    public void setHeight(Float height){
        this.height = height;
    }


    public Float getWeight(){
        return this.weight;
    }
    public void setWeight(Float weight){
        this.weight = weight;
    }


    public String getPassportID(){
        return this.passportID;
    }
    public void setPassportID(String passportID){
        this.passportID = passportID;
    }


    public String generateCSV() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String out = name +
                ", " + sdf.format(birthday) +
                ", " + height +
                ", " + weight +
                ", " + passportID;

        return out;
    }



    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, height, weight, passportID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person check = (Person) o;
        return hashCode() == check.hashCode();
    }
    @Override
    public String toString(){
        String out = "Person(" +
                "\n\tname=" + name +
                "\n\tbirthday=" + birthday+
                "\n\theight=" + height +
                "\n\tweight=" + weight +
                "\n\tpassport ID=" + passportID;
        return  out + ");\n";
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) return 0;
        if (((Person)o).height > this.height) return 1;
        else return -1;
    }


    @Override
    public void init(HashMap<String, Object> values) {
        this.name = (String) values.get("name");
        this.birthday = (java.util.Date) values.get("birthday");
        this.height = (Float) values.get("height");
        this.weight = (Float) values.get("weight");
        this.passportID = (String) values.get("passportID");
    }

    @Override
    public HashMap<String, Object> getValues() {
        HashMap<String, Object> values = new HashMap<>();
        values.put("name", name);
        values.put("birthday", birthday);
        values.put("height", height);
        values.put("weight", weight);
        values.put("passportID", passportID);
        return values;
    }

    public Supplier<Entity> getConstructorReference() {
        return Person::new;
    }




}
