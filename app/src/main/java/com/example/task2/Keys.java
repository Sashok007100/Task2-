package com.example.task2;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Keys implements Parcelable {

    @SerializedName("graphic")
    @Expose
    private String graphic;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("helptext")
    @Expose
    private String helptext;


    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelptext() {
        return helptext;
    }

    public void setHelptext(String helptext) {
        this.helptext = helptext;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(graphic);
        dest.writeString(name);
        dest.writeString(helptext);
    }

    private Keys(Parcel in) {
        graphic = in.readString();
        name = in.readString();
        helptext = in.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public Keys createFromParcel(Parcel in) {
            return new Keys(in);
        }

        public Keys[] newArray(int size) {
            return new Keys[size];
        }
    };

    public Keys() {
    }

    @Override
    public String toString() {
        return "Keys{" + "graphic='" + graphic + '\'' + ", name='" + name + '\'' + ", helptext='" + helptext + '\'' + '}';
    }
}
