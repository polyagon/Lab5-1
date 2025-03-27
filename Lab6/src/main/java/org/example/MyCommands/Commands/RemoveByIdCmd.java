package org.example.MyCommands.Commands;

import org.example.MyCollection.CollectionManager;
import org.example.MyCommands.Excation.InvalidArgs;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;

import java.util.ArrayList;

public class RemoveByIdCmd extends AbstractCommand{
    private String description = " удалить элемент из коллекции по его id";
    private CollectionManager collection;
    private InputHandler input;
    private OutputHandler output;
    private ArrayList<String> args = new ArrayList<>();


    public RemoveByIdCmd(CollectionManager collection, InputHandler input, OutputHandler output){
        this.collection = collection;
        this.input = input;
        this.output = output;

    }



    public void setArgs(ArrayList<String> setarg) {
        this.args = setarg;
    }

    //@Override
    public void execute()  {
        if(checkArgs()){
            try {
                output.println(
                        collection.remove_byID(Integer.parseInt(args.get(0)))
                );
            }catch (NumberFormatException e){
                output.println("Аргумент " + args.get(0) + " не является id");
            }

        }

    }

    protected boolean checkArgs() {
        boolean flag = true;
        if(args.size() != 1) {
            output.println(args.toString());
            flag = false;
            InvalidArgs err = new InvalidArgs(args);
            output.println(err.getMessage());
        }
        else if(args.getFirst().equals("-h")){
            flag = false;
            help();
        }
        return flag;
    }

    public  void help(){
        output.println("Команда remove_by_id id: " + description);
    }
}
