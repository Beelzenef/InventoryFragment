package com.example.inventoryfragment.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Elena G (Beelzenef)
 */

public class Section implements Parcelable {

    private int IDSection;
    private String name;
    private String shortName;
    private String description;
    private int dependencyID;
    private boolean enabled;
    private boolean defaultSection;

    // Getters + Setters

    protected Section(Parcel in) {
        IDSection = in.readInt();
        name = in.readString();
        shortName = in.readString();
        description = in.readString();
        dependencyID = in.readInt();
        enabled = in.readByte() != 0;
        defaultSection = in.readByte() != 0;
    }

    public static final Creator<Section> CREATOR = new Creator<Section>() {
        @Override
        public Section createFromParcel(Parcel in) {
            return new Section(in);
        }

        @Override
        public Section[] newArray(int size) {
            return new Section[size];
        }
    };

    public int getIDSection() {
        return IDSection;
    }

    public void setIDSection(int IDSection) {
        this.IDSection = IDSection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDependencyID() {
        return dependencyID;
    }

    public void setDependencyID(int dependencyID) {
        this.dependencyID = dependencyID;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDefaultSection() {
        return defaultSection;
    }

    public void setDefaultSection(boolean defaultSection) {
        this.defaultSection = defaultSection;
    }

    // Constructor

    public Section(int IDSection, String name, String shortName, String description, int dependencyID, boolean enabled, boolean defaultSection) {
        this.IDSection = IDSection;
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.dependencyID = dependencyID;
        this.enabled = enabled;
        this.defaultSection = defaultSection;
    }

    // Metodos Parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(IDSection);
        dest.writeString(name);
        dest.writeString(shortName);
        dest.writeString(description);
        dest.writeInt(dependencyID);
        dest.writeByte((byte) (enabled ? 1 : 0));
        dest.writeByte((byte) (defaultSection ? 1 : 0));
    }


}
