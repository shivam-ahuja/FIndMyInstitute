package ahuja.shivam.findmyinstitute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
  Created by root on 22/4/17.
 */


public class DataPojoClass {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("i_name")
    @Expose
    private String iName;
    @SerializedName("i_fees")
    @Expose
    private String iFees;
    @SerializedName("i_course1")
    @Expose
    private String iCourse1;
    @SerializedName("i_course2")
    @Expose
    private String iCourse2;
    @SerializedName("i_course3")
    @Expose
    private String iCourse3;
    @SerializedName("i_address")
    @Expose
    private String iAddress;
    @SerializedName("i_phoneno")
    @Expose
    private String iPhoneno;
    @SerializedName("i_city")
    @Expose
    private String iCity;
    @SerializedName("i_emailid")
    @Expose
    private String iEmailid;
    @SerializedName("i_image")
    @Expose
    private String iImage;
    @SerializedName("i_details")
    @Expose
    private String iDetails;
    @SerializedName("i_course1_detail")
    @Expose
    private String iCourse1Detail;
    @SerializedName("i_couse2_detail")
    @Expose
    private String iCouse2Detail;
    @SerializedName("i_couse3_detail")
    @Expose
    private String iCouse3Detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIName() {
        return iName;
    }

    public void setIName(String iName) {
        this.iName = iName;
    }

    public String getIFees() {
        return iFees;
    }

    public void setIFees(String iFees) {
        this.iFees = iFees;
    }

    public String getICourse1() {
        return iCourse1;
    }

    public void setICourse1(String iCourse1) {
        this.iCourse1 = iCourse1;
    }

    public String getICourse2() {
        return iCourse2;
    }

    public void setICourse2(String iCourse2) {
        this.iCourse2 = iCourse2;
    }

    public String getICourse3() {
        return iCourse3;
    }

    public void setICourse3(String iCourse3) {
        this.iCourse3 = iCourse3;
    }

    public String getIAddress() {
        return iAddress;
    }

    public void setIAddress(String iAddress) {
        this.iAddress = iAddress;
    }

    public String getIPhoneno() {
        return iPhoneno;
    }

    public void setIPhoneno(String iPhoneno) {
        this.iPhoneno = iPhoneno;
    }

    public String getICity() {
        return iCity;
    }

    public void setICity(String iCity) {
        this.iCity = iCity;
    }

    public String getIEmailid() {
        return iEmailid;
    }

    public void setIEmailid(String iEmailid) {
        this.iEmailid = iEmailid;
    }

    public String getIImage() {
        return iImage;
    }

    public void setIImage(String iImage) {
        this.iImage = iImage;
    }

    public String getIDetails() {return iDetails;}

    public void setIDetails(String iDetails) {this.iDetails = iDetails;}

    public String getICourse1Detail() {return iCourse1Detail;}

    public void setICourse1Detail(String iCourse1Detail) {this.iCourse1Detail = iCourse1Detail;}

    public String getICouse2Detail() {return iCouse2Detail;}

    public void setICouse2Detail(String iCouse2Detail) {this.iCouse2Detail = iCouse2Detail;}

    public String getICouse3Detail() {return iCouse3Detail;}

    public void setICouse3Detail(String iCouse3Detail) {this.iCouse3Detail = iCouse3Detail;}

}
