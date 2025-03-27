package org.example.MyCommands.Commands;

import org.example.MyCollection.AskManager;
import org.example.MyCollection.CollectionManager;
import org.example.MyCollection.DataClasses.Dragon;
import org.example.MyCommands.Excation.InvalidArgs;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;

import java.util.ArrayList;

public class UpdateIdCmd extends AbstractCommand{
    private String description = " обновить значение элемента коллекции, id которого равен заданному";
    private CollectionManager collection;
    private InputHandler input;
    private OutputHandler output;
    private ArrayList<String> args = new ArrayList<>();


    public UpdateIdCmd(CollectionManager collection, InputHandler input, OutputHandler output){
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
        Dragon oldElem = collection.getElement(Integer.parseInt(args.get(0)));
        Dragon newElem = ask.buildDialogue(oldElem);
        try {
            output.println(collection.update(Integer.parseInt(args.get(0)), newElem));
        }catch (NumberFormatException e){
            output.println("Аргумент " + args.get(0) + " не является id");
        }
    }

    protected boolean checkArgs() {
        boolean flag = true;
        if(args.size() == 1 && args.get(0).equals("-h")) {
            flag = false;
            help();
        }
        else if(args.size() != 1){
            flag = false;
            InvalidArgs err = new InvalidArgs(args);
            output.println(err.getMessage());
        }
        return flag;
    }

    public void help(){
        output.println("Команда update id {element}: " + description);
    }
}
