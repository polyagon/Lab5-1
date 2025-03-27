package org.example.MyCollection;


import org.example.MyCollection.DataClasses.Dragon;
import org.example.MyCollection.Exceptions.InvalidFieldValue;

import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionManager<T extends Object>  {
 /*Main collection manager
 * info, show, add, update, remove_by_id, */



    private static ArrayDeque<Dragon> collection = new ArrayDeque<Dragon>();
    private static ZonedDateTime creationTime;
    private static int UniqueCounter = 0;
    private HashSet<Long> idSet = new HashSet<Long>();
    //public static final ObjectReflect dragonReflect = new ObjectReflect("Dragon", Dragon.class);

    public CollectionManager(){
        setCreationTime(ZonedDateTime.now());

    }

    public Long generateId(){
        long maxx = -1L;
        for (Long i : idSet){
            if(maxx < i) maxx = i;
        }
        return maxx+1;
    }

    public static ZonedDateTime getCreationTime() {
        return creationTime;
    }

    public static void setCreationTime(ZonedDateTime creationTime) {
        CollectionManager.creationTime = creationTime;
    }

    public static String info(){
        String out = "";
        out += "Тип коллекции: ArrayDeque" + "\n"+
                "Тип данных: " + Dragon.class.getName() + "\n"+
                "Время создания: " + creationTime.toString() + "\n"+
                "Количество объектов: " + collection.size();
        return out;
    }

    public static String show(){
        String out = "";
        if (collection.isEmpty()) out = "Collection is empty";
        else {
            for (Dragon animal : collection) {
                out += animal.toString();
            }
        }
        return out;
    }

    public static void add(Dragon a) throws InvalidFieldValue {
        collection.add(a);
        collection.getLast().setId(UniqueCounter);
        UniqueCounter++;
    }

    public static String add(HashMap<String, Object> tree) {
        if(tree == null) return "Dragon didn't add";
        collection.add(new Dragon(tree));
        collection.getLast().setId(UniqueCounter);
        UniqueCounter++;

        return  "Dragon added";

    }



    public static Dragon getPersonByID(Integer id){
        for(Dragon animal: collection){
            if(animal.getId() == id){
                return animal;
            }
        }
        return null;
    }

    public static String remove_byID(Integer id){
        Dragon a = getPersonByID(id);
        String out = "";
        if (a == null){
            out += "Dragon is undefinded";
        }else{
            collection.removeFirstOccurrence(a);
            out += "Dragon is delated";
        }
        return  out;
    }

    public static String update (Integer id, Dragon b){
        Dragon a = getPersonByID(id);
        String out = "";
        if (a == null){
            out += "Dragon is undefinded";
        }else{
            collection.remove(a);
            b.setId(id);
            collection.add(b);
            out += "Person is update";
        }
        return  out;
    }

    public static String clear(){
        while (!collection.isEmpty()){
            collection.pop();
        }
        UniqueCounter = 0;
        return "Collection is cleared";
    }



    public static String remove_greater(Dragon a){
        for (Dragon animal: collection){
            if (animal.compareTo(a) == -1){
                collection.removeFirstOccurrence(a);
            }
        }
        return "Greater objects is removed";
    }
    public static String remove_first(){
        if (!collection.isEmpty()){
            collection.removeFirst();
        }
        return "First Object is deleted";

    }

    public static String head(){
        if (!collection.isEmpty()){
            return collection.getFirst().toString();
        }
        return "Collection is cleared";
    }

    public static Long average_of_age(){
        Long summ = 0L;
        for (Dragon num : collection) {
            summ += num.getAge();
        }

        return summ/collection.size();
    }

    public static int count_greater_than_age(Long age){
        int s = 0;
        for( Dragon animal : collection){
            if (animal.getAge() > age){
                s ++;
            }
        }
        return s;
    }
    public static int filter_by_age(Long age){
        int s = 0;
        for( Dragon animal : collection){
            if (animal.getAge() == age){
                s ++;
            }
        }
        return s;
    }

    public static Dragon getElement(long id){
        Dragon dragon = null;
        for(Dragon i : collection){
            if(i.getId() == id) {
                dragon = i;
                break;
            }
        }
        return dragon;
    }



}
