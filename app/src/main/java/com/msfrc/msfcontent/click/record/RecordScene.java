package com.msfrc.msfcontent.click.record;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.msfrc.msfcontent.R;
import com.msfrc.msfcontent.base.Constants;
import com.msfrc.msfcontent.base.FirstRow;
import com.msfrc.msfcontent.base.FirstRowAdapter;

import java.util.ArrayList;

/**
 * Created by kmuvcl_laptop_dell on 2016-07-25.
 */
public class RecordScene extends AppCompatActivity{
    private ArrayList<FirstRow> firstRow = new ArrayList<FirstRow>();
    private TextView titleText;
    private ArrayList<RecordSceneData> recordListData = new ArrayList<RecordSceneData>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_main);
        ListView emergencyView;
        ListView firstRowView;
        firstRow.add(new FirstRow(R.drawable.click, "              ", "        ","Click1"));
        recordListData.add(new RecordSceneData(R.drawable.ic_record_voice_24dp, "RECORD VOICE", true));
        firstRowView = (ListView)findViewById(R.id.first);
        emergencyView = (ListView)findViewById(R.id.musicList);
        FirstRowAdapter firstAdapter = new FirstRowAdapter(getLayoutInflater(), firstRow);
        RecordSceneAdapter recordAdapter = new RecordSceneAdapter(getLayoutInflater(), recordListData);
        firstRowView.setAdapter(firstAdapter);
        emergencyView.setAdapter(recordAdapter);
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
        titleText = (TextView)findViewById(R.id.title);
        titleText.setText("RECORD VOICE");
        titleText.setTextColor(Color.WHITE);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.home:
                Constants.recordPage = false;
                NavUtils.navigateUpFromSameTask(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.click_option_menu, menu);
        return true;
    }
}
