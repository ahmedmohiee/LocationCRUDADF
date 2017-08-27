package view;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationBean {
    private int locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryId;

    public LocationBean() {
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @JsonProperty("locationId")
    public int getLocationId() {
        return locationId;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @JsonProperty("streetAddress")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @JsonProperty("stateProvince")
    public String getStateProvince() {
        return stateProvince;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("countryId")
    public String getCountryId() {
        return countryId;
    }

}
