package apicall;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.maxisloginlogout.EntityDropdown;
import com.example.maxisloginlogout.Home;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import api1listpartnerrole.DataHandle;
import customervia.CustomerHandler;

public class Utility {
   /* private Utility ma;
    DataHandle designCsName;
    CustomerHandler[] designHand;
    private static EntityDropdown[] viaArray = new EntityDropdown[1];
    public static String PROTOCOL_HTTP = "http";

    public static String PROTOCOL_HTTPS = "https";

    public static String HTTP_METHOD = "POST";
    private final Context context;

    public static String response;



    public Utility(Context context) {
        super();
        this.context = context;

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Utility request(String requestMethod, Map<String, String> requestHeaders, String requestProtocol,

                           String requestDomain,

                           String requestPort,

                           String requestPath,

                           Map<String, String> requestQueryStringMaps,

                          String requestBody) {
        try {
            if (requestHeaders != null) {
                for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {

                    requestHeaders.put(entry.getKey(), entry.getValue());

                }

            }
            String url = requestProtocol.toLowerCase() + "://" + requestDomain;
            if (requestPort != null)
                url = url + ":" + requestPort;

            if (requestPath != null)
                url = url + "/" + requestPath;

            if (requestQueryStringMaps != null) {
                url = url + "?";

                for (Map.Entry<String, String> entry : requestQueryStringMaps.entrySet()) {

                    url = url + entry.getKey() + "=" + entry.getValue();

                }
            }
            if (requestMethod.equals("POST")) {


                try {
                    RequestQueue requestQueue = Volley.newRequestQueue(context);
                    String URL = "http://maxisservice-api-gateway-maxis.nagadpay.com/maxisservice-authorization-service/endpoint/api/user/list-partner-role-2";
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("accountId", "bht02a01");

                    jsonBody.put("onBoardingStatus", "null");
                    jsonBody.put("role", "Maxis-Services-LM-Customer");
                    jsonBody.put("userId", "bht02a01");


                    requestBody = jsonBody.toString();

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

                     /*   @Override
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
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

    }*/
}

