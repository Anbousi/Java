import java.util.HashMap;
import java.util.Set;


public class Hashmatique{
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Bad Bunny" , "Yonaguni");
        trackList.put("Maneskin" , "ZITTI E BUONI");
        trackList.put("John Mayer" , "Last Train Home");
        trackList.put("James Arthur" , "September");

        String song = trackList.get("Bad Bunny");
        System.out.println(song+"\n");

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key +" : " + trackList.get(key) );
        }
    }
}