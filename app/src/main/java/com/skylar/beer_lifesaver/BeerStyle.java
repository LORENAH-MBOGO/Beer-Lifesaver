
package com.skylar.beer_lifesaver;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeerStyle implements Parcelable
{

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("status")
    @Expose
    private String status;
    public final static Parcelable.Creator<BeerStyle> CREATOR = new Creator<BeerStyle>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BeerStyle createFromParcel(Parcel in) {
            return new BeerStyle(in);
        }

        public BeerStyle[] newArray(int size) {
            return (new BeerStyle[size]);
        }

    }
    ;

    protected BeerStyle(Parcel in) {
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (com.skylar.beer_lifesaver.Datum.class.getClassLoader()));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public BeerStyle() {
    }

    /**
     * 
     * @param data
     * @param message
     * @param status
     */
    public BeerStyle(String message, List<Datum> data, String status) {
        super();
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(message);
        dest.writeList(data);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
