package com.tutorials.hp.androidmdmysqlsave.mDataObject;

/**
 * Created by Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class Spacecraft {

    int id;
    String name;
    String propellant;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPropellant() {
        return propellant;
    }

    public void setPropellant(String propellant) {
        this.propellant = propellant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
