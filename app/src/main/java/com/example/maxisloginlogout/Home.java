package com.example.maxisloginlogout;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import api1listpartnerrole.DataHandle;
import apiforcreditcollection.CreditCollectionArray;
import apiforcreditcollection.CreditCollectionHandler;
import apiforcreditsale.CreditHandler;
import apiforcreditsale.CreditSales;
import apiresponsestatushandle.ResponseHandle;
import customervia.CustomerHandler;
import login.Demo;

public class Home extends AppCompatActivity implements Result {

    public String token;
    CreditHandler designCredit;
    DataHandle designST;
    private Home ma;
    private Result result;
    Spinner salesOfficer;
    Spinner customer;
    String dropDownId;
    EntityDropdown[] customers;

    EntityDropdown[] finalarray;
    EntityDropdown[] dropDownValue;
   private static EntityDropdown[] viaArray = new EntityDropdown[1];


    DataHandle designCsName;
    CustomerHandler[] designHand;

    Button btnS;
    Button btnD;
    Button btnS1;
    Button btnD1;

    TextView invNum;
    TextView invDat;
    TextView invAmn;
    TextView followDat;
    TextView inChooseBr;

    EditText invoiceNumber;
    EditText invoiceAmount;
    EditText invoiceDate;
    EditText followEDate;
    Button saveS;
    Button   browse;

    TextView dMoneyrNO;
    TextView dDat;
    TextView dAmn;
    TextView dChooseBr;

    EditText dMoneyrNOEdit;
    EditText dDatEdit;
    EditText dAmnEdit;
    Button   savedepo;
    Button   dbrowse;

    public static String invoiceAm;
    public static String invoiceNum;
    public static String invoDat;
    public static String followdatSt;
    public static String getTanent;
    public static String getUserId;

    public static String depositAm;
    public static String moneyReciptNum;
    public static String depoDat;

    TextView onSuccess;
    TextView onFail;
    TextView onSuccessDepo;
    TextView onFailDepo;

    public static ListView mList;
    public static ListView mListDepo;


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    static String myid;



//    public Home(Result result) {
//        super();
//        this.result = result;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viaArray[0] = new EntityDropdown("","","");
        setContentView(R.layout.home_activity);
        ma = this;
        this.mList = (ListView) findViewById(R.id.listView);
        this.mListDepo = (ListView) findViewById(R.id.listViewDepo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        //navbar start
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        //toggle.syncState();



        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.nav_home){
                    Toast.makeText(getApplicationContext(),"Hello home",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.nav_gallery){
                    Toast.makeText(getApplicationContext(),"Hello g",Toast.LENGTH_SHORT).show();
                }

                else if(id==R.id.nav_info){
                    openInsideActivity4(myid);
                }

                else if(id==R.id.nav_logout){
                    signOut();
                }

                return true;
            }
        });
        //navbar end

        Intent intent = getIntent();
         myid = getIntent().getStringExtra("EXTRA_SESSION_ID");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<Demo>() {
        }.getType();
        Demo design = gson.fromJson(myid, typeListOfDesign);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Hello " + design.getResult().getTanentId());

        getTanent= design.getResult().getTanentId();
        getUserId= design.getResult().getUserId();

        token = design.getResult().getAuthResponse().getId_token();
       /* bt_logout = (Button) findViewById(R.id.bt_logout);
        OnClick();*/
        Button logOutButton = (Button) findViewById(R.id.logOutButton);
        Button infoBtn = (Button) findViewById(R.id.infobtn);

        logOutButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                signOut();
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                openInsideActivity4(myid);


            }
        });


      /*  try {
            onApicallLm(null);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        onApiCallRoleSales();

        onApiCallTenantSales(null);
        onApiCallCreditCollection(null);


        salesOfficer
                = (Spinner)findViewById(R.id.spinner);
        //salesOfficer.setPrompt("Spinner Prompt Programatically!!!");


        customer
                = (Spinner)findViewById(R.id.spinner1);

         btnS=(Button) findViewById(R.id.button);
         //btnS.setVisibility(View.GONE);

         btnD=(Button) findViewById(R.id.button2);
        // btnD.setVisibility(View.GONE);
         btnS1=(Button) findViewById(R.id.button3);
         btnS1.setVisibility(View.GONE);
         btnD1=(Button) findViewById(R.id.button4);
         btnD1.setVisibility(View.GONE);

         invNum=(TextView) findViewById(R.id.textView3);
         invAmn=(TextView) findViewById(R.id.textView6);
         invDat=(TextView) findViewById(R.id.textView4);
         followDat=(TextView) findViewById(R.id.textView5);
        inChooseBr=(TextView) findViewById(R.id.textView7);
        saveS=(Button) findViewById(R.id.save);

        invoiceNumber=(EditText) findViewById(R.id.editMoneyRecNum) ;



        invoiceAmount=(EditText) findViewById(R.id.editTextInvoiceAmount) ;


        invoiceDate = (EditText) findViewById(R.id.datePicker);
        followEDate = (EditText) findViewById(R.id.datePicker2);
         browse=(Button) findViewById(R.id.browse);


         dMoneyrNO=(TextView) findViewById(R.id.textViewDepo3);
         dDat=(TextView) findViewById(R.id.textViewDepo4);
         dAmn=(TextView) findViewById(R.id.textViewDepo6);
         dChooseBr=(TextView) findViewById(R.id.textViewDepo7);
         savedepo=(Button) findViewById(R.id.saveDepo);

        dMoneyrNOEdit=(EditText) findViewById(R.id.editTextMoneyReNo);
        dDatEdit=(EditText) findViewById(R.id.datePickerdepo);
        dAmnEdit=(EditText) findViewById(R.id.editTextDepositeAmount);

        onSuccess=(TextView) findViewById(R.id.textView12);
        onFail=(TextView) findViewById(R.id.textView9);
        onSuccessDepo=(TextView)findViewById(R.id.depoSuccess) ;
        onFailDepo=(TextView)findViewById(R.id.depoFail);


        dbrowse=(Button) findViewById(R.id.browseDepo);

        dMoneyrNO.setVisibility(View.GONE);
        dDat.setVisibility(View.GONE);
        dAmn.setVisibility(View.GONE);
        dChooseBr.setVisibility(View.GONE);

        dMoneyrNOEdit.setVisibility(View.GONE);
        dDatEdit.setVisibility(View.GONE);
        dAmnEdit.setVisibility(View.GONE);
        savedepo.setVisibility(View.GONE);

        dbrowse.setVisibility(View.GONE);

        onSuccess.setVisibility(View.GONE);
        onFail.setVisibility(View.GONE);
        onSuccessDepo.setVisibility(View.GONE);
        onFailDepo.setVisibility(View.GONE);


        mListDepo.setVisibility(View.GONE);
        ScrollView sd= (ScrollView) findViewById(R.id.sd);
        sd.setVisibility(View.GONE);


        invoiceDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog

                DatePickerDialog datepicker = new DatePickerDialog(ma,

                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                //formatPick.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);



                                invoiceDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                            }
                        }, year, month, day);
                datepicker.show();
            }
        });


        followEDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog

                DatePickerDialog datepicker = new DatePickerDialog(ma,

                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                //formatPick.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);



                                followEDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                            }
                        }, year, month, day);
                datepicker.show();
            }
        });


        dDatEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog

                DatePickerDialog datepicker = new DatePickerDialog(ma,

                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                //formatPick.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);



                                dDatEdit.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                            }
                        }, year, month, day);
                datepicker.show();
            }
        });


        btnS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnS1.setVisibility(View.GONE);
                btnD1.setVisibility(View.GONE);
                btnS.setVisibility(View.VISIBLE);
                btnD.setVisibility(View.VISIBLE);


                dMoneyrNO.setVisibility(View.GONE);
                dDat.setVisibility(View.GONE);
                dAmn.setVisibility(View.GONE);
                dChooseBr.setVisibility(View.GONE);

                dMoneyrNOEdit.setVisibility(View.GONE);
                dDatEdit.setVisibility(View.GONE);
                dAmnEdit.setVisibility(View.GONE);
                savedepo.setVisibility(View.GONE);

                dbrowse.setVisibility(View.GONE);


                invNum.setVisibility(View.VISIBLE);
                invAmn.setVisibility(View.VISIBLE);
                invDat.setVisibility(View.VISIBLE);
                followDat.setVisibility(View.VISIBLE);
                inChooseBr.setVisibility(View.VISIBLE);

                invoiceNumber.setVisibility(View.VISIBLE);
                invoiceAmount.setVisibility(View.VISIBLE);
                invoiceDate.setVisibility(View.VISIBLE);
                followEDate.setVisibility(View.VISIBLE);
                browse.setVisibility(View.VISIBLE);
                saveS.setVisibility(View.VISIBLE);

                onFail.setVisibility(View.GONE);
                onSuccess.setVisibility(View.GONE);

                onSuccessDepo.setVisibility(View.GONE);
                onFailDepo.setVisibility(View.GONE);

                mList.setVisibility(View.VISIBLE);

                sd.setVisibility(View.GONE);
                mListDepo.setVisibility(View.GONE );

            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                btnS.setVisibility(View.GONE);
                btnD.setVisibility(View.GONE);
                btnS1.setVisibility(View.VISIBLE);
                btnD1.setVisibility(View.VISIBLE);


                invNum.setVisibility(View.GONE);
                invAmn.setVisibility(View.GONE);
                invDat.setVisibility(View.GONE);
                followDat.setVisibility(View.GONE);
                inChooseBr.setVisibility(View.GONE);

                invoiceNumber.setVisibility(View.GONE);
                invoiceAmount.setVisibility(View.GONE);
                invoiceDate.setVisibility(View.GONE);
                followEDate.setVisibility(View.GONE);
                browse.setVisibility(View.GONE);
                saveS.setVisibility(View.GONE);



                dMoneyrNO.setVisibility(View.VISIBLE);
                dDat.setVisibility(View.VISIBLE);
                dAmn.setVisibility(View.VISIBLE);
                dChooseBr.setVisibility(View.VISIBLE);

                dMoneyrNOEdit.setVisibility(View.VISIBLE);
                dDatEdit.setVisibility(View.VISIBLE);
                dAmnEdit.setVisibility(View.VISIBLE);
                savedepo.setVisibility(View.VISIBLE);

                dbrowse.setVisibility(View.VISIBLE);

                onFail.setVisibility(View.GONE);
                onSuccess.setVisibility(View.GONE);

                onSuccessDepo.setVisibility(View.GONE);
                onFailDepo.setVisibility(View.GONE);

                //onApiCallTenantSales(null);
                mList.setVisibility(View.GONE);

                onApiCallCreditCollection(null);

                sd.setVisibility(View.VISIBLE);
                mListDepo.setVisibility(View.VISIBLE);





            }
        });

        saveS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                invoiceAm= invoiceAmount.getText().toString(); //data to send
                invoiceNum= invoiceNumber.getText().toString(); //data to send
                invoDat=invoiceDate.getText().toString();
                followdatSt=followEDate.getText().toString();
                combineValuesSale(dropDownValue,finalarray);
            }
        });

        savedepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                depositAm= dAmnEdit.getText().toString(); //data to send
                moneyReciptNum= dMoneyrNOEdit.getText().toString(); //data to send
                depoDat=dDatEdit.getText().toString();

                combineValuesDepo(dropDownValue,finalarray);
            }
        });



        infoBtn.setVisibility(View.GONE);
        logOutButton.setVisibility(View.GONE);





    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this, "clicking on email", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.tool_logout:

                signOut();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    void signOut() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("finish", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
        startActivity(intent);
        finish();
    }

    public void openInsideActivity4(String myid) {   //Demo cust=new Demo(myid);

        Intent intent = new Intent(this, Info.class);
        intent.putExtra("Object", myid);
        startActivity(intent);
    }

    public void onApiCallCustomer(View view) {


        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://maxisservice-api-gateway-maxis.nagadpay.com/maxisservice-authorization-service/endpoint/api/user/list-partner-role-2";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("accountId", "bht02a01");

            jsonBody.put("onBoardingStatus", "null");
            jsonBody.put("role", "Maxis-Services-LM-Customer");
            jsonBody.put("userId", "bht02a01");


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
                    return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
                }


                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    params.put("token", "Bearer " + token);
                    params.put("userid", "bht02a01");


                    return params;
                }

               /* @Override
                public void deliverError(VolleyError error) {
                    super.deliverError(error);

                    //Log.e(TAG, error.getMessage(), error);

                    final int status = error.networkResponse.statusCode;
                    // Handle 30x
                    if (status == HttpURLConnection.HTTP_MOVED_PERM ||
                            status == HttpURLConnection.HTTP_MOVED_TEMP ||
                            status == HttpURLConnection.HTTP_SEE_OTHER) {
                        final String location = error.networkResponse.headers.get("Location");
                        if (BuildConfig.DEBUG) {
                            //Log.d(TAG, "Location: " + location);
                        }
                        // TODO: create new request with new location
                        // TODO: enqueue new request




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
                        });
                        requestQueue.add(stringRequest);
                    }
                }

                @Override
                public String getUrl() {
                    String url = super.getUrl();

                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "http://" + url; // use http by default
                    }

                    return url;
                }*/

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    String parsed = "";

                    if (response != null) {
                        responseString = "response.statusCode";
                        // can get more details such as response.headers
                        try {
                            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                        } catch (UnsupportedEncodingException e) {
                            parsed = new String(response.data);
                        }

                        ma.covertFuncCustomer(parsed);
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


    public void onApiCallCreditCollection(View view) {


        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://maxisservice-api-gateway-maxis.nagadpay.com/maxisservice-service/endpoint/credit-collection/get-tenant-collection";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("tenantId", "Business-House-Test-02");


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
                    return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    params.put("token", "Bearer " + token);
                    params.put("userid", "bht02a01");


                    return params;
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

                        ma.covertFuncCreditCollection(parsed);
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

    public void onApiCallTenantSales(View view) {


        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://maxisservice-api-gateway-maxis.nagadpay.com/maxisservice-service/endpoint/credit-sale/get-tenant-sale";

            JSONObject jsonBody = new JSONObject();
            jsonBody.put("tenantId", "Business-House-Test-02");


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
                    return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    params.put("token", "Bearer " + token);
                    params.put("userid", "bht02a01");


                    return params;
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

                        ma.covertFuncTenantSales(parsed);
                        //ma.success(parsed);
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

    public void onApiCallRoleSales() {


        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://onboard-apigw-maxis.nagadpay.com/authorization-service/endpoint/user/list-partner-role";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("accountId", "bht02a01");

            jsonBody.put("onBoardingStatus", "null");
            jsonBody.put("role", "Maxis-Business-House-Sales-Officer");
            jsonBody.put("userId", "bht02a01");
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
                    return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    params.put("token", "Bearer " + token);


                    return params;
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

                        ma.covertFuncRoleSale(parsed);
                        //ma.success(parsed);
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


    public void onApicallLm(View view) throws JSONException {


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://onboard-apigw-maxis.nagadpay.com/authorization-service/endpoint/user/list-partner-role";
        JSONObject jsonBody = new JSONObject();
        //jsonBody.put("token", "Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJiaHQwMmEwMSIsImV4cCI6MTYzOTIwMjUzOCwiaWF0IjoxNjM5MTk5ODM4LCJlbWFpbCI6bnVsbH0.xQVIpLOOT5KCHfwYXVeuj8Rote3-9fS8xVP2BJYCgkQvjdrmwSxSQjqkW6ILuO3p" );
        //jsonBody.put("token", "Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJiaHQwMmEwMSIsImV4cCI6MTYzOTIwMjUzOCwiaWF0IjoxNjM5MTk5ODM4LCJlbWFpbCI6bnVsbH0.xQVIpLOOT5KCHfwYXVeuj8Rote3-9fS8xVP2BJYCgkQvjdrmwSxSQjqkW6ILuO3p" );
        jsonBody.put("accountId", "bht02a01");

        jsonBody.put("onBoardingStatus", "null");
        jsonBody.put("role", "Maxis-Services-LM-Customer");
        jsonBody.put("userId", "bht02a01");
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
                return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                params.put("token", "Bearer " + token);


                return params;
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

                    ma.covertFuncLm(parsed);
                    //ma.success(parsed);
                    System.out.println(parsed);
                }

                return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
            }


        };

        requestQueue.add(stringRequest);

    }

    String covertFuncLm(String response) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<DataHandle>() {
        }.getType();
         designCsName = gson.fromJson(response, typeListOfDesign);

        // main a set korbo

        onApiCallCustomer(null);

        Log.i("data", designCsName.getResult().getResponse()[0].getId());
        String myid = designCsName.getResult().getStatus();
        //Demo rp=design;


//        if(design.getResult().getStatus().equals("SUCCESS")) {
//           // openInsideActivity4(response);
//        }

        /*int h = design.getResult().getResponse().length;
        EntityDropdown[] dropDownValue = new EntityDropdown[h];

        for (int i = 0; i < design.getResult().getResponse().length; i++) {

            dropDownValue[i] = new EntityDropdown();
            dropDownValue[i].setName(design.getResult().getResponse()[i].getName());
            dropDownValue[i].setId(design.getResult().getResponse()[i].getUserId());
        }
        ma.customers=dropDownValue;
        ArrayAdapter<EntityDropdown> adapter = new SpinAdapter(this, android.R.layout.simple_spinner_item, dropDownValue );

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                // Any UI task, example
                customer.setAdapter(adapter);
            }
        };
        handler.sendEmptyMessage(1);*/



        return response;

    }

    String covertFuncCustomer(String response) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<CustomerHandler[]>() {
        }.getType();
         designHand = gson.fromJson(response, typeListOfDesign);
        // main savekorbo


        Log.i("data", designHand[0].getId());
        //String myid= design.getResult().getStatus();
        //Demo rp=design;
//        if(design.getResult().getStatus().equals("SUCCESS")) {
//            // openInsideActivity4(response);
//        }

       // int h = design.getResult().getResponse().length;
        viaArray = new EntityDropdown[1];
        for (int i = 0; i <designHand.length; i++) {
            for (int j = 0; j < designCsName.getResult().getResponse().length; j++) {


                if (designHand[i].getUserCode().equals(designCsName.getResult().getResponse()[j].getUserId())) {


                    viaArray[0] = new EntityDropdown();
                    viaArray[0].setRef(designHand[i].getHandlerId());
                    viaArray[0].setName(designCsName.getResult().getResponse()[j].getName());
                    viaArray[0].setId(designCsName.getResult().getResponse()[j].getUserId());


                }
            }

        }
        Log.i("str",viaArray[0].getName());



        return response;

    }

    String covertFuncRoleSale(String response) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<DataHandle>() {
        }.getType();
        DataHandle design = gson.fromJson(response, typeListOfDesign);

        designST = design;

        Log.i("data", design.getResult().getResponse()[0].getEmail());
        String myid = design.getResult().getStatus();

        int h = design.getResult().getResponse().length;
         dropDownValue = new EntityDropdown[h];

//        dropDownValue[0] = new EntityDropdown();
//        dropDownValue[0].setName("hello");
//        dropDownValue[0].setId("a");
//        dropDownValue[0].setDropRef("a");
//        dropDownValue[1] = new EntityDropdown();
//        dropDownValue[1].setName("hello");
//        dropDownValue[1].setId("a");
//        dropDownValue[1].setDropRef("a");
        for (int i = 0; i < design.getResult().getResponse().length; i++) {

            dropDownValue[i] = new EntityDropdown();
            dropDownValue[i].setName(design.getResult().getResponse()[i].getName());
            dropDownValue[i].setId(design.getResult().getResponse()[i].getUserId());
        }

        //Demo rp=design;
//        if(dropDownValue[0].getName().equals("bht02a01")) {
//            // openInsideActivity4(response);
//        }

//        Type typeListOfDesignDrop = new TypeToken<DataHandle>(){}.getType();
//        DataHandle designDrop = gson.fromJson(response, typeListOfDesign);
//        ArrayList<ResponseArray> myList= new ArrayList<ResponseArray>();



        ArrayAdapter<EntityDropdown> adapter = new SpinAdapter(this, android.R.layout.simple_dropdown_item_1line, dropDownValue );

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                // Any UI task, example

                salesOfficer.setAdapter(adapter);


            }
        };
        handler.sendEmptyMessage(1);



       // int var=viaArray.length;
       // Log.i("data1dV", viaArray[0].getRef());


        salesOfficer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                EntityDropdown user = adapter.getItem(position);
                // Here you can do the action you want to...
                //Toast.makeText(this, "ID: " + user.getId() + "\nName: " + user.getName(), Toast.LENGTH_SHORT).show();


                dropDownId= user.getId();
           //     Log.i("data1d", dropDownId);
      //          Log.i("data1dV", viaArray[0].getRef());

                finalarray = new EntityDropdown[1];  // Hard coded will change
                finalarray[0]= new EntityDropdown("", "", "");
                for (int i = 0; i <viaArray.length ; i++) {


                    if (viaArray[i]!=null && dropDownId.equals(viaArray[i].getRef())) {


                        finalarray[0].setName(viaArray[i].getName());  // hard coded because only one ans,
                                                                        // will change when needed.
                        finalarray[0].setId(viaArray[i].getId());

                    }

                }
                  ma.customers=finalarray;
                adapter.notifyDataSetChanged();
                  ma.changeSo(dropDownId);

              /*    if(finalarray[0].getId()!=""){
                      btnS.setVisibility(View.VISIBLE);
                      btnD.setVisibility(View.VISIBLE);
                  }
                  else {
                 btnS.setVisibility(View.GONE);
                  btnD.setVisibility(View.VISIBLE);
                  }*/
                //ma.customer.setAdapter(new SpinAdapter(ma, android.R.layout.simple_spinner_item, finalarray));

                //ma.onCreate(dropDownId);
      }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });

        try {
            onApicallLm(null);
        } catch (
                Exception e
        ){

        }


//        ma.customer.setAdapter(new SpinAdapter(ma, android.R.layout.simple_spinner_item, finalarray));
        return dropDownId;

    }

    private void onCreate(String dropDownId) {
    }

    public void changeSo(String soId){

        ma.customer.setAdapter(new SpinAdapter(ma, android.R.layout.simple_dropdown_item_1line, ma.customers));


    }



    String covertFuncTenantSales(String response) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<CreditHandler>() {
        }.getType();
        CreditHandler designCredit = gson.fromJson(response, typeListOfDesign);

        ArrayList<CreditSales> myList= new ArrayList<CreditSales>();

        for (int i = 0; i < designCredit.getCreditSales().length; i++) {

                CreditSales property = designCredit.getCreditSales()[i];
                myList.add(property);

            }


        DataListAdapter adapter = new DataListAdapter(this, R.layout.sale_listview, myList );
        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                // Any UI task, example
                mList.setAdapter(adapter);
            }
        };
        handler.sendEmptyMessage(1);


        Log.i("data", designCredit.getId());
        //String myid= design.getResult().getStatus();
        //Demo rp=design;
//        if(design.getResult().getStatus().equals("SUCCESS")) {
//            // openInsideActivity4(response);
//        }

      /*  int h=designCredit.getCreditSales().length;
        EntityDropdown[] dropDownValue1 = new EntityDropdown[h];

        for (int i = 0; i < designCredit.getCreditSales().length; i++) {

            dropDownValue1[i] = new EntityDropdown();
            dropDownValue1[i].setName(designCredit.getCreditSales()[i].getCustomerName());
            dropDownValue1[i].setId(designCredit.getCreditSales()[i].getHandlerId());
        }
        ArrayAdapter<EntityDropdown> adapter = new SpinAdapter(this, android.R.layout.simple_spinner_item, dropDownValue1 );

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner salesOfficer
                = (Spinner)findViewById(R.id.spinner1);
        salesOfficer.setAdapter(adapter);*/

        return response;

    }

    String covertFuncCreditCollection(String response) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<CreditCollectionHandler>() {
        }.getType();
        CreditCollectionHandler design = gson.fromJson(response, typeListOfDesign);

        ArrayList<CreditCollectionArray> myList= new ArrayList<CreditCollectionArray>();

        for (int i = 0; i < design.getCreditCollection().length; i++) {

            CreditCollectionArray property = design.getCreditCollection()[i];
            myList.add(property);

        }


        DataListAdapterDeposit adapter = new DataListAdapterDeposit(this, R.layout.deposit_listview, myList );
        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                // Any UI task, example
                mListDepo.setAdapter(adapter);
            }
        };
        handler.sendEmptyMessage(1);

        Log.i("data", design.getCreditCollection()[0].getId());
        //String myid= design.getResult().getStatus();
        //Demo rp=design;
//        if(design.getResult().getStatus().equals("SUCCESS")) {
//            // openInsideActivity4(response);
//        }

        return response;

    }

    @Override
    public String success(String Result) {

        return Result;
    }

    public void combineValuesSale(EntityDropdown[] dropDownValue, EntityDropdown[] finalarray){

        Log.i("new data",invoiceAm);
        Log.i("new data2",invoiceNum);
        Log.i("new data9",dropDownId);
        Log.i("new data5",dropDownValue[0].getName());
        Log.i("newdata1",finalarray[0].getName());
        Log.i("newdata12",finalarray[0].getId());
        Log.i("newdata12sale",finalarray[0].getId());
        Log.i("newdata12date",invoDat);
        Log.i("newdata12date",followdatSt);
        Log.i("newdata12date",getTanent);
        Log.i("newdata12date",getUserId);


        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://maxisservice-api-gateway-maxis.nagadpay.com/maxisservice-service/endpoint/credit-sale/add";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("tenantId", getTanent);
            jsonBody.put("userId", getUserId);
            jsonBody.put("saleType", "CREDIT_SALE");
            jsonBody.put("invoiceNumber", invoiceNum);
            jsonBody.put("invoiceDate", invoDat);
            jsonBody.put("handlerId", dropDownId);
            jsonBody.put("followUpDate", followdatSt);
            jsonBody.put("customer", finalarray[0].getId());
            jsonBody.put("amount", invoiceAm);


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
                    return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    params.put("token", "Bearer " + token);
                    params.put("userid", "bht02a01");


                    return params;
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

                        ma.processResponse(parsed);
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

    public void combineValuesDepo(EntityDropdown[] dropDownValue, EntityDropdown[] finalarray){

        /*Log.i("new data",invoiceAm);
        Log.i("new data2",invoiceNum);
        Log.i("new data9",dropDownId);
        Log.i("new data5",dropDownValue[0].getName());
        Log.i("newdata1",finalarray[0].getName());
        Log.i("newdata12",finalarray[0].getId());
        Log.i("newdata12sale",finalarray[0].getId());
        Log.i("newdata12date",invoDat);
        Log.i("newdata12date",followdatSt);
        Log.i("newdata12date",getTanent);
        Log.i("newdata12date",getUserId);*/


        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://maxisservice-api-gateway-maxis.nagadpay.com/maxisservice-service/endpoint/credit-collection/add";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("tenantId", getTanent);
            jsonBody.put("userId", getUserId);
            jsonBody.put("receipt", "");
            jsonBody.put("moneyReceiptNumber", moneyReciptNum);
            jsonBody.put("collectionDate", depoDat);
            jsonBody.put("handlerId", dropDownId);
            jsonBody.put("customer", finalarray[0].getId());
            jsonBody.put("amount", depositAm);


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
                    return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    params.put("token", "Bearer " + token);
                    params.put("userid", "bht02a01");


                    return params;
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

                        ma.processResponseDepo(parsed);
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

    String processResponse(String response){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<ResponseHandle>() {
        }.getType();
        ResponseHandle design = gson.fromJson(response, typeListOfDesign);

        Log.i("status",design.getStatus());

        if(design.getStatus().equals("SUCCESS")){

            Handler handler = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    // Any UI task, example
                    onFail.setVisibility(View.GONE);
                    onSuccess.setVisibility(View.VISIBLE);
                }
            };
            handler.sendEmptyMessage(1);
        }
        else {

            Handler handler = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    // Any UI task, example
                    onSuccess.setVisibility(View.GONE);
                    onFail.setVisibility(View.VISIBLE);
                }
            };
            handler.sendEmptyMessage(1);
        }

        return response;
    }

    String processResponseDepo(String response){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<ResponseHandle>() {
        }.getType();
        ResponseHandle design = gson.fromJson(response, typeListOfDesign);

        Log.i("status",design.getStatus());

        if(design.getStatus().equals("SUCCESS")){

            Handler handler = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    // Any UI task, example
                    onFailDepo.setVisibility(View.GONE);
                    onSuccessDepo.setVisibility(View.VISIBLE);
                }
            };
            handler.sendEmptyMessage(1);
        }
        else {

            Handler handler = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    // Any UI task, example
                    onSuccessDepo.setVisibility(View.GONE);
                    onFailDepo.setVisibility(View.VISIBLE);
                }
            };
            handler.sendEmptyMessage(1);
        }

        return response;
    }

    //@Override
   /* public void success(String Result, String source) {
        String data = Result;

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<DataHandle>() {
        }.getType();
        DataHandle design = gson.fromJson(data, typeListOfDesign);


        Log.i("test", design.getResult().getResponse()[0].getName());

        int h = design.getResult().getResponse().length;
        EntityDropdown[] dropDownValue = new EntityDropdown[h];

//        dropDownValue[0] = new EntityDropdown();
//        dropDownValue[0].setName("hello");
//        dropDownValue[0].setId("a");
//        dropDownValue[1] = new EntityDropdown();
//        dropDownValue[1].setName("hello");
//        dropDownValue[1].setId("a");
        for (int i = 0; i < design.getResult().getResponse().length; i++) {

            dropDownValue[i] = new EntityDropdown();
            dropDownValue[i].setName(design.getResult().getResponse()[i].getName());
            dropDownValue[i].setId(design.getResult().getResponse()[i].getUserId());
        }

        //Demo rp=design;
//        if(dropDownValue[0].getName().equals("bht02a01")) {
//            // openInsideActivity4(response);
//        }

//        Type typeListOfDesignDrop = new TypeToken<DataHandle>(){}.getType();
//        DataHandle designDrop = gson.fromJson(response, typeListOfDesign);
//        ArrayList<ResponseArray> myList= new ArrayList<ResponseArray>();


        ArrayAdapter<EntityDropdown> adapter = new SpinAdapter(this, android.R.layout.simple_spinner_item, dropDownValue);

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         salesOfficer
                = (Spinner) findViewById(R.id.spinner);

        salesOfficer.setAdapter(adapter);


        salesOfficer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                EntityDropdown user = adapter.getItem(position);
                // Here you can do the action you want to...
                //Toast.makeText(this, "ID: " + user.getId() + "\nName: " + user.getName(), Toast.LENGTH_SHORT).show();


                String dropDownId = user.getId();
                Log.i("data", dropDownId);

                for (int i = 0; i < designCredit.getCreditSales().length; i++) {


                }

                //objectCom.getObject(dropDownId,entityDropdowns,entityDropdowns2,entityDropdowns3);
                //dropDown1.setVisibility(View.GONE);
                //entityDropdowns2=objectCom.getdata();


//                DropDownAdapter adapter1 = new DropDownAdapter(mContext, android.R.layout.simple_spinner_item, entityDropdowns3,1);
//                adapter1.notifyDataSetChanged();
//                dropDown1.setAdapter(adapter1);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {
            }
        });

    }*/
}
