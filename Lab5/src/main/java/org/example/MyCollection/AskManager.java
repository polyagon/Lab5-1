package org.example.MyCollection;

import org.example.MyCollection.Data.Coordinates;
import org.example.MyCollection.Data.Difficulty;
import org.example.MyCollection.Data.LabWork;
import org.example.MyCollection.Data.Person;
import org.example.MyCommands.Excaption.InvalidFieldValue;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;
import org.example.MyTools.Converter;
import org.example.MyTools.Validators.GreaterThen;
import org.example.MyTools.Validators.Validatable;
import org.example.MyTools.Validators.ValidatableAnnotation;
import org.example.MyTools.Validators.ValidatableWithArgs;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

public class AskManager {

    InputHandler input;
    OutputHandler output;
    CollectionManager collection;
    LabWork oldElem = null;

    public AskManager(InputHandler input, OutputHandler output, CollectionManager collection){
        this.input = input;
        this.output = output;
        this.collection = collection;
    }

    /*private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Person author; //Поле не может быть null

    private Double x; //Поле не может быть null
    private Long y; //Поле не может быть null

      private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле может быть null
    private Float height; //Поле не может быть null, Значение поля должно быть больше 0
    private Float weight; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 37, Поле может быть null*/


    public LabWork buildDialogue(LabWork oldElem) throws InvalidFieldValue {
        this.oldElem = oldElem;
        return buildDialogue();
    }
    public LabWork buildDialogue() throws InvalidFieldValue {
        String name = null;
        if(oldElem !=null){
            try {
                if(!askForSkip("name", oldElem.getName())){
                    name = askName();
                }else name = oldElem.getName();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else name = askName();

        Coordinates coordinates = askCoordinates();


        int minimalPoint = 0;
        if(oldElem != null){
            try {
                if(!askForSkip("minimalPoint", oldElem.getMinimalPoint().toString())) minimalPoint = askMinimalPoint();
                else minimalPoint = oldElem.getMinimalPoint();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else minimalPoint = askMinimalPoint();

        Difficulty diff = null;
        if(oldElem != null){
            try {
                if(!askForSkip("difficulty", oldElem.getDifficulty().toString())) diff = askDifficulty();
                else diff = oldElem.getDifficulty();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else diff = askDifficulty();


        Person author = askPerson();


        LabWork lab = null;
        try {
            lab = new LabWork( name, coordinates, minimalPoint, diff, author);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lab;

    }

    public Coordinates askCoordinates() throws InvalidFieldValue{
        output.println("Сектор Coordinates");
        double corx = 0;
        long cory = 0;

        if(oldElem != null){
            try {
                if(!askForSkip("x", Double.toString(oldElem.getCoordinates().getX()))) corx = askXCoordinate();
                else corx = oldElem.getCoordinates().getX();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else corx = askXCoordinate();

        if(oldElem != null){
            try {
                if(!askForSkip("y", Long.toString(oldElem.getCoordinates().getY()))) cory = askYCoordinate();
                else cory = oldElem.getCoordinates().getY();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else cory = askYCoordinate();

        Coordinates ans = null;
        try {
            ans = new Coordinates(corx, cory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ans;

    }

    public Person askPerson(){
       /* private String name; //Поле не может быть null, Строка не может быть пустой
        private java.util.Date birthday; //Поле может быть null
        private Float height; //Поле не может быть null, Значение поля должно быть больше 0
        private Float weight; //Поле не может быть null, Значение поля должно быть больше 0
        private String passportID; //Длина строки не должна быть больше 37, Поле может быть null*/

        output.println("Сектор Author");
        String name = null;
        java.util.Date birthday = null;
        float height = 0;
        float weight = 0;
        String passportID = "";


        if(oldElem != null){
            try {
                if(!askForSkip("name", oldElem.getAuthor().getName())) name = askName();
                else name = oldElem.getAuthor().getName();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else name = askName();

        if(oldElem != null){
            try {
                if(!askForSkip("birthday", String.valueOf(oldElem.getAuthor().getBirthday()))) birthday = askBirthday();
                else birthday = oldElem.getAuthor().getBirthday();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else birthday = askBirthday();


        if(oldElem != null){
            try {
                if(!askForSkip("height", Float.toString(oldElem.getAuthor().getHeight()))) height = askHeight();
                else height = oldElem.getAuthor().getHeight();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else height = askHeight();

        if(oldElem != null){
            try {
                if(!askForSkip("weight", Float.toString(oldElem.getAuthor().getHeight()))) weight = askWeight();
                else weight = oldElem.getAuthor().getWeight();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else weight = askWeight();

        if(oldElem != null){
            try {
                if(!askForSkip("passportID", oldElem.getAuthor().getPassportID())) passportID = askPassportID();
                else passportID = oldElem.getAuthor().getPassportID();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else passportID = askPassportID();

        Person ans = null;
        ans = new Person(name, birthday, height, weight, passportID);
        return ans;
    }


    private java.util.Date askBirthday(){
        output.println("Введите день рождения");
        output.println("Год рождения:");
        int year = 0;
        int month = 0;
        int day = 0;
        try {

            year =  Integer.parseInt(input.get());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            while (true){
                month = Integer.parseInt(input.get());
                if (month > 0 && month <13) break;
                else output.println("Неправильный номер месяца, введите еще раз");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        output.println("День:");
        try {
            day = Integer.parseInt(input.get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);  // Месяц начинается с 0, поэтому month - 1
        java.util.Date ans = calendar.getTime();
        return ans;
    }

    private long askXCoordinate(){
        output.println("Введите координату x");

        try {
            return Long.parseLong(input.get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long askYCoordinate(){
        output.println("Введите координату y");


        try {
            return Long.parseLong(input.get());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private boolean askForSkip(String name, String value) throws IOException {
        String ans;
        output.println("Cтарое значение поля " + name + " : " + value + ". Ввести новое значение? (Y/N)");
        while (true){
            try {
                ans = input.get().trim().toUpperCase();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(ans.equals("N") || ans.equals("Y")) break;
            else {
                output.printErr(ans + " не похоже на Y/N , попробуйте еще раз");
            }
        }
        return !ans.equals("Y");
    }


    public String askName(){
        output.println("Введите название лабы: ");
        try {
            while (true){
                String str = input.get();
                if(!str.isBlank() && str != null){
                    return str;
                }else output.println("Название не должно быть пустой строкой, введите еще раз ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer askMinimalPoint(){
        output.println("Введите минимальный балл: ");
        try {
            while (true){
                String str = input.get();
                if(str != null && Integer.parseInt(str) >= 0){
                    return Integer.parseInt(str);
                }else output.println("Балл не должен быть меньше 0, введите еще раз ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Float askHeight(){
        output.println("Введите рост студента: ");
        try {
            while (true){
                String str = input.get();
                if(str != null && Float.parseFloat(str) >= 0){
                    return Float.parseFloat(str);
                }else output.println("Рост не должен быть меньше 0, введите еще раз ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Float askWeight(){
        output.println("Введите вес студента: ");
        try {
            while (true){
                String str = input.get();
                if(str != null && Float.parseFloat(str) >= 0){
                    return Float.parseFloat(str);
                }else output.println("Рост не должен быть меньше 0, введите еще раз ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String askPassportID(){
        output.println("Введите номер паспорта студента: ");
        try {
            while (true){
                String str = input.get();
                if(str != null && str.length() <= 37){
                    return str;
                }else output.println("Номер паспорта в длину не больше 37 символов, введите еще раз ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> String getEnumValues(Class<T> type){
        StringBuilder sb = new StringBuilder("Возможные значения : ");
        for(T i : type.getEnumConstants()){
            sb.append(i +", ");
        }
        return sb.toString();
    }
    public <T> boolean checkEnum(String str, Class<T> type){
        HashSet<String> EnumSet = new HashSet<>();
        for(T i : type.getEnumConstants()){
            EnumSet.add(i.toString());
        }
        if(EnumSet.contains(str)) return true;
        else return false;
    }

    public Difficulty askDifficulty(){
        output.println("Введите сложность лабы");
        output.println(getEnumValues(Difficulty.class));
        while (true){
            try{
                String inp = input.get();
                if(!checkEnum(inp, Difficulty.class)) output.println("Неправильная константа! Введите еще раз ");
                else return Difficulty.valueOf(inp);
            } catch (IOException e) {
                throw new RuntimeException(e);            }
        }
    }




}
