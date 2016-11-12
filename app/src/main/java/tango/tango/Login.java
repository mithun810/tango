package tango.tango;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class Login extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v= inflater.inflate(R.layout.login, container, false);
        final EditText username=(EditText)v.findViewById(R.id.username);
        final EditText password=(EditText)v.findViewById(R.id.password);
//Login button Action Listener
        final Button button1 = (Button)v.findViewById(R.id.btnLogin);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View vi) {
                ((TextView) v.findViewById(R.id.login_text)).setText("Login");
                AsyncHttpClient client =new AsyncHttpClient();
                Map<String, String> params1 = new HashMap<>();
                params1.put("username", username.getText().toString());
                params1.put("password", password.getText().toString());
                String json = new JSONObject(params1).toString();
                Log.d("syndeo", json);
                RequestParams params = new RequestParams();
                params.put("username", username.getText().toString());
                params.put("password", password.getText().toString());
                params.setUseJsonStreamer(true);
                params.setElapsedFieldInJsonStreamer(null);
                client.addHeader("Content-Type","application/json");
                client.post(getActivity().getApplicationContext(),"http://10.100.2.158:8000/auth/login/",new StringEntity(json, "UTF-8"),"application/json", new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Log.d("zeus", response.toString());
                        ((MainActivity) getActivity()).redirect();
                    }

//                    }
                });



                /*try {
                    ((MainActivity) getActivity()).loginpost();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
            }
        });
        return v;


    }




}
