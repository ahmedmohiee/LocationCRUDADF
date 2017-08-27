package view;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

public class Update {
    
    private int locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    List<LocationBean> locationList = new ArrayList<>();

    public void setLocationList(List<LocationBean> locationList) {
        this.locationList = locationList;
    }

    public List<LocationBean> getLocationList() {
        return locationList;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryId() {
        return countryId;
    }
    private String countryId;

    public void post(ActionEvent actionEvent) {

        try {
            System.out.println("Enter");

            Client client = Client.create();

            WebResource webResource =
                client.resource("http://127.0.0.1:7101/LocationRest-location-context-root/resources/service/"+locationId);
            LocationBean locations = new LocationBean();
            locations.setCity(getCity());
            locations.setCountryId(getCountryId());
//            locations.setLocationId(getLocationId());
            locations.setPostalCode(getPostalCode());
            locations.setStateProvince(getStateProvince());
            locations.setStreetAddress(getStreetAddress());
            System.out.println("Enter");
            System.out.println("locations"+locations.getCity());
    //            locationList.add(locations);
            
            System.out.println("locations");
           // System.out.println(locationList);

            //
            //            String input =
            //                "{\"city\" : \"RomaMohiee\",\n" + " \"countryId\" : \"IT\",\n" + " \"locationId\" : 1963,\n" +
            //                " \"postalCode\" : \"00989\",\n" + " \"streetAddress\" : \"1297 Via Cola di Rie\"}";

            //            System.out.println(input);
            ClientResponse response = webResource.type("application/json").put(ClientResponse.class, locations);
            if (response.getStatus() != 200 && response.getStatus() != 204) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            System.out.println("Output from Server .... \n");
            //            String output = response.getEntity(String.class);
            //            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    
}
