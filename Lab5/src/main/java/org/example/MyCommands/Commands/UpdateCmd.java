package org.example.MyCommands.Commands;

import org.example.MyCollection.CollectionManager;
import org.example.MyCommands.Excaption.InvalidArgs;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;
import org.example.MyTools.ObjectBuilder;
import org.example.MyTools.ObjectReflect;

import java.util.ArrayList;

public class UpdateCmd extends AbstractCmd{
    private String description = "обновить значение элемента коллекции, id которого равен заданному";
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

    public UpdateCmd(CollectionManager collection, InputHandler input, OutputHandler output, ObjectReflect tree){
        this.collection = collection;
        this.input = input;
        this.output = output;
        this.tree = tree;
    }
    public String help(){
        return "update id {element}: " + description;
    }

    public boolean checkArgs(){
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

    public void setArgs(ArrayList<String> setarg) {
        this.args = setarg;
    }

    public void execute(){
        if(checkArgs()) {
            ObjectBuilder newElem = new ObjectBuilder(input, output);
            collection.update(Long.parseLong(args.get(0)), newElem.buildDialogue(tree));
        }
    }
}
