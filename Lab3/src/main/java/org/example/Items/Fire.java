package org.example.Items;

import org.example.Enums.ITEMStatus;
import org.example.Excaptions.CustomException;
import org.example.Interfaces.Locationable;
import org.example.Locations.Location;
import org.example.Persons.Person;

public class Fire extends Item implements Locationable {
    boolean light = false;
    Smoke smoke = null;
    private boolean isSmoke = false;
    Item material = null;

    public Fire(String name, ITEMStatus stss, Item material, Location location, boolean toxic){
        super(name,stss, location);
        this.material = material;
        this.makeSmoke(toxic);
    }


    public void makeSmoke(boolean toxic){
        this.smoke = new Smoke(toxic);
        isSmoke= true;
        smoke.smoking();
    }

    public String getSmoke() throws CustomException {
        if(isSmoke) return smoke.getName();
        else{
            throw new CustomException("There is no smoke");
        }
    }
    public void setMaterial(Item material, boolean toc){
        this.material = material;
        smoke.setToxic(toc);
        smoke.smoking();
    }

    public static class Smoke{
        public Smoke(boolean tox){
            this.toxic = tox;
        }
        boolean toxic = false;
        public boolean getToxic(){
            return toxic;
        }
        public void setToxic(boolean ne){
            this.toxic = ne;
        }
        public String getName(){
            return "smoke";
        }
        public void smoking(){
            System.out.println("Smoke came out. Smoke toxic is " + this.getToxic());
        }
    }

    public void light(){this.light = true;
        System.out.println("Fire is lighting");
    }
    public void light_down(){
        this.light = false;
        System.out.println("Fire isn't lighting");
    }

}
