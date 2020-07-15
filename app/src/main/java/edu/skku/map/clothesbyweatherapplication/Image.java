package edu.skku.map.clothesbyweatherapplication;

import java.util.HashMap;
import java.util.Map;

public class Image {
    public String id;
    public String imguri;
    public String memo;

    public Image(){

    }

    public Image(String id, String imguri, String memo){
        this.id = id;
        this.imguri = imguri;
        this.memo = memo;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("imguri", imguri);
        result.put("memo", memo);
        return result;
    }
}
