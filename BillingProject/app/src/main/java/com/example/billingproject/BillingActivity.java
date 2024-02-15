package com.example.billingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BillingActivity extends AppCompatActivity {

    private EditText clientIdEditText;
    private EditText clientNameEditText;
    private EditText prdNameEditText;
    private EditText prdPriceEditText;
    private EditText prdQtyEditText;
    private Button updateButton;
    private static  final String EXTRA_CLIENT_ID="com.example.billingproject.client_id";
    private static  final String EXTRA_CLIENT_NAME="com.example.billingproject.client_name";
    private static  final String EXTRA_PRD_NAME="com.example.billingproject.prd_name";
    private static  final String EXTRA_PRD_PRICE="com.example.billingproject.prd_price";
    private static  final String EXTRA_PRD_QTY="com.example.billingproject.prd_qty";

    public static Intent newIntent(Context packageContext, int clientId, String clientName,
                                   String prdName, double prdPrice, int prdQty)
    {
        Intent intent = new Intent(packageContext, BillingActivity.class);
        intent.putExtra(EXTRA_CLIENT_ID, clientId);
        intent.putExtra(EXTRA_CLIENT_NAME, clientName);
        intent.putExtra(EXTRA_PRD_NAME, prdName);
        intent.putExtra(EXTRA_PRD_PRICE, prdPrice);
        intent.putExtra(EXTRA_PRD_QTY, prdQty);

        return  intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

        //Decoding the extra data from the intent object
        int clientIdRetrieve = getIntent().getIntExtra(EXTRA_CLIENT_ID,0);
        String clientNameRetrieve = getIntent().getStringExtra(EXTRA_CLIENT_NAME);
        String prdNameRetrieve = getIntent().getStringExtra(EXTRA_PRD_NAME);
        double prdPriceRetrieve = getIntent().getDoubleExtra(EXTRA_PRD_PRICE,0);
        int prdQtyRetrieve = getIntent().getIntExtra(EXTRA_PRD_QTY,0);

        //Get the view of clientIdEditText
        clientIdEditText =(EditText) findViewById(R.id.input_client_id_edit_text_billingActivity);
        clientIdEditText.setText(Integer.toString(clientIdRetrieve));

        //Get the view of clientNameEditText
        clientNameEditText =(EditText)  findViewById(R.id.input_client_name_edit_text_billingActivity);
        clientNameEditText.setText(clientNameRetrieve);

        //Get the view of prdNameEditText
        prdNameEditText= (EditText) findViewById(R.id.input_prd_name_edit_text_billingActivity);
        prdNameEditText.setText(prdNameRetrieve);

        //Get the view of prdPriceEditText
        prdPriceEditText=(EditText) findViewById(R.id.input_prd_price_edit_text_billingActivity);
        prdPriceEditText.setText(Double.toString(prdPriceRetrieve));

        //Get the view of prdQtyEditText
        prdQtyEditText=(EditText) findViewById(R.id.input_prd_qty_edit_text_billingActivity);
        prdQtyEditText.setText(Integer.toString(prdQtyRetrieve));

        //Get the view of updateButton
        updateButton= (Button) findViewById(R.id.billing_update_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBillingUpdateCodeResult(Integer.parseInt(clientIdEditText.getText().toString()),
                        clientNameEditText.getText().toString(),
                        prdNameEditText.getText().toString(),
                        Double.parseDouble(prdPriceEditText.getText().toString()),
                        Integer.parseInt(prdQtyEditText.getText().toString()));
                finish();
            }
        });

    }
    //coding extra data intent from child to parent activity
    private void setBillingUpdateCodeResult(int clientId, String clientName,
                                            String prdName, double prdPrice, int prdQty)
    {
        Intent dataIntent = new Intent();
        dataIntent.putExtra(EXTRA_CLIENT_ID, clientId);
        dataIntent.putExtra(EXTRA_CLIENT_NAME, clientName);
        dataIntent.putExtra(EXTRA_PRD_NAME, prdName);
        dataIntent.putExtra(EXTRA_PRD_PRICE, prdPrice);
        dataIntent.putExtra(EXTRA_PRD_QTY, prdQty);

        setResult(RESULT_OK,dataIntent);
    }

    //Decoding extra data intent parentActivity
    public static Billing sendMessageBillingUpdateResult(Intent resultIntent)
    {
        Billing billingUpdateInfo = new Billing();
        billingUpdateInfo.setClient_id(resultIntent.getIntExtra(EXTRA_CLIENT_ID,0));
        billingUpdateInfo.setClient_name(resultIntent.getStringExtra(EXTRA_CLIENT_NAME));
        billingUpdateInfo.setProduct_name(resultIntent.getStringExtra(EXTRA_PRD_NAME));
        billingUpdateInfo.setPrd_price(resultIntent.getDoubleExtra(EXTRA_PRD_PRICE,0));
        billingUpdateInfo.setPrd_qty(resultIntent.getIntExtra(EXTRA_PRD_QTY,0));
        return billingUpdateInfo;
    }
}