package aurora.tech.testcards;

import android.os.Parcel;
import android.os.Parcelable;

public class Services implements Parcelable {
    private String serviceTitle;
    private int serviceImage;
    private String servicePrice;
    private int serviceID;

    public Services(String serviceTitle, int serviceImage, String servicePrice, int serviceID) {
        this.serviceTitle = serviceTitle;
        this.serviceImage = serviceImage;
        this.servicePrice = servicePrice;
        this.serviceID = serviceID;
    }

    protected Services(Parcel in) {
        serviceTitle = in.readString();
        serviceImage = in.readInt();
        servicePrice = in.readString();
        serviceID = in.readInt();
    }

    public static final Creator<Services> CREATOR = new Creator<Services>() {
        @Override
        public Services createFromParcel(Parcel in) {
            return new Services(in);
        }

        @Override
        public Services[] newArray(int size) {
            return new Services[size];
        }
    };

    public int getServiceID() {
        return serviceID;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public int getServiceImage() {
        return serviceImage;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(serviceTitle);
        dest.writeInt(serviceImage);
        dest.writeString(servicePrice);
        dest.writeInt(serviceID);
    }
}
