package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.MyCollection.CollectionManager;
import org.example.MyCollection.DataClasses.*;
import org.example.MyCommands.CommandManager;
import org.example.MyStream.Exceptions.UndefinedFile;
import org.example.MyStream.consoleStream.ConsoleInputHandler;
import org.example.MyStream.consoleStream.ConsoleOutputHandler;
import org.example.MyStream.fileStream.FileInputHandler;
import org.example.MyStream.fileStream.FileOutputHandler;
import org.example.Tools.ObjectReflect;

import java.io.IOException;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) throws IOException, UndefinedFile, InstantiationException, IllegalAccessException {
        ConsoleInputHandler cin = new ConsoleInputHandler();
        ConsoleOutputHandler cout = new ConsoleOutputHandler();

        FileInputHandler fin = new FileInputHandler("/home/polina/javacode/Lab5/src/inpFileTest");
        FileOutputHandler fout = new FileOutputHandler("/home/polina/javacode/Lab5/src/outFIleTest");











        /*while(cin.hasNextLine()){
            String line = cin.get();
            cout.print(line);
        }*/

        ObjectReflect tree = new ObjectReflect(Dragon.class);

        CollectionManager collection = new CollectionManager();
        CommandManager command_m = new CommandManager(fin, fout, collection, tree);

        // POJO to JSON
        // ObjectMapper obj = new ObjectMapper();
       // obj.findAndRegisterModules();
        Coordinates cor = new Coordinates(1, 1);
        DragonHead head = new DragonHead(1);
        Dragon dragon = new Dragon(1, "polya", cor, 12L, Color.BLACK, DragonType.FIRE, DragonCharacter.EVIL, head, ZonedDateTime.now() );
        collection.add(dragon);
       // String json =  obj.writeValueAsString(dragon);
       // cout.println(json);

        //JSON to POJO
        //String s = "{\"id\":1,\"name\":\"polya\",\"coordinates\":{\"x\":1.0,\"y\":1},\"creationDate\":1719086939.410111807,\"age\":12,\"color\":\"BLACK\",\"type\":\"FIRE\",\"character\":\"EVIL\",\"head\":{\"eyesCount\":1}" ];
        // Dragon d2 = obj.readValue(s, Dragon.class);



        while (fin.hasNextLine()){
            command_m.createNewCommand(fin.get());
        }
        fin.close();
        fout.close();

        /*ObjectReflect dragonClass = new ObjectReflect(Dragon.class);
        cout.println(dragonClass.getClassName());
        cout.println(dragonClass.getClassType().toString());
        for(ObjectReflect dragonFields : dragonClass.getFields()){
            cout.println("Name: " + dragonFields.getClassName());
            cout.println("Type: " + dragonFields.getClassType().toString());


        }*/





    }
}