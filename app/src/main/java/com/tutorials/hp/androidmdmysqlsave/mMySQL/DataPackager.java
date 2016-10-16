package com.tutorials.hp.androidmdmysqlsave.mMySQL;

import com.tutorials.hp.androidmdmysqlsave.mDataObject.Spacecraft;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * Created by Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class DataPackager {

    Spacecraft spacecraft;

    public DataPackager(Spacecraft spacecraft) {
        this.spacecraft = spacecraft;
    }

    public String packData()
    {
        JSONObject jo=new JSONObject();
        StringBuffer sb=new StringBuffer();

        try {
            jo.put("Name",spacecraft.getName());
            jo.put("Propellant",spacecraft.getPropellant());
            jo.put("Description",spacecraft.getDescription());

            Boolean firstvalue=true;
            Iterator it=jo.keys();

            do {
                String key=it.next().toString();
                String value=jo.get(key).toString();

                if(firstvalue)
                {
                    firstvalue=false;
                }else
                {
                    sb.append("&");
                }

                sb.append(URLEncoder.encode(key,"UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(value,"UTF-8"));

            }while (it.hasNext());

            return sb.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
