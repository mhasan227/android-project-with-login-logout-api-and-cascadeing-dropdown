package com.example.maxisloginlogout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import login.Demo;
import login.LogInRes;

public class MainActivity extends AppCompatActivity {

    Button logInBtn;
    EditText userName;
    EditText passWord;
    private MainActivity ma;
    Menu menu;
    DrawerLayout mDrawer;

    private Toolbar toolbar;




    String covertFunc(String response){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<Demo>(){}.getType();
        Demo design = gson.fromJson(response, typeListOfDesign);

        Log.i("data", design.getResult().getTanentId());
        String myid= design.getResult().getTanentId();
        //Demo rp=design;
        if(design.getResult().getResult().equals("SUCCESS")) {
            openInsideActivity4(response);
        }

    return response;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         toolbar = (Toolbar) findViewById(R.id.toolbar);

        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        // method to inflate the options menu when
        // the user opens the menu for the first time

        /*drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);*/





        ma= this;
        userName = (EditText) findViewById(R.id.et_username);
        passWord = (EditText) findViewById(R.id.et_password);

        logInBtn = (Button)findViewById(R.id.bt_Login);


        logInBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (userName.getText().toString().trim().equals("")) {
                    userName.setError("Email is required");

                } else if (passWord.getText().toString().trim().equals("")) {
                    passWord.setError("Password is required");
                }
                else{
                    onLogin(null);


                }
            }
        });
         //mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        //For set Action bar
//        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
//        getSupportActionBar().setTitle("My new title"); // set the top title
//        String title = actionBar.getTitle().toString(); // get the title
//
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.mipmap.imgpsh_fullsize_anim);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);


    }



    /*
    // method to inflate the options menu when
    // the user opens the menu for the first time
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.findItem(R.id.action_settings).setEnabled(false);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return false;

//            case R.id.action_favorite:
//                // User chose the "Favorite" action, mark the current item
//                // as a favorite...
//                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }*/


    public void onLogin(View view){
        final String username = userName.getText().toString();
        final String mypassword = passWord.getText().toString();



        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://maxisservice-api-gateway-maxis.nagadpay.com/maxisservice-authentication-service/endpoint/oauth/login";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("username", "bht02a01" );
            jsonBody.put("password", "Nopass@1234");
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    String parsed = "";

                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                        try {
                            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                        } catch (UnsupportedEncodingException e) {
                            parsed = new String(response.data);
                        }

                        ma.covertFunc(parsed);
                        System.out.println(parsed);
                    }

                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }

            };

            requestQueue.add(stringRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /*// 2 - Configure Drawer Layout
    private void configureDrawerLayout(){
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    // 3 - Configure NavigationView
    private void configureNavigationView(){
        this.navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) MainActivity.this);
    }*/



    public void openInsideActivity4(String myid)
    {   //Demo cust=new Demo(myid);

        Intent intent = new Intent(this,Home.class);
        intent.putExtra("EXTRA_SESSION_ID",  myid);
        startActivity(intent);
    }
}