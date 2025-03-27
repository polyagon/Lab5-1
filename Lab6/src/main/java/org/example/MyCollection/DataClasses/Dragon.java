package org.example.MyCollection.DataClasses;

import org.example.MyCollection.Exceptions.InvalidFieldValue;
import org.example.Tools.Validators.AutoGenerated;
import org.example.Tools.Validators.GreaterThen;
import org.example.Tools.Validators.NotEmptyString;
import org.example.Tools.Validators.NotNull;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Supplier;

public class Dragon extends  Entity implements Cloneable, Comparable{

    @AutoGenerated
    @GreaterThen()
    public long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    @NotNull
    @NotEmptyString
    private String name; //Поле не может быть null, Строка не может быть пустой

    @NotNull
    private Coordinates coordinates; //Поле не может быть null

    @NotNull
    @AutoGenerated
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @GreaterThen()
    private Long age; //Значение поля должно быть больше 0, Поле может быть null

    private Color color; //Поле может быть null

    @NotNull
    private DragonType type; //Поле не может быть null

    private DragonCharacter character; //Поле может быть null
    private DragonHead head;



    public long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Coordinates getCoordinates(){
        return  this.coordinates;
    }
    public ZonedDateTime getCreationDate(){
        return this.creationDate;
    }
    public Long getAge(){
        return this.age;
    }
    public Color getColor(){
        return this.color;
    }
    public DragonType getType(){
        return this.type;
    }
    public DragonCharacter getCharacter(){
        return this.character;
    }
    public DragonHead getHead(){
        return this.head;
    }


    public void setId(long id){
        this.id = id;
    }
    public void setName(String name) throws InvalidFieldValue {
        if (name == null || name == "") throw new InvalidFieldValue(this.getClass().getName(), name);
        else this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) throws InvalidFieldValue{
        if (coordinates == null) throw new InvalidFieldValue(this.getClass().getName(), coordinates.toString());
        else this.coordinates = coordinates;
    }
    public void setCreationDate(ZonedDateTime creationDate) throws InvalidFieldValue{
        if (creationDate == null) throw new InvalidFieldValue(this.getClass().getName(), "creationDate");
        else this.creationDate = creationDate;
    }
    public void setAge(Long age) throws InvalidFieldValue{
        if (age < 0 ) throw new InvalidFieldValue(this.getClass().getName(), "age");
        else this.age = age;
    }
    public void setColor(Color color) throws InvalidFieldValue{
        this.color = color;
    }
    public void setType(DragonType type) throws InvalidFieldValue{
        if (type == null) throw new InvalidFieldValue(this.getClass().getName(), "type");
        else this.type = type;
    }
    public void setCharacter(DragonCharacter character) throws InvalidFieldValue{
        this.character = character;
    }
    public void setHead(DragonHead head) {
        this.head = head;
    }

    public Dragon(){}
    public Dragon(HashMap<String, Object> tree){
        init(tree);
    }
    public Dragon(long id,String name, Coordinates coordinates, Long age, Color color, DragonType type, DragonCharacter character, DragonHead head, ZonedDateTime creationDate) throws InvalidFieldValue{
        this.id = id;
        this.setAge(age);
        this.setName(name);
        this.setCoordinates(coordinates);
        this.setColor(color);
        this.setType(type);
        this.setCharacter(character);
        this.setHead(head);
        this.setCreationDate(creationDate);
    }





    @Override
    public Dragon clone() throws CloneNotSupportedException {
        return (Dragon) super.clone();
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, age, color, head, character, type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dragon check = (Dragon) o;
        return hashCode() == check.hashCode();
    }
    @Override
    public String toString(){
        String out = "Dragon(" +
                "\n\tid=" + id +
                "\n\tname=" + name +
                "\n\tcoordinates=" + coordinates.toString() +
                "\n\tcreationDate=" + creationDate +//.format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")) +
                "\n\tage=" + age +
                "\n\tcolor=" + color +
                "\n\ttype=" + type +
                "\n\tcharacter=" + character +
                "\n\thead=" + head;
        return  out + ");\n";
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) return 0;
        if (((Dragon)o).id > this.id) return 1;
        else return -1;
    }

    @Override
    public void init(HashMap<String, Object> values) {
        if(values.containsKey("id")) this.id = (int) values.get("id");
        this.name = (String) values.get("name");
        this.coordinates = (Coordinates) values.get("coordinates");
        if(values.containsKey("creationDate")) this.creationDate = (ZonedDateTime) values.get("creationDate");
        else creationDate = ZonedDateTime.now();
        this.age = (Long)values.get("age");
        this.color = (Color)values.get("color");
        this.type = (DragonType)values.get("type");
        this.character = (DragonCharacter) values.get("character");
        this.head = (DragonHead)values.get("head");
    }

    @Override
    public HashMap<String, Object> getValues() {
        HashMap<String, Object> values = new HashMap<>();
        values.put("id", id);
        values.put("name", name);
        values.put("coordinates", coordinates);
        values.put("creationDate", creationDate);
        values.put("age", age);
        values.put("color", color);
        values.put("type", type);
        values.put("character", character);
        values.put("head", head);

        return values;
    }

    public Supplier<Entity> getConstructorReference() {
        return Dragon::new;
    }

}
