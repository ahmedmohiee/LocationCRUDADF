package view;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

public class Search {
   
    private Integer id;
    List<LocationBean> personList = new ArrayList<LocationBean>();

    public void setPersonList(List<LocationBean> personList) {
        this.personList = personList;
    }

    public List<LocationBean> getPersonList() {
        return personList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        System.out.println("Inside getID");
        return id;
    }

    public void getByLocationId(ActionEvent actionEvent) {

        try {
            personList.clear(); 
            //            ClientConfig config = new DefaultClientConfig();
            //                config.getClasses().add(JacksonJaxbJsonProvider.class);
            //                config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

            //                Client c = Client.create(config);
            Client client = Client.create();
            //            int locId = 1099;
            WebResource webResource =
                client.resource("http://127.0.0.1:7101/LocationRest-location-context-root/resources/service/" + id);


            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);


            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            LocationBean locations = response.getEntity(new GenericType<LocationBean>() {
            });
            if (id == locations.getLocationId()) {
System.out.println(locations.getStreetAddress());
            }
           
           personList.clear(); 
            personList.add(locations);

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
