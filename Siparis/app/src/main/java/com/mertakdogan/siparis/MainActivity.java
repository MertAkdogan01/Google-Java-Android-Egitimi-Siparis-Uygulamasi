package com.mertakdogan.siparis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        


        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();


        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(name,price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);

        //output

    }

    public int calculatePrice(boolean addWhippedCream, boolean addChocolate){

        int basePrice = 5;

        if (addWhippedCream){
            basePrice = basePrice + 1;
        }

        if (addChocolate){
            basePrice = basePrice + 2;
        }


        return quantity * basePrice;
    }

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolateCoffee){
        String priceMessage = "İsim: " + name;
        priceMessage += "\nKrema eklensin mi? " + addWhippedCream;
        priceMessage += "\nÇikolata eklensin mi? " + addChocolateCoffee;
        priceMessage = priceMessage + "\nMiktar: " + quantity;
        priceMessage = priceMessage + "\nToplam: $" + price;
        priceMessage = priceMessage + "\nTeşekkürler!";
        return priceMessage;
    }







    public void arttır(View view) {
        if (quantity == 100){

            Toast.makeText(this,"100 den fazla kahve alamazsın",Toast.LENGTH_SHORT).show();

            return;
        }
        quantity = quantity+1;
        displayQuantity(quantity);
    }


    public void azalt(View view) {
        if (quantity == 1){

            Toast.makeText(this,"1'den az kafe alamazsın", Toast.LENGTH_SHORT).show();

            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }





    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees
        );
    }


    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }




}