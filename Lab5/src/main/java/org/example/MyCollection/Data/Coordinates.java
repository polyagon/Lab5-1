package org.example.MyCollection.Data;

import org.example.MyTools.Validators.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Supplier;

public class Coordinates implements Cloneable, Comparable {

    @NotNull
    private Double x; //Поле не может быть null

    @NotNull
    private Long y; //Поле не может быть null

    public Coordinates(double x, long y){
        this.x = x;
        this.y = y;
    }

    public Double getX(){
        return this.x;
    }
    public void setX( Double x){
        this.x = x;
    }

    public Long getY(){
        return this.y;
    }
    public void setY(Long y){
        this.y = y;
    }

    public void setCoordinates(Double x, Long y){
        setY(y);
        setX(x);
    }

    public String generateCSV() {
        String out = x +
                ", " + y;

        return out;
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
                "\n\tx=" +x +
                "\n\ty=" + y;
        return  out + ");\n";
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) return 0;
        if (((Coordinates)o).getX() > this.getX()) return 1;
        else return -1;
    }

}
