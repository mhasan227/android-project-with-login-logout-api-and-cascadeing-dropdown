package com.example.maxisloginlogout;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Calendar;

import apiforcreditcollection.CreditCollectionArray;

public class DataListAdapterDeposit extends ArrayAdapter<CreditCollectionArray> {

    public   static final String TAG="dataListAdapter";
    private Context mContext;
    int mResourcee;
    int listsize ;

    TextView invoiceNumber;
    TextView due;
    EditText amount;
    /*
    TextView viewTitleOUt;
    EditText input;
    String dateTime;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    View format1;*/

    //private ObjectCom objectCom;

    //private ArrayList<InputMap> inputMap;
    //List<String> searchablespinner_list = new ArrayList<String>();
    //List<String> listInt = new ArrayList<String>();

    /**
     * Constructor. This constructor will result in the underlying data collection being
     * immutable, so methods such as {@link #clear()} will throw an exception.
     *  @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
    //* @param inputMap
     */
    public DataListAdapterDeposit(@NonNull Context context, int resource, @NonNull ArrayList<CreditCollectionArray> objects) {
        super(context, resource, objects);

        mContext=context;
        mResourcee= resource;
        Calendar calendar;
        //this.objectCom=objectCom;

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CreditCollectionArray listsale = getItem(position);
        String viewDepositAmount=listsale.getAmount();
        String viewMoneyReceiptNumber=listsale.getMoneyReceiptNumber();
        String viewEntryTime= listsale.getCreationTime();
        String viewDepositDate= listsale.getCollectionDate();




        LayoutInflater inflater= LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResourcee, parent, false);

        //ArrayAdapter<EntityDropdown> adapter = new SpinAdapter(mContext, android.R.layout.simple_spinner_dropdown_item, entityDropdowns);


        TextView amount = (TextView) convertView.findViewById(R.id.depositAmount);

        TextView moneyReciptNumber= (TextView) convertView.findViewById(R.id.editMoneyRecNum);
        TextView entryTime= (TextView) convertView.findViewById(R.id.entryTime);
        TextView invoiceDate= (TextView) convertView.findViewById(R.id.depositDate);

        amount.setText(viewDepositAmount);
        moneyReciptNumber.setText(viewMoneyReceiptNumber);

        entryTime.setText(viewEntryTime);
        invoiceDate.setText(viewDepositDate);





       /*else {
           EditText input = (EditText) convertView.findViewById(R.id.editTitle);
           entityView.setRefObj(input);

       }*/

        return convertView;
        // return super.getView(position, convertView, parent);


    }

}
