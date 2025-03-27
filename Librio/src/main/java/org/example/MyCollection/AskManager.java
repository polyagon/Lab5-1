package org.example.MyCollection;

import org.example.MyCollection.DataClasses.*;
import org.example.MyCollection.Exceptions.InvalidFieldValue;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;
import org.example.Tools.Validators.*;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class AskManager {


    InputHandler input;
    OutputHandler output;
    CollectionManager collection;
    Dragon oldElem = null;

    public AskManager(InputHandler input, OutputHandler output, CollectionManager collection){
        this.input = input;
        this.output = output;
        this.collection = collection;

    }

    /*private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0, Поле может быть null
    private Color color; //Поле может быть null
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле может быть null
    private DragonHead head;*/

    public Dragon buildDialogue(Dragon oldElem) {
        this.oldElem = oldElem;
        return buildDialogue();
    }
    public Dragon buildDialogue()  {
        Long id = askId();





        String name = null;
        if(oldElem !=null){
            try {
                if(!askForSkip("name", oldElem.getName())){
                    name = askName();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else name = askName();



        Long age = null;
        if(oldElem != null){
            try {
                if(!askForSkip("age", oldElem.getAge().toString())) age = askAge();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else age = askAge();

        Color color = null;
        if(oldElem != null){
            try {
                if(!askForSkip("color", oldElem.getColor().toString())) color = askColor();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else color = askColor();

        Coordinates coordinates = askCoordinates();

        DragonType type = null;
        if(oldElem != null){
            try {
                if(!askForSkip("dragon type", oldElem.getType().toString())) type = askDragonType();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else type = askDragonType();

        DragonCharacter character = null;
        if (oldElem != null){
            try {
                if(!askForSkip("dragon character", oldElem.getCharacter().toString())) character = askDragonCharacter();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else character = askDragonCharacter();

        DragonHead head = null;
        if(oldElem != null){
            try {
                if(!askForSkip("eyes count", Integer.toString(oldElem.getHead().getEyesCount()))) head = new DragonHead(askHead());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else head = new DragonHead(askHead());


        Dragon dragon = null;
        try {
            dragon = new Dragon(id, name, coordinates, age, color, type, character, head, ZonedDateTime.now());
        } catch (InvalidFieldValue e) {
            throw new RuntimeException(e);
        }
        return dragon;

    }

    public Coordinates askCoordinates(){
        output.println("Сектор Coordinates");
        long corx = 0;
        long cory = 0;

        if(oldElem != null){
            try {
                if(!askForSkip("x", Long.toString(oldElem.getCoordinates().getX()))) corx = askXCoordinate();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else corx = askXCoordinate();

        if(oldElem != null){
            try {
                if(!askForSkip("y", Long.toString(oldElem.getCoordinates().getY()))) cory = askYCoordinate();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else cory = askYCoordinate();

        Coordinates ans = null;
        try {
            ans = new Coordinates(corx, cory);
        } catch (InvalidFieldValue e) {
            throw new RuntimeException(e);
        }
        return ans;

    }

    public Long askId(){
        long id;
        if(oldElem == null){
            id = collection.generateId();
        }else{
            id = oldElem.getId();
        }
        return id;
    }

    private int askHead(){
        output.println("Введите количество глаз");

        try {
            return Integer.parseInt(input.get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    private ArrayList<Validatable> getValidators(Field field) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        ArrayList<Validatable> validatables = new ArrayList<>();
        Annotation[] annotations = field.getAnnotations();

        for(Annotation annotation : annotations) {
            ValidatableAnnotation validatableAnnotation = annotation.annotationType().getAnnotation(ValidatableAnnotation.class);
            if(validatableAnnotation != null) {
                Validatable validatable = validatableAnnotation.validator().getConstructor().newInstance();
                if(annotation instanceof GreaterThen) {
                    validatable = ((ValidatableWithArgs)validatable).getInstance(((GreaterThen)annotation).value());
                } else {
                    validatable = validatable.getInstance();
                }
                validatables.add(validatable);
            }
        }
        return validatables;
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
        output.println("Введите имя дракона: ");
        try {
            return input.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Long askAge(){
        output.println("Введите возвраст дракона: ");
        try {
            return Long.parseLong(input.get());
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

    public DragonType askDragonType(){
        output.println("Введите тип дракона");
        output.println(getEnumValues(DragonType.class));
        while (true){
            try{
                String inp = input.get();
                if(!checkEnum(inp, DragonType.class)) output.println("Неправильная константа! Введите еще раз ");
                else return DragonType.valueOf(inp);
            } catch (IOException e) {
                throw new RuntimeException(e);            }
        }
    }
    public DragonCharacter askDragonCharacter(){
        output.println("Введите характер дракона");
        output.println(getEnumValues(DragonCharacter.class));
        while (true){
            try{
                String inp = input.get();
                if(!checkEnum(inp, DragonCharacter.class)) output.println("Неправильная константа! Введите еще раз ");
                else return DragonCharacter.valueOf(inp);
            } catch (IOException e) {
                throw new RuntimeException(e);            }
        }
    }
    public Color askColor(){
        output.println("Введите цвет дракона: ");
        output.println(getEnumValues(Color.class));
        while (true){
            try{
                String inp = input.get();
                if(!checkEnum(inp, Color.class)) output.println("Неправильная константа! Введите еще раз ");
                else return Color.valueOf(inp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
