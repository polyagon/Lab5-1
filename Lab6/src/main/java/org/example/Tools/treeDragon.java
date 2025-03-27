package org.example.Tools;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class treeDragon {
    HashMap<Class<?> , ArrayList<Field>> notPrimitiveFields = new HashMap<>();
    HashMap<String, ArrayList<Enum<?>>> enumFields = new HashMap<>();

    HashMap<Class<?>, Annotation[]> validatorList = new HashMap<>();

    ArrayList<Field> fields1 = new ArrayList<>();
    //fields1.add()
}
