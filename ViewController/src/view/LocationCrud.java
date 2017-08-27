package view;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.ws.rs.core.MediaType;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.event.ColumnSelectionEvent;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;

public class LocationCrud {
//        public static void main(String[] args) {
//          LocationCrud loc = new LocationCrud()  ;
//          loc.getByLocationId();
//       }
    private int id;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        System.out.println("Inside getID");
        return id;
    }

    List<LocationBean> locationList = new ArrayList<>();

    public void setLocationList(List<LocationBean> locationList) {
        this.locationList = locationList;
    }

    public List<LocationBean> getLocationList() {
        return locationList;
    }

    public void getAllLocations(ActionEvent actionEvent) {


        try {

            //            ClientConfig config = new DefaultClientConfig();
            //                config.getClasses().add(JacksonJaxbJsonProvider.class);
            //                config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

            //                Client c = Client.create(config);
            Client client = Client.create();
            WebResource webResource =
                client.resource("http://127.0.0.1:7101/LocationRest-location-context-root/resources/service/" );


            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);


            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            List<LocationBean> locations = response.getEntity(new GenericType<List<LocationBean>>() {
            });




            //            if (locations != null) {
            //
            //                for (LocationBean item : locations) {
            //                    System.out.println(item.getStreetAddress());
            //                }
            //                System.out.println("locations not null");
            //                System.out.println(locations.size());
            //            } else {
            //                System.out.println("locations is null");
            //            }
            //            String output = response.getEntity(String.class);
            // JsonString json = response.getEntity(JsonString.class);

            System.out.println("Output from Server .... \n");
            //            System.out.println(output);


                        setLocationList(locations);


            //            ArrayList<String> listdata = new ArrayList<String>();
            //          ;
            //            if (jArray != null) {
            //               for (int i=0;i<jArray.length();i++){
            //                listdata.add(jArray.getString(i));
            //               }
            //            }
            //
        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    public void post() {

        try {

            Client client = Client.create();

            WebResource webResource =
                client.resource("http://127.0.0.1:7101/LocationRest-location-context-root/resources/service/addLoc");

            String input =
                "{\"city\" : \"RomaMohiee\",\n" + " \"countryId\" : \"IT\",\n" + " \"locationId\" : 1963,\n" +
                " \"postalCode\" : \"00989\",\n" + " \"streetAddress\" : \"1297 Via Cola di Rie\"}";

            System.out.println(input);
            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
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

    public void update(AttributeChangeEvent attributeChangeEvent) {

        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);

            String x = "1963";
            //            WebResource webResource =
            //                client.resource("http://127.0.0.1:7101/LocationRest-location-context-root/resources/service/"+x);
            LocationBean loc = new LocationBean();


            String postURL = "http://127.0.0.1:7101/LocationRest-location-context-root/resources/service/" + x;
            WebResource webResourcePost = client.resource(postURL);
            ClientResponse response = webResourcePost.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, loc);
            LocationBean responseEntity = response.getEntity(LocationBean.class);
            //            ClientResponse response = resource.accept("application/json").put(Location.class);

            //            String input =
            //            "{\"city\" : \"RomaMohiee1\",\n" + " \"countryId\" : \"IT\",\n" +
            //            " \"postalCode\" : \"00989\",\n" + " \"streetAddress\" : \"1297 Via Cola di Rie\"}";
            //
            //            System.out.println(input);


            //                        ClientResponse response = webResourcePost.type("application/json")
            //                                   .post(ClientResponse.class, loc);
            //
            //            ClientResponse response = webResource.type("application/json").
            //                                                  accept(MediaType.APPLICATION_JSON).
            //                                                  put(Location.class, loc);


            if (response.getStatus() != 200 && response.getStatus() != 204) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            System.out.println("Output from Server .... \n");
            //            String output = response.getEntity(String.class);
            System.out.println(responseEntity.getCity());

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void getByLocationId(ActionEvent actionEvent) {

        try {

            //            ClientConfig config = new DefaultClientConfig();
            //                config.getClasses().add(JacksonJaxbJsonProvider.class);
            //                config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

            //                Client c = Client.create(config);
            Client client = Client.create();
            int locId = 1099;
            WebResource webResource =
                client.resource("http://127.0.0.1:7101/LocationRest-location-context-root/resources/service/" + locId);


            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);


            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            LocationBean locations = response.getEntity(new GenericType<LocationBean>() {
            });

            System.out.println(locations.getCity());
            setId(locations.getLocationId());
            System.out.println(getId());


            //            if (locations != null) {
            //
            //                for (LocationBean item : locations) {
            //                    System.out.println(item.getStreetAddress());
            //                }
            //                System.out.println("locations not null");
            //                System.out.println(locations.size());
            //            } else {
            //                System.out.println("locations is null");
            //            }
            //            String output = response.getEntity(String.class);
            // JsonString json = response.getEntity(JsonString.class);

            System.out.println("Output from Server .... \n");
            //            System.out.println(output);


            //            setLocationList(locations);


            //            ArrayList<String> listdata = new ArrayList<String>();
            //          ;
            //            if (jArray != null) {
            //               for (int i=0;i<jArray.length();i++){
            //                listdata.add(jArray.getString(i));
            //               }
            //            }
            //
        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
