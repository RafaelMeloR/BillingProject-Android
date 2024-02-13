package com.example.billingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText input_client_id_edit_text;
    private EditText input_client_name_edit_text;
    private EditText input_prd_name_edit_text;
    private EditText input_prd_price_edit_text;
    private EditText input_prd_qty_edit_text;
    private TextView total_text_view;
    private TextView client_text_view;
    private Button total_input_billing_button;
    private  Button total_record_billing_button;
    private Button  prev_billing_button;
    private Button  next_billing_button;
    private int currentIndex=0;
    public static String TAG="Course Project";
    public static String KEY_INDEX = "index";

    Billing billingRecord1 = new Billing(105, "Johnston Jane", "Chair", 99.99, 2);
    Billing billingRecord2 = new Billing(108, "Fikhali Samuel", "Table", 139.99, 1);
    Billing billingRecord3 = new Billing(113, "Samson Amina", "KeyUSB", 14.99, 2);

    //DATA STRUCTURE ARRAY OF OBJECTS
    public Billing[] all_billing = new Billing[]{billingRecord1,billingRecord2,billingRecord3 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null)
        {
            currentIndex=savedInstanceState.getInt(KEY_INDEX);
        }
     //Get the view of input_client_id_edit_text
        input_client_id_edit_text=(EditText) findViewById(R.id.input_client_id_edit_text);
        input_client_id_edit_text.setText(Integer.toString(all_billing[currentIndex].getClient_id()));

        //Get the view of input_client_name_edit_text
        input_client_name_edit_text=(EditText) findViewById(R.id.input_client_name_edit_text);
        input_client_name_edit_text.setText(all_billing[currentIndex].getClient_name());

        //Get the view of input_prd_name_edit_text
        input_prd_name_edit_text=(EditText) findViewById(R.id.input_prd_name_edit_text);
        input_prd_name_edit_text.setText(all_billing[currentIndex].getProduct_name());

       //Get the view of input_prd_price_edit_text
        input_prd_price_edit_text=(EditText) findViewById(R.id.input_prd_price_edit_text);
        input_prd_price_edit_text.setText(Double.toString(+all_billing[currentIndex].getPrd_price()));

        //Get the view of input_prd_qty_edit_text
        input_prd_qty_edit_text=(EditText) findViewById(R.id.input_prd_qty_edit_text);
        input_prd_qty_edit_text.setText(Integer.toString(all_billing[currentIndex].getPrd_qty()));

        //Get the view of total_text_view
        total_text_view=(TextView) findViewById(R.id.total_text_view);


        //Get the view of client_text_view
        client_text_view=(TextView) findViewById(R.id.client_text_view);


        //Get the view of next_billing_button
        next_billing_button =(Button)  findViewById(R.id.next_billing_button);
        next_billing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex=(currentIndex+1)%all_billing.length;
                input_client_id_edit_text.setText(Integer.toString(all_billing[currentIndex].getClient_id()));
                input_client_name_edit_text.setText(all_billing[currentIndex].getClient_name());
                input_prd_name_edit_text.setText(all_billing[currentIndex].getProduct_name());
                input_prd_name_edit_text.setText(all_billing[currentIndex].getProduct_name());
                input_prd_price_edit_text.setText(Double.toString(+all_billing[currentIndex].getPrd_price()));
                input_prd_qty_edit_text.setText(Integer.toString(all_billing[currentIndex].getPrd_qty()));
            }
        });

        //Get the view of prev_billing_button
        prev_billing_button =(Button)  findViewById(R.id.prev_billing_button);
        prev_billing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex - 1 + all_billing.length) % all_billing.length;
                input_client_id_edit_text.setText(Integer.toString(all_billing[currentIndex].getClient_id()));
                input_client_name_edit_text.setText(all_billing[currentIndex].getClient_name());
                input_prd_name_edit_text.setText(all_billing[currentIndex].getProduct_name());
                input_prd_name_edit_text.setText(all_billing[currentIndex].getProduct_name());
                input_prd_price_edit_text.setText(Double.toString(+all_billing[currentIndex].getPrd_price()));
                input_prd_qty_edit_text.setText(Integer.toString(all_billing[currentIndex].getPrd_qty()));
            }
        });

        //Get the view of total_input_billing_button
        total_input_billing_button =(Button)  findViewById(R.id.total_input_billing_button);
        total_input_billing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client_text_view.setText("View Total Billing: "+all_billing[currentIndex].calculateBilling());
            }
        });

        //Get the view of total_record_billing_button
        total_record_billing_button =(Button)  findViewById(R.id.total_record_billing_button);
        total_record_billing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_text_view.setText("Client: "+all_billing[currentIndex].getClient_id()+" "+
                        all_billing[currentIndex].getClient_name()+" "+all_billing[currentIndex].getProduct_name()+" "
                        +all_billing[currentIndex].calculateBilling());
                Toast.makeText(MainActivity.this, "Client: "+all_billing[currentIndex].getClient_id()+" "+
                        all_billing[currentIndex].getClient_name()+" "+all_billing[currentIndex].getProduct_name()+" "
                        +all_billing[currentIndex].calculateBilling(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public  void onStart()
    {
        super.onStart();
        Log.d (TAG, "onStart is called");
    }
    @Override
    public  void onResume()
    {
        super.onResume();
        Log.d (TAG, "onResume is called");
    }
    @Override
    public  void onPause()
    {
        super.onPause();
        Log.d (TAG, "onPause is called");
    }
    @Override
    public  void onStop()
    {
        super.onStop();
        Log.d (TAG, "onStop is called");
    }
    @Override
    public  void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy is called");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState: called");
        savedInstanceState.putInt(KEY_INDEX,currentIndex);
    }
}