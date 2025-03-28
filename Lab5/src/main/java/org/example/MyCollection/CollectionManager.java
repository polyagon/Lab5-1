package org.example.MyCollection;



import org.example.Main;
import org.example.MyCollection.Data.*;
import org.example.MyStream.FileHandler.FileInput;
import org.example.MyStream.FileHandler.FileOutput;
import org.example.MyTools.ObjectBuilder;
import org.example.MyTools.ObjectReflect;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

public class CollectionManager<T extends Object>  {

    private static ArrayList<LabWork> collection = new ArrayList<LabWork>();
    private static ZonedDateTime creationTime;
    public static String path = null;
    public static ObjectReflect theLab = new ObjectReflect(LabWork.class);

    public CollectionManager(){
        creationTime = ZonedDateTime.now();
    }


    public void init() {
        try {
            collection = new ArrayList<>();
            creationTime = ZonedDateTime.now();
            if (path== null) {
                //path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParent() + File.separatorChar + "sysFiles" + File.separatorChar;
                path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + File.separatorChar  + "data.csv";
                System.out.println("""
                        Файл для сохрнанения данных не передан в строке окружения. 
                        Данные будут записаны в файл по адресу"""

                        + "\n" + path +  "\n" +
                        """
                        #################################
                        """);

            }
            else{
                System.out.println("""
                        #################################
                        Файл для сохранненя данных указан по адресу"""
                        + "\n" + path +  "\n" +
                        """
                        #################################
                        """);
            }
            load(path);//спарсить файл первый
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




    public void parseCSV(String input)  {
        collection.clear();
        String[] data = input.split("\n");

        String[] markup = data[0].split(", ");
        HashMap<String, String> dataMap = new HashMap<String, String>();

        for (String s : markup) {
            dataMap.put(s, "");
        }

        for(int i=1; i < data.length; i++) {
            if (data[i].isEmpty()) continue;
            String[] line = data[i].split(", ");


            try {
                for (int j = 0; j < markup.length; j++) {
                    dataMap.replace(markup[j], line[j]);
                }
                ObjectBuilder builder = new ObjectBuilder();
                LabWork newElem = builder.buildByStringMap(theLab, dataMap);
                if(newElem == null) System.out.println("error in csv-import: " + data[i]);
                else add(newElem);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String generateCSV() {
        StringBuilder out = new StringBuilder("id" +
                ", name" +
                ", coordinates x" +
                ", coordinates y" +
                ", creationDate" +
                ", minimalPoint" +
                ", difficulty" +
                ", author name" +
                ", author birthday" +
                ", author height" +
                ", author weight" +
                ", author passportID" + "\n");

        for (LabWork lab : collection) {
            if (lab == null) continue;
            out.append(lab.generateCSV() + "\n");
        }
        return out.toString();
    }

    /**
     * save collection to default path
     */
    public void save(){
        try {
            FileOutput file = new FileOutput(path);
            file.println(generateCSV());
            file.close();
            System.out.println("Файл сохранен по адресу: " + path);
        } catch (IOException e) {
            System.out.println(e.getMessage());//System.out.println(e.getMessage());//e.printStackTrace();
        }
    }



    public void load(String newPath){
        FileInput file = new FileInput(newPath);
        StringBuilder buff = new StringBuilder();
        while (file.hasNextLine())
            buff.append(file.get() + "\n");
        parseCSV(buff.toString());
        file.close();
    }


    public static ZonedDateTime getCreationTime(){
        return creationTime;
    }

    private void sortCollection(){
        Collections.sort(collection);
    }

    public static String info(){
        String out = "";
        out += "Тип коллекции: ArrayList" + "\n"+
                "Тип данных: " + LabWork.class.getName() + "\n"+
                "Время создания: " + getCreationTime().toString() + "\n"+
                "Количество объектов: " + collection.size();
        return out;
    }


    public static String show(){
        String out = "";
        if (collection.isEmpty()) out = "Collection is empty";
        else {
            for (LabWork lab : collection) {
                out += lab.toString() + ", ";
            }
        }
        return out;
    }

    private LabWork getLab_byID(long id){
        for (LabWork lab: collection){
            if(lab.getId() == id) return lab;
        }
        return null;
    }

    public String remove_by_id(int id){
        if(collection.isEmpty()) return  "Collection is empty";
        else{
            for (LabWork lab: collection){
                if(lab.getId() == id){ collection.remove(lab); return "Lab is deleted";}
            }
           return  "Lab is non founded";
        }
    }

    public String clear(){
        collection.clear();
        return "Collection is clear";
    }

    public LabWork lastEl(){
        return collection.get(collection.size() - 1);
    }

    public String add(LabWork a) {
        collection.add(a);
        lastEl().setId(lastEl().genereteID());
        this.sortCollection();
        return "Lab was added";
    }

    public String shuffle(){
        Collections.shuffle(collection);
        return "Collection was shuffled";
    }

    public String remove_greater (LabWork lab){
        for(int i = 0; i < collection.size(); i++){
            if(collection.get(i).compareTo(lab) == -1) {
                collection.remove(i);
                i--;
            }
        }
        return "Greater objects was deleted";
    }

    public String remove_lower (LabWork lab){
        for(int i = 0; i < collection.size(); i++){
            if(collection.get(i).compareTo(lab) == 1) {
                collection.remove(i);
                i--;
            }
        }
        return "Lower objects was deleted";
    }

    public String count_by_minimal_point (Integer point){
        int ans = 0;
        for(LabWork work: collection){
            if (work.getMinimalPoint() == point){
                ans += 1;
            }
        }
        return "Count of objects with equal minimal point is" + ans;
    }

    public String count_less_than_difficulty(Difficulty difficulty){
        int ans = 0;
        for(LabWork lab: collection){
            if(difficulty.hasLessPriority(lab.getDifficulty())){
                ans++;
            }
        }
        return "Count of objects less difficulty is " + ans;
    }

    public String count_greater_than_difficulty(Difficulty difficulty){
        int ans = 0;
        for(LabWork lab: collection){
            if(difficulty.hasGreaterPriority(lab.getDifficulty())){
                ans++;
            }
        }
        return "Count of objects greater difficulty is " + ans;
    }

    public String update(int id, LabWork newlab){
        if(collection.isEmpty()) return  "Collection is empty";
        else{
            for (LabWork lab: collection){
                if(lab.getId() == id){
                    remove_by_id(id);
                    add(newlab);
                    sortCollection();
                    return "Lab is updated";
                }
            }
            return  "Lab is non founded";
        }
    }





















}