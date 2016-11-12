package tango.tango;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class Register extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.register, container, false);


        final EditText username=(EditText)v.findViewById(R.id.reg_username);
        final EditText password=(EditText)v.findViewById(R.id.reg_password);
        final EditText mail=(EditText)v.findViewById(R.id.reg_email);
        final Button button1 = (Button)v.findViewById(R.id.btnRegister);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View vi) {

                AsyncHttpClient client =new AsyncHttpClient();




                Map<String, String> params1 = new HashMap<>();
                params1.put("username", username.getText().toString());
                params1.put("password", password.getText().toString());
                params1.put("email", mail.getText().toString());
                String json = new JSONObject(params1).toString();
                Log.d("syndeo", json);
                RequestParams params = new RequestParams();
                params.put("username", username.getText().toString());
                params.put("password", password.getText().toString());
                params.setUseJsonStreamer(true);
                params.setElapsedFieldInJsonStreamer(null);
                client.addHeader("Content-Type","application/json");
                client.post(getActivity().getApplicationContext(),"http://10.100.2.158:8000/auth/register/",new StringEntity(json, "UTF-8"),"application/json", new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Log.d("zeus", response.toString());
                        ((MainActivity) getActivity()).redirect1();
                    }

//                    }
                });

            }
        });

        return v;
    }
}
