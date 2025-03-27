package org.example.MyCommands.Commands;

import org.example.MyCollection.CollectionManager;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;

import java.util.ArrayList;

public class RemoveFirstCmd extends AbstractCommand{
    private String description = " удалить первый элемент из коллекции";
    private CollectionManager collection;
    private InputHandler input;
    private OutputHandler output;
    private ArrayList<String> args = new ArrayList<>();


    public RemoveFirstCmd(CollectionManager collection, InputHandler input, OutputHandler output){
        this.collection = collection;
        this.input = input;
        this.output = output;

    }



    public void setArgs(ArrayList<String> setarg) {
        this.args = setarg;
    }

    //@Override
    public void execute()  {
        output.println(collection.remove_first());

    }

    protected boolean checkArgs() {
        boolean flag = true;
        if(args.size() == 1 && args.get(0) == "-h"){
            flag = false;
            help();
        } else if (!args.isEmpty()) {
            flag = false;
        }
        return flag;
    }

    public  void help(){
        output.println("Команда remove_first: " + description);
    }
}
