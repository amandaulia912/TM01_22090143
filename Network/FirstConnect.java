package Network;

import Model.ResponseModel;
import Network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class    FirstConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL("https://harber.mimoapps.xyz/api/getaccess.php");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        System.out.println(response);

        JSONArray ResponseJSON = new JSONArray(response);
        ArrayList<ResponseModel> responseModels = new ArrayList<>();
        int i;
        for (i = 0; i < ResponseJSON.length(); i++) ;
        ResponseModel reModel = new ResponseModel();
        JSONObject myJSONObject = ResponseJSON.getJSONObject(i);
        reModel.setMsg(myJSONObject.getString("message"));
        reModel.setStatus(myJSONObject.getString("status"));
        reModel.setStatus(myJSONObject.getString("comment"));
        responseModels.add(reModel);
    }

}