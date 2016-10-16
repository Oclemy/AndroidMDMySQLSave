package com.tutorials.hp.androidmdmysqlsave.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorials.hp.androidmdmysqlsave.mDataObject.Spacecraft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

/**
 * Created by Oclemy on 5/15/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class Sender extends AsyncTask<Void,Void,String> {

    Context c;
    String urlAddress;
    EditText nameTxt,propellantTxt,descTxt;

    Spacecraft spacecraft;

    ProgressDialog pd;

    public Sender(Context c, String urlAddress, EditText nameTxt, EditText propellantTxt, EditText descTxt) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.nameTxt = nameTxt;
        this.propellantTxt = propellantTxt;
        this.descTxt = descTxt;

        spacecraft=new Spacecraft();
        spacecraft.setName(nameTxt.getText().toString());
        spacecraft.setPropellant(propellantTxt.getText().toString());
        spacecraft.setDescription(descTxt.getText().toString());
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Send");
        pd.setMessage("Sending...Please wait");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        return this.send();
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        pd.dismiss();

        if(s==null)
        {
            Toast.makeText(c,"Unsuccessful,Null returned",Toast.LENGTH_SHORT).show();
        }else
        {
            if(s=="Bad Response")
            {
                Toast.makeText(c,"Unsuccessful,Bad Response returned",Toast.LENGTH_SHORT).show();

            }else
            {
                Toast.makeText(c,"Successfully Saved",Toast.LENGTH_SHORT).show();

                //CLEAR UI
                nameTxt.setText("");
                propellantTxt.setText("");
                descTxt.setText("");
            }
        }


    }

    private String send()
    {
        HttpURLConnection con=Connector.connect(urlAddress);
        if(con==null)
        {
            return null;
        }

        try {

            OutputStream os=con.getOutputStream();

            //WRITE
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            bw.write(new DataPackager(spacecraft).packData());

            bw.flush();
            //RELEASE
            bw.close();
            os.close();

            //SUCCESS OR NOT??
            int responseCode=con.getResponseCode();
            if(responseCode==con.HTTP_OK)
            {
                BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer response=new StringBuffer();

                String line;
                while ((line=br.readLine()) != null)
                {
                    response.append(line);
                }

                br.close();
                return response.toString();
            }else {
                return "Bad Response";
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}



















