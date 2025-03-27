package org.example.MyCollection.DataClasses;

import java.util.HashMap;
import java.util.function.Supplier;

public abstract class Entity {
    //public abstract void askObject();
    public abstract void init(HashMap<String, Object> values);
  public abstract HashMap<String, Object> getValues();
  public abstract Supplier<Entity> getConstructorReference();
}
