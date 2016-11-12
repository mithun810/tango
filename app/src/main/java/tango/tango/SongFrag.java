package tango.tango;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * A placeholder fragment containing a simple view.
 */
public class SongFrag extends Fragment {

    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static SongFrag newInstance(int page, String title) {
        SongFrag fragmentFirst = new SongFrag();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /////////////////////////
        /*
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

*/
        ///////////////////////////
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.songfrag, container, false);
        return view;
    }
}
