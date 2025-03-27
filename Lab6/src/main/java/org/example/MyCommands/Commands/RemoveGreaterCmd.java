package org.example.MyCommands.Commands;

import org.example.MyCollection.AskManager;
import org.example.MyCollection.CollectionManager;
import org.example.MyCollection.DataClasses.Dragon;
import org.example.MyCommands.Excation.InvalidArgs;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;

import java.util.ArrayList;

public class RemoveGreaterCmd extends AbstractCommand{
    private String description = " удалить из коллекции все элементы, превышающие заданный";
    private CollectionManager collection;
    private InputHandler input;
    private OutputHandler output;
    private ArrayList<String> args = new ArrayList<>();

    public RemoveGreaterCmd(CollectionManager collection, InputHandler input, OutputHandler output){
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
        output.println(collection.remove_greater(newElem));

    }

    protected boolean checkArgs() {
        boolean flag = true;
        if(args.size() == 1 && args.get(0).equals("-h")) {
            flag = false;
            help();
        }
        else if(!args.isEmpty()){
            flag = false;
            InvalidArgs err = new InvalidArgs(args);
            output.println(err.getMessage());
        }
        return flag;
    }

    public void help(){
        output.println("Команда remove_greater {element}: " + description);
    }

}
