package tango.tango;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

class RestUtil{
    static String baseurl= "http://10.100.2.158.8000/";
    static String loginurl=baseurl+"auth/login/";
    static String LoginPost(Context context,String json){
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Content-Type", "application/json");
        client.post(context, baseurl + loginurl, new StringEntity(json, "UTF-8"), "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.d("zeus", response.toString());
            }

        });
        return null;
    }
}