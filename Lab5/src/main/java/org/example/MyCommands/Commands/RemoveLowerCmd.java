package org.example.MyCommands.Commands;

import org.example.MyCollection.CollectionManager;
import org.example.MyCommands.Excaption.InvalidArgs;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;
import org.example.MyTools.ObjectBuilder;
import org.example.MyTools.ObjectReflect;

import java.util.ArrayList;

public class RemoveLowerCmd extends AbstractCmd{
    private String description = "удалить из коллекции все элементы, меньшие, чем заданный";
    private CollectionManager collection;
    private InputHandler input;
    private OutputHandler output;
    private ArrayList<String> args = new ArrayList<>();
    private ObjectReflect tree;


    public void setOutput(OutputHandler out){
        output = out;
    }
    public void setInput(InputHandler in){
        input = in;
    }

    public RemoveLowerCmd(CollectionManager collection, InputHandler input, OutputHandler output, ObjectReflect tree){
        this.collection = collection;
        this.input = input;
        this.output = output;
        this.tree = tree;
    }
    public String help(){
        return "remove_lower {element}: " + description;
    }

    public boolean checkArgs(){
        boolean flag = true;
        if(args.size() == 1 && args.get(0).equals("-h")) {
            flag = false;
            help();
        }
        else if(args.size() != 0){
            flag = false;
            InvalidArgs err = new InvalidArgs(args);
            output.println(err.getMessage());
        }
        return flag;
    }

    public void setArgs(ArrayList<String> setarg) {
        this.args = setarg;
    }

    public void execute(){
        if(checkArgs()) {
            ObjectBuilder newElem = new ObjectBuilder(input, output);
            collection.remove_lower(newElem.buildDialogue(tree));
        }
    }
}
