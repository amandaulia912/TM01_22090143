import Model.ResponseModel;
import Network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GUI_TM01 {
    public JPanel getMain() {
        return Main;
    }
    public JPanel Main;
    private JTextField message;
    private JTextField status;
    private JTextField comment;
    private JButton exitButton;

    public JButton getButton1() {
        return button1;
    }
    private JButton button1;
    private JButton submitButton;

    public GUI_TM01() {

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message.setText("");
                status.setText("");
                comment.setText("");
                try {
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
                } catch (IOException exception) {
                    throw new RuntimeException(exception);
                } finally {
                };
                for(ResponseModel respond : ResponseModel){
                    message.setText(respond.getMsg());
                    status.setText(respond.getStatus());
                    comment.setText(respond.getComment());
                }
            };catch (Exception ex){
                System.out.println(ex);
            }
    });
    }
}
