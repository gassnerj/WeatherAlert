/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatheralert;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Jason
 */
public class Alert {

    public static JsonNode GetJsonNode(String url) {
    try
    {

    	JsonFactory factory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper(factory);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        URL wxUrl = new URL(url);
        JsonNode rootNode = mapper.readTree(wxUrl);

        if(rootNode.findValue("features") != null) {
            Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
            while (fieldsIterator.hasNext()) {

                Map.Entry<String,JsonNode> field = fieldsIterator.next();

                if(field.getKey() == "features") {
                	String mapAsJson = new ObjectMapper().writeValueAsString(field.getValue());
                	JsonNode subNode = mapper.readTree(mapAsJson);

                	for(int i = 0; i < subNode.size(); ++i) {
                		Iterator<JsonNode> IDnode = subNode.get(i).elements();
                		while (IDnode.hasNext()) {
                			JsonNode field2 = IDnode.next();
                			Alert.MakeMap(field2);
                		}
                	}
                }
            }
        } else {
        	return rootNode;
        }

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
	return null;
    }

    @SuppressWarnings("null")
	public static HashMap<String,JsonNode> MakeMap(JsonNode node) {
		if (node != null) {
			if(node.path("id") != null) {
				JsonNode idNode = node.path("id");
				JsonNode eventNode = node.path("event");
				JsonNode severityNode = node.path("severity");
				JsonNode headlineNode = node.path("headline");
    			JsonNode hailSizeNode = node.path("parameters").path("hailSize");
    			JsonNode windGustNode = node.path("parameters").path("windGust");

    			HashMap<String, JsonNode> map = new HashMap<String, JsonNode>();

				map.put("id", idNode);
				map.put("event", eventNode);
				map.put("severity", severityNode);
				map.put("headline", headlineNode);
				map.put("hailSize", hailSizeNode);
				map.put("windGust", windGustNode);

				System.out.println(idNode + " " + eventNode + " " + severityNode + " " + headlineNode + " " + hailSizeNode + " " + windGustNode);
				return map;

			}

		} else {
    		JsonNode idNode = node.findValue("id");
    		JsonNode severityNode = node.findValue("severity");
    		JsonNode eventNode = node.findValue("event");
    		JsonNode headlineNode = node.findValue("headline");
    		JsonNode hailSizeNode = node.findValue("hailSize");
    		JsonNode windGustNode = node.findValue("hailSizeNode");

			HashMap<String, JsonNode> map = new HashMap<String, JsonNode>();

			map.put("id", idNode);
			map.put("event", eventNode);
			map.put("severity", severityNode);
			map.put("headline", headlineNode);
			map.put("hailSize", hailSizeNode);
			map.put("windGust", windGustNode);

			System.out.println(idNode + " " + eventNode + " " + severityNode + " " + headlineNode + " " + hailSizeNode + " " + windGustNode);
			return map;
		}
		return null;
    }
    public static void main(String []args) {

    }
}
