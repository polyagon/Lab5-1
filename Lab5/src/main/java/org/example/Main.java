package org.example;

import org.example.MyCollection.Data.LabWork;
import org.example.MyCommands.CommandManager;
import org.example.MyCollection.*;
import org.example.MyStream.ConsoleHandler.ConsoleInput;
import org.example.MyStream.ConsoleHandler.ConsoleOutput;
import org.example.MyTools.ObjectReflect;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  throws IOException {

        ConsoleInput cin = new ConsoleInput();
        ConsoleOutput cout = new ConsoleOutput();
        CollectionManager collection = new CollectionManager();
        ObjectReflect tree = new ObjectReflect(LabWork.class);

        if(args.length != 0) collection.path = args[0];
        collection.init();



        CommandManager commandManager = new CommandManager(cin, cout, collection, tree);
        commandManager.startExecuting();


    }
}