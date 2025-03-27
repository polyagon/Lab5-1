package org.example.MyCommands.Commands;

import java.util.ArrayList;

public  abstract class AbstractCommand {
    public abstract void execute() ;
    protected abstract boolean checkArgs() ;
    public abstract void setArgs(ArrayList<String> setArg);
    public abstract void help();

}
