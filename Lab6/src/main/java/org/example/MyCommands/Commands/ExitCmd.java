package org.example.MyCommands.Commands;

import org.example.MyCollection.CollectionManager;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;

import java.util.ArrayList;

public class ExitCmd extends AbstractCommand{
    private String description = " завершить программу (без сохранения в файл)";
    private CollectionManager collection;
    private InputHandler input;
    private OutputHandler output;
    private ArrayList<String> args = new ArrayList<>();


    public ExitCmd(CollectionManager collection, InputHandler input, OutputHandler output){
        this.collection = collection;
        this.input = input;
        this.output = output;

    }



    public void setArgs(ArrayList<String> setarg) {
        this.args = setarg;
    }

    //@Override
    public void execute()  {
        System.exit(0);

    }

    protected boolean checkArgs() {
        boolean flag = true;
        if(args.getFirst().equals("-h")){
            flag = false;
            help();
        }
        return flag;
    }

    public  void help(){
        output.println("Команда exit: " + description);
    }
}
