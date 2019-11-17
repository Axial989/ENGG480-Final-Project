public class PropertyListing{
    private ArrayList<Property> properties;

    public PropertyListing(ArrayList<Property> properties){
        this.properties = properties;
    }

    public void addNewListing(Property p){
        properties.add(p);
    }

    public void removeListing(Property p){
        properties.remove(p);
    }
}