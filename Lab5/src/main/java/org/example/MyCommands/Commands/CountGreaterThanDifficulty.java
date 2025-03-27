package org.example.MyCommands.Commands;

import org.example.MyCollection.CollectionManager;
import org.example.MyCommands.Excaption.InvalidArgs;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;
import org.example.MyTools.Converter;

import java.util.ArrayList;

public class CountGreaterThanDifficulty extends AbstractCmd {
    private String description = "";
    private CollectionManager collection;
    private InputHandler input;
    private OutputHandler output;
    private ArrayList<String> args = new ArrayList<>();


    public void setOutput(OutputHandler out){
        output = out;
    }
    public void setInput(InputHandler in){
        input = in;
    }


    public CountGreaterThanDifficulty(CollectionManager collection, InputHandler input, OutputHandler output){
        this.collection = collection;
        this.input = input;
        this.output = output;
    }


    public String help(){
        return "count_greater_than_difficulty difficulty: " + description;
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
        if(checkArgs())  output.println(collection.count_greater_than_difficulty(Converter.DifficultyConvert(args.get(0))));
    }
}
