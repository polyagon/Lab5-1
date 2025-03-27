package org.example.MyCommands.Commands;

import org.example.MyCollection.AskManager;
import org.example.MyCollection.CollectionManager;
import org.example.MyCollection.DataClasses.Dragon;
import org.example.MyCollection.Exceptions.InvalidFieldValue;
import org.example.MyCommands.Excation.InvalidArgs;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;

import java.util.ArrayList;

public class AddCmd extends AbstractCommand{
    private String description = " добавить новый элемент в коллекцию ";
    private CollectionManager collection;
    private InputHandler input;
    private OutputHandler output;
    private ArrayList<String> args = new ArrayList<>();


    public AddCmd(CollectionManager collection, InputHandler input, OutputHandler output){
        this.collection = collection;
        this.input = input;
        this.output = output;
    }



    public void setArgs(ArrayList<String> setarg) {
        this.args = setarg;
    }

    //@Override
    public void execute()  {
        AskManager ask = new AskManager(input, output, collection);
        Dragon newElem = ask.buildDialogue() ;
        try {
            collection.add(newElem);
            output.println("Элемент добавлен!");
        } catch (InvalidFieldValue e) {
            throw new RuntimeException(e);
        }


    }

    protected boolean checkArgs() {
        boolean flag = true;
        if(args.getFirst().equals("-h")){
            flag = false;
            help();
        }
        else if(args.size() != 0) {
            output.println(args.toString());
            flag = false;
            InvalidArgs err = new InvalidArgs(args);
            output.println(err.getMessage());
        }
        return flag;
    }

    public  void help(){
        output.println("Команда add {element}: " + description);
    }
}
