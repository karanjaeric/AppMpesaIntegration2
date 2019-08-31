package com.innovatah.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button paymentButton=findViewById(R.id.btn_payment);
        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject postparams=null;
                try{
                    postparams=new JSONObject();
                    postparams.put("phoneNumber","0702332833");
                    postparams.put("amount",10000);

                }catch(Exception e){


                }

//                Toast.makeText(MainActivity.this, "You clicked me",
//                        Toast.LENGTH_LONG).show();
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        "http://68.183.231.130:8080/SaccoManagement/saccoloanrepayment", postparams,
                        new Response.Listener() {

                            @Override
                            public void onResponse(Object response) {

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }

                        }){
                    @Override
                    public Map getHeaders() throws AuthFailureError {
                        HashMap headers = new HashMap();
                        headers.put("Content-Type", "application/json");
                        return headers;
                    }
                };
                VolleySingleton.getVolleySingletonInstance(MainActivity.this).addToRequestque(jsonObjReq);
            }
        });
    }
}
