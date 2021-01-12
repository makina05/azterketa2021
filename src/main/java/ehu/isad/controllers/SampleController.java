package ehu.isad.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import ehu.isad.db.SampleDBKud;
import ehu.isad.model.Laguntzailea;
import ehu.isad.utils.MessageDigestForUrl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import java.security.*;
import java.io.InputStream;

import static ehu.isad.utils.MessageDigestForUrl.getDigest;

public class SampleController {
    private ObservableList<Laguntzailea> data;
    private String uri;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn;

    @FXML
    private TableView<Laguntzailea> tbId;

    @FXML
    private TableColumn<Laguntzailea, String> urlcol;

    @FXML
    private TableColumn<Laguntzailea, Integer> md5col;

    @FXML
    private TableColumn<Laguntzailea, String> vcol;

    @FXML
    private TextField txtFid;

    @FXML
    private Text txt;

    @FXML
    void onClick(ActionEvent event) throws NoSuchAlgorithmException, IOException {
        uri = txtFid.getText();
        uri = uri + "/README";
        String hash = strToMd5(uri);
        Laguntzailea lag;
        lag = SampleDBKud.getInstance().dbnBadago(hash);
        if (lag != null){
            this.kargatuTaula(lag);
            txt.setText("Datubasean zegoen");
        }else{
            txt.setText("Ez dago Datubasean");
        }
    }

    @FXML
    void initialize() {

    }

    private void kargatuTaula(Laguntzailea lag) {
        lag.setUrl(txtFid.getText());
        data = FXCollections.observableArrayList(lag);
        urlcol.setCellValueFactory(new PropertyValueFactory<>("url"));
        md5col.setCellValueFactory( new PropertyValueFactory<>("md5"));
        vcol.setCellValueFactory( new PropertyValueFactory<>("version"));

        tbId.setItems(data);
    }
    String digest;
    private String strToMd5(String uri) throws IOException, NoSuchAlgorithmException {
        try{
            URL url = new URL(uri);
            InputStream is = url.openStream();
            MessageDigest md = MessageDigest.getInstance("MD5");
            digest = getDigest(is, md, 2048);

        }catch (MalformedURLException e) {
            e.printStackTrace();
            txt.setText("Ez da URL bat");
        }catch (IOException e){
            e.printStackTrace();
        }
        return digest;
    }


}


