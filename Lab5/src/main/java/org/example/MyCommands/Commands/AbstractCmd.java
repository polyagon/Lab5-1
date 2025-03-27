package org.example.MyCommands.Commands;

import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;

import java.util.ArrayList;

public abstract class AbstractCmd {

    public abstract boolean checkArgs();
    public abstract void execute();
    public abstract String help();
    public abstract void setArgs(ArrayList<String> setarg);
    public abstract void setOutput(OutputHandler out);
    public abstract void setInput(InputHandler in);

}
