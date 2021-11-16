package com.example.fortuneteller;


import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


class JokeApi {
    String urlText = "http://yerkee.com/api/fortune";

    public String getJoke() {
        HttpURLConnection con = null;
        try{
            URL url = new URL(urlText);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        }
        catch(Exception e){
            Log.e("error: ", e.toString());
        }
        finally {
            con.disconnect();
        }
        return null;
    }
}