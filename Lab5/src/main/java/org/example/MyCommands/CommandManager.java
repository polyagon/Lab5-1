package org.example.MyCommands;

import org.example.MyCollection.CollectionManager;
import org.example.MyCommands.Commands.*;
import org.example.MyCommands.Commands.ShowCmd;
import org.example.MyStream.ConsoleHandler.ConsoleInput;
import org.example.MyStream.FileHandler.FileInput;
import org.example.MyStream.InputHandler;
import org.example.MyStream.OutputHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.example.MyCommands.Commands.AbstractCmd;
import org.example.MyTools.ObjectReflect;


public class CommandManager {
    InputHandler input;
    OutputHandler output;
    CollectionManager collection;
    HashMap<String, AbstractCmd> commandsMap = new HashMap<>();
    ObjectReflect tree;
    private ArrayList<String> parsedScripts = new ArrayList<>();




    public CommandManager(InputHandler input, OutputHandler output, CollectionManager collection, ObjectReflect tree) {
        this.input = input;
        this.output = output;
        this.collection = collection;
        this.tree = tree;
        init();
    }



    public void startExecuting() throws IOException {
        //System.out.println("DEBUG: execution by stream started at " + inputHandler.getClass().getName());

        /*if (!input.hasNextLine()) {
            //save
            output.print("Получен сигнал EOF (Ctrl+D).");

        }*/
        while (input.hasNextLine()) {
            String command = input.get();

            //System.out.println("DEBUG: \"" + command + "\" stream=" + inputHandler.getClass().getName());
            if(command.isEmpty() || command.isBlank()) {
                continue;
            }
            createNewCommand(command.split(" "));
        }
        if(input instanceof FileInput) System.out.println("Ввод из файла завершен. Закрываю чтение.");
        else System.out.println("Пока!");


    }





    public void init(){
        commandsMap.put("info", new InfoCmd(collection, input, output));
        commandsMap.put("show", new ShowCmd(collection, input, output));
        commandsMap.put("add", new AddCmd(collection, input, output, CollectionManager.theLab));
        commandsMap.put("update", new UpdateCmd(collection, input, output, CollectionManager.theLab));
        commandsMap.put("remove_by_id", new InfoCmd(collection, input, output));
        commandsMap.put("clear", new ClearCmd(collection, input, output));
        commandsMap.put("save", new SaveCmd(collection, input, output));
        //execute_script
        commandsMap.put("shuffle", new ShuffleCmd(collection, input, output));
        commandsMap.put("remove_greater", new RemoveGreaterCmd(collection, input, output, CollectionManager.theLab));
        commandsMap.put("remove_lower", new RemoveLowerCmd(collection, input, output, CollectionManager.theLab));
        commandsMap.put("count_by_minimal_point", new CountByMinimalPointCmd(collection, input, output));
        commandsMap.put("count_greater_than_difficulty", new CountGreaterThanDifficulty(collection, input, output));
        commandsMap.put("count_less_than_difficulty", new CountLessThanDifficulty(collection, input, output));


    }

    private  void changeGlobalStreams(InputHandler input, OutputHandler output){
        for( AbstractCmd cmd : commandsMap.values()) {
            cmd.setInput(input);
            cmd.setOutput(output);
        }
    }

    public void executeScript(String path)  {
        path = new File(path).getAbsolutePath();
        if(parsedScripts.contains(path)){
            output.println("Невозможно загрузить этот файл рекурсивно");
            parsedScripts.clear();
        }
        else {
            parsedScripts.add(path);
            try {
                input = new FileInput(path);
                changeGlobalStreams(input, output);
                startExecuting();
            } catch (Exception e) {
                output.printErr(e.getMessage());
            }
        }
        input = new ConsoleInput();
        changeGlobalStreams(input, output);
    }




    public void createNewCommand(String[] command) throws IOException {
        // output.println(command[0]);
        if(command == null) return;
        if(!commandsMap.containsKey(command[0])){
            if(command[0].contains("execute_script")) {
                executeScript(command[1]);
            }else if(command[0].contains("help")) {
                help();
            }else if(command[0].contains("exit")){
                exit_cmd();
            }
            else {
                throw new IllegalArgumentException("Данной команды не существует");
            }
        }else if (commandsMap.containsKey(command[0])){
            commandsMap.get(command[0]).setArgs(transArgs(command));
            commandsMap.get(command[0]).execute();
        }
    }

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
        for (AbstractCmd command : commandsMap.values()){
            output.println(command.help());
        }
    }


    public void exit_cmd() throws IOException {
        output.println("Вы уверены, что хотите выйти из программы без сохранения в файл? (Y/N)");
        if (input.get().equalsIgnoreCase("Y")) {
            System.exit(0);  // Выход из программы
        } else if (input.get().equalsIgnoreCase("N")) {
            output.println("Выход отменен. Продолжаем выполнение.");
        } else {
            output.println("Некорректный ввод. Пожалуйста, введите 'Y' или 'N'.");
        }
    }
    public boolean isNO() throws IOException {
        output.println("Вы уверены, что хотите выйти из программы без сохранения в файл? (Y/N)");
        while (true){
        if (input.get().equalsIgnoreCase("Y")) {
            return false;
        } else if (input.get().equalsIgnoreCase("N")) {
            output.println("Выход отменен. Продолжаем выполнение.");
            return true;
        } else {
            output.println("Некорректный ввод. Пожалуйста, введите 'Y' или 'N'.");
        }}
    }





}
