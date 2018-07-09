import java.util.Set;
import java.util.HashMap;

public class Screen{
    //room should have description and list of exits
    private String description;
    private HashMap<String, Screen> exits;

    public Screen (String description){
        //declare
        this.description = description;
        //define
        exits = new HashMap<>();
    }

    public void setExits(String direction, Screen next) {
        //put is the equivalent of add in hashmaps
        exits.put(direction, next);
    }

    public String getShortDescription() {
        return description;
    }


    //define getExitString

    private String getExitString() {
        String returnString = "Leaving: ";
        //pull keys from hashmap
        Set<String> keys = exits.keySet();
        for(String exit: keys) {
            //+= means equals the same value plus something new
            returnString += " " + exit;
        } 
        return returnString;
    }

    public Screen getExit(String direction){
        return exits.get(direction);
    }
}