package org.example.MyCollection.DataClasses;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Supplier;

public class DragonHead extends Entity implements Cloneable, Comparable{

    private int eyesCount;

    public void setEyesCount(int eyecount){
        this.eyesCount = eyecount;
    }

    public int getEyesCount(){
        return this.eyesCount;
    }

    public DragonHead(){}
    public DragonHead(int eyesCount){
        this.setEyesCount(eyesCount);
    }

    @Override
    public DragonHead clone() throws CloneNotSupportedException{
        return (DragonHead) super.clone();
    }

    @Override
    public int compareTo(Object o){
        if (o == null || o.getClass() != o.getClass()){
            return 0;
        }
        if (((DragonHead)o).getEyesCount() > this.getEyesCount()){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(eyesCount);
    }

    @Override
    public String toString(){
        String out = "DragonHead("+
                "\n\teyesCount = " + this.getEyesCount();
        return out + ");\n";
    }

    @Override
    public boolean equals(Object o){
        if (o == null || o.getClass() != this.getClass()) return false;
        if (this == o) return true;

        return this.hashCode() == ((DragonHead)o).hashCode();
    }

    @Override
    public void init(HashMap<String, Object> values) {
        this.eyesCount = (int) values.get("eyesCount");
    }

    @Override
    public HashMap<String, Object> getValues() {
        HashMap<String, Object> values = new HashMap<>();
        values.put("eyesCount", eyesCount);
        return values;
    }

    public Supplier<Entity> getConstructorReference() {
        return DragonHead::new;
    }
}
