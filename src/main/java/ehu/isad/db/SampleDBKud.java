package ehu.isad.db;

import ehu.isad.controllers.SampleController;
import ehu.isad.model.Laguntzailea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SampleDBKud {
    private static final SampleDBKud instance = new SampleDBKud();

    public static SampleDBKud getInstance(){
        return instance;
    }

    private SampleDBKud(){
    }

    public Laguntzailea dbnBadago(String hash){
        String query = "select * from checksums where md5 like '"+hash+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        Laguntzailea emaitza = null;
        try{
            while (rs.next()){

                Integer idCMS = rs.getInt("idCMS");
                String version = rs.getString("version");
                String md5 = rs.getString("md5");
                String path = rs.getString("path");
                String url = "";

                //emaitza gordetzeko Laguntzaile klasea erabiliko dugu

                Laguntzailea laguntzailea = new Laguntzailea(idCMS,version,md5,path,url);
                emaitza = laguntzailea;

            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }
}
