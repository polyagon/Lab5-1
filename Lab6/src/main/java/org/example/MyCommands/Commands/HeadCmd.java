package org.example.MyCommands.Commands;

import org.example.MyCollection.CollectionManager;
import org.example.MyCommands.Excation.InvalidArgs;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;

import java.util.ArrayList;

public class HeadCmd extends AbstractCommand{
    private String description = " вывести первый элемент коллекции";
    private CollectionManager collection;
    private InputHandler input;
    private OutputHandler output;
    private ArrayList<String> args = new ArrayList<>();


    public HeadCmd(CollectionManager collection, InputHandler input, OutputHandler output){
        this.collection = collection;
        this.input = input;
        this.output = output;
    }



    public void setArgs(ArrayList<String> setarg) {
        this.args = setarg;
    }

    //@Override
    public void execute()  {
        output.println(collection.head());

    }

    protected boolean checkArgs() {
        boolean flag = true;
        if(args.size() == 1 && args.get(0) == "-h"){
            flag = false;
            help();
        } else if (!args.isEmpty()) {
            flag = false;
            InvalidArgs err = new InvalidArgs(args);
            output.println(err.getMessage());
        }
        return flag;
    }

    public  void help(){
        output.println("Команда head: " + description);
    }
}
