/**
 * Created by S2D on 1/19/2015.
 */

package jconnection;

import org.json.JSONArray;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Queries extends Connect{

    public JSONArray getDesc(int id) throws Exception{

        PreparedStatement query = null;
        Connection conn = null;
        Convert converter = new Convert();
        JSONArray array = new JSONArray();

        try{
            conn = connect();
            query = conn.prepareStatement("select `desc` from institutions where id = ?");
            query.setInt(1,id);
            ResultSet rs = query.executeQuery();
            array = converter.toJSONArray(rs);

            query.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return array;
        }
        finally {
            if(conn != null){conn.close();}
        }

        return array;
    }

    public JSONArray getNameAndLocation(int id) throws Exception{

        PreparedStatement query = null;
        Connection conn = null;
        Convert converter = new Convert();
        JSONArray array = new JSONArray();

        try{
            conn = connect();
            query = conn.prepareStatement("select name,location from institutions where id = ?");
            query.setInt(1,id);
            ResultSet rs = query.executeQuery();
            array = converter.toJSONArray(rs);

            query.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return array;
        }
        finally {
            if(conn != null){conn.close();}
        }

        return array;
    }

    public JSONArray getEverything() throws Exception{

        PreparedStatement query = null;
        Connection conn = null;
        Convert converter = new Convert();
        JSONArray array = new JSONArray();

        try {
            conn = connect();
            query = conn.prepareStatement("select * from institutions");
            ResultSet rs = query.executeQuery();
            array = converter.toJSONArray(rs);

            query.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return array;
        }
        finally {
            if(conn != null){conn.close();}
        }

        return array;
    }
}
