package org.example.MyCommands.Commands;

import org.example.MyCollection.CollectionManager;
import org.example.MyCommands.Excation.InvalidArgs;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;

import java.util.ArrayList;

public class ShowCmd extends AbstractCommand{

    private String description = " вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    private CollectionManager collection;
    private InputHandler input;
    private OutputHandler output;
    private ArrayList<String> args = new ArrayList<>();


    public ShowCmd(CollectionManager collection, InputHandler input, OutputHandler output){
        this.collection = collection;
        this.input = input;
        this.output = output;

    }



    public void setArgs(ArrayList<String> setarg) {
        this.args = setarg;
    }

    //@Override
    public void execute() {
        if(checkArgs()){
            output.println(collection.show());
        }
    }

    protected boolean checkArgs()  {
        boolean flag = true;
        if(args.size() == 1 && args.getFirst().equals("-h")) {
            flag = false;
            help();
        }
        else if(!args.isEmpty()) {
            flag = false;
            InvalidArgs err = new InvalidArgs(args);
            output.println(err.getMessage());
        };
        return flag;
    }

    public void help(){
        output.println("Команда show: " + description);
    }
}
