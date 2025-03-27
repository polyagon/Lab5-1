package org.example.MyCommands;

import org.example.MyCollection.CollectionManager;
import org.example.MyCommands.Commands.*;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;
import org.example.Tools.ObjectReflect;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandManager {
    InputHandler input;
    OutputHandler output;
    CollectionManager collection;
    HashMap<String, AbstractCommand> commandsMap = new HashMap<>();
    ObjectReflect tree ;



    public CommandManager(InputHandler input, OutputHandler output, CollectionManager collection, ObjectReflect tree) {
        this.input = input;
        this.output = output;
        this.collection = collection;
        this.tree = tree;
        init();
    }

    public void init(){

        commandsMap.put("info", new infoCmd(collection, input, output));
        commandsMap.put("show", new ShowCmd(collection, input, output));
        commandsMap.put("remove_by_id", new RemoveByIdCmd(collection, input, output));
        commandsMap.put("clear", new ClearCmd(collection, input, output));
        commandsMap.put("add", new AddCmd(collection, input, output));
        commandsMap.put("update", new UpdateIdCmd(collection, input, output));
        commandsMap.put("exit", new ExitCmd(collection, input, output));
        commandsMap.put("remove_first", new RemoveFirstCmd(collection, input, output));
        commandsMap.put("remove_greater", new RemoveGreaterCmd(collection, input, output));
        commandsMap.put("head", new HeadCmd(collection, input, output));

    }



    public void createNewCommand(String commandLine) {
        String[] command = commandLine.split(" ");
        //if(command.length < 1)
        output.println(command[0]);
        if(command[0].equals("help")){
            help();
        }
        if (commandsMap.containsKey(command[0])){
            commandsMap.get(command[0]).setArgs(transArgs(command));
            commandsMap.get(command[0]).execute();
        }
    }
    
    //protected void all_help

    private ArrayList<String> transArgs(String[] args){
        ArrayList<String> argsList = new ArrayList<>();
        boolean first = false;
        for(String arg : args) {
            if (first) argsList.add(arg);
            else first = true;
        }
        return argsList;
    }
    protected void help(){
        for (AbstractCommand command : commandsMap.values()){
            command.help();
        }
    }
}
