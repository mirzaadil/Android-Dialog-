package com.cyberinnovation.customdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button myButton_ok;
    private Button myButton_two;
    private Button myButton_three;
    private Button myButton_timePicker;
    private Button myButton_datePicker;
    private Button myButton_listview;
    private Button myButton_scrollview;
    private Button myButton_edittext;
    private Button mybutton_webview;
    private Button mybutton_customizeLayout;
    private Button mybutton_singleChoice;
    private Button mybutton_multipleChoice;
    public Context mycontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mycontext = this;
        myButton_ok = (Button) findViewById(R.id.button_ok);
        myButton_two = (Button) findViewById(R.id.button_ok_cancel);
        myButton_three = (Button) findViewById(R.id.button_three);
        myButton_datePicker = (Button) findViewById(R.id.button_Date_picker);
        myButton_timePicker = (Button) findViewById(R.id.button_timePicker);
        myButton_listview = (Button) findViewById(R.id.button_ListView);
        myButton_scrollview = (Button) findViewById(R.id.button_scrollview);
        myButton_edittext = (Button) findViewById(R.id.button_edittext);
        mybutton_webview = (Button) findViewById(R.id.button_webview);
        mybutton_customizeLayout = (Button) findViewById(R.id.button_customLayout);
        mybutton_singleChoice = (Button) findViewById(R.id.button_singleChoice);
        mybutton_multipleChoice = (Button) findViewById(R.id.button_MultipleChoice);


        myButton_ok.setOnClickListener(this);
        myButton_two.setOnClickListener(this);
        myButton_three.setOnClickListener(this);
        myButton_datePicker.setOnClickListener(this);
        myButton_timePicker.setOnClickListener(this);
        myButton_listview.setOnClickListener(this);
        myButton_scrollview.setOnClickListener(this);
        myButton_edittext.setOnClickListener(this);
        mybutton_webview.setOnClickListener(this);
        mybutton_customizeLayout.setOnClickListener(this);
        mybutton_singleChoice.setOnClickListener(this);
        mybutton_multipleChoice.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_ok:
                CustomDialog.alertOneButton(mycontext);
                break;
            case R.id.button_ok_cancel:
                CustomDialog.alertTwoButton(mycontext);
                break;
            case R.id.button_three:
                CustomDialog.threeAlertButton(mycontext);
                break;
            case R.id.button_timePicker:
                CustomDialog.timePickerAlert(mycontext);
                break;
            case R.id.button_Date_picker:
                CustomDialog.DatePickerAlert(mycontext);
                break;
            case R.id.button_ListView:
                CustomDialog.alertDialogListView(mycontext);
                break;
            case R.id.button_customLayout:
                CustomDialog.alertFormDialog(mycontext);
                break;
            case R.id.button_singleChoice:
                CustomDialog.SingleChoiceAlert(mycontext);
                break;
            default:
                break;

        }
    }

    public void alertOneButton() {

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("One Button")
                .setMessage("Thanks for visiting The Code of a Ninja - codeofaninja.com")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                }).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
