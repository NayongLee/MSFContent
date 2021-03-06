package com.msfrc.msfcontent.colorpicker;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.msfrc.msfcontent.R;
import com.msfrc.msfcontent.base.Constants;
import com.msfrc.msfcontent.connection.ConnectionScene;

/**
 * Created by kmuvcl_laptop_dell on 2016-09-01.
 */
public class ColorPickerActivity extends AppCompatActivity{
    private ColorPickerView colorPicker;
    private Button button;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ColorPickerScene", "");
        setContentView(R.layout.colorscene);
        colorPicker = (ColorPickerView)findViewById(R.id.colorPicker);
        if(ConnectionScene.mConnected){//html 색상표
            String color = ConnectionScene.mBluetoothLeService.readColor();//00 00 00 00 형식으로 들어옴
            colorPicker.setColor(Color.parseColor(Constants.basicColor));
        }
        else colorPicker.setColor(Color.parseColor(Constants.basicColor));
        setCustomerActionBar();
    }

    private void setCustomerActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(51, 51, 51)));
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        View mCustomView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.actionbar, null);
        actionBar.setCustomView(mCustomView);
        mTextView = (TextView)findViewById(R.id.title);
        mTextView.setText("Color Picker");
        mTextView.setTextColor(Color.WHITE);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
