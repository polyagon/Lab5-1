package org.example.MyCollection.DataClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.MyCollection.Exceptions.InvalidFieldValue;
import org.example.Tools.Validators.GreaterThen;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Supplier;

public class Coordinates extends Entity implements Cloneable, Comparable{

    private long x;

    @GreaterThen("-331")
    private long y; //Значение поля должно быть больше -331



    public long getX(){
        return this.x;
    }
    public long getY(){
        return  this.y;
    }

    public void setX(long x){
        this.x = x;
    }

    public void setY(long y) throws InvalidFieldValue{
        if (y < -331){
            throw new InvalidFieldValue(this.getClass().getName(), "y" );
        }else{
            this.y = y;
        }
    }

    public Coordinates(){};
    public Coordinates(long x, long y) throws InvalidFieldValue {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public Coordinates clone() throws CloneNotSupportedException {
        return (Coordinates) super.clone();
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates check = (Coordinates) o;
        return hashCode() == check.hashCode();
    }
    @Override
    public String toString(){
        String out = "Coordinates(" +
                "\n\tx=" + x +
                "\n\ty=" + y ;
        return  out + ");\n";
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) return 0;
        if (((Coordinates)o).x > this.y) return 1;
        else return -1;
    }
    @JsonIgnore
    @Override
    public void init(HashMap<String, Object> values) {
        this.x = (long) values.get("x");
        this.y = (long) values.get("y");
    }

    @Override
    @JsonIgnore
    public HashMap<String, Object> getValues() {
        HashMap<String, Object> values = new HashMap<>();
        values.put("x", x);
        values.put("y", y);
        return values;
    }

    @JsonIgnore
    public Supplier<Entity> getConstructorReference() {
        Supplier<Entity> aNew = Coordinates::new;
        return aNew;
    }

}


