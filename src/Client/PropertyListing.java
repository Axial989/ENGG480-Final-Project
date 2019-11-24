package Client;

import java.io.Serializable;
import java.util.ArrayList;

public class PropertyListing implements Serializable{
	private static final long serialVersionUID = 1L;

    private ArrayList<Property> properties;

    public PropertyListing(ArrayList<Property> properties){
        this.properties = properties;
    }

    public PropertyListing() {
		this.properties = null;
	}

	public void addNewListing(Property p){
        properties.add(p);
    }

    public void removeListing(Property p){
        properties.remove(p);
    }
}