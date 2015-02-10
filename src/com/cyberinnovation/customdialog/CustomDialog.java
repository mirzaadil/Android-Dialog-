package com.cyberinnovation.mirzaadil.dialogdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by Mirza Adil on 2/2/2015.
 */
public class CustomDialog {

    Context myContext;


    public static void alertOneButton(Context myContext) {

        new AlertDialog.Builder(myContext).setTitle("Single Button").setMessage("User Login .....!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();
    }

    public static void alertTwoButton(Context myContext) {
        new AlertDialog.Builder(myContext).setTitle("Login").setMessage("User Login and Create Account").setIcon(R.drawable.ic_launcher).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();

    }

    public static void threeAlertButton(Context myContext) {

        new AlertDialog.Builder(myContext).setTitle("Login").setMessage("User Login").setIcon(R.drawable.ic_launcher).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).setNeutralButton("SignUp", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();
    }

    public static void timePickerAlert(final Context myContext) {

        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.time_picker, null);

        final TimePicker timePicker = (TimePicker) view.findViewById(R.id.mytimePicker);

        new AlertDialog.Builder(myContext).setView(view).setTitle("Set Time").setPositiveButton("Select Time", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String currentHour = timePicker.getCurrentHour().toString();
                String currentMints = timePicker.getCurrentMinute().toString();
                Toast.makeText(myContext, currentHour + "::" + currentMints, Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        }).show();

    }

    public static void DatePickerAlert(final Context myContext) {

        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.date_picker, null);

        final DatePicker mydatePicker = (DatePicker) view.findViewById(R.id.mydatepicker);
        mydatePicker.setCalendarViewShown(true);

        new AlertDialog.Builder(myContext).setView(view).setTitle("Select Date").setPositiveButton("Select Date", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                int month = mydatePicker.getMonth() + 1;
                int day = mydatePicker.getDayOfMonth();
                int year = mydatePicker.getYear();

                Toast.makeText(myContext, "Month:" + month + "::" + "Day:" + day + "::" + "Year: " + year, Toast.LENGTH_LONG).show();

                dialog.cancel();

            }
        }).show();

    }

    public static void alertDialogListView(final Context myContext) {

        final CharSequence weeks[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        AlertDialog.Builder builder = new AlertDialog.Builder(myContext);
        builder.setTitle("Select Week day");
        builder.setItems(weeks, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int week) {
                CharSequence days = weeks[week];
                Toast.makeText(myContext, "day Select :" + days, Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        }).show();

    }

    public static void alertFormDialog(final Context myContext) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.form_data, null, false);

        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.cehckbox);
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.readioGroup);
        final EditText editText = (EditText) view.findViewById(R.id.edittext);

        new AlertDialog.Builder(myContext).setView(view).setTitle("Form ").setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String toString = "";
                try {
                    if (checkBox.isChecked()) {
                        toString += "Happy is checked..!\n";
                    } else {
                        toString += "Happy  is not checked.\n";
                    }


                    int isSelectedGender = radioGroup.getCheckedRadioButtonId();

                    RadioButton radioButton = (RadioButton) view.findViewById(isSelectedGender);
                    toString += "select radio butt    :" + radioButton.getText() + "\n";

                    toString += "Name is :" + editText.getText();
                    Toast.makeText(myContext, toString, Toast.LENGTH_LONG).show();
                } catch (Exception e) {


                }
            }
        }).show();


    }

    public static void AlertWebviewDialog(Context myContext) {
        WebView webView = new WebView(myContext);
        webView.loadUrl("http://www.google.com");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
                // view.loadUrl(url);
            }
        });


    }

    public static void SingleChoiceAlert(final Context myContext) {
        AlertDialog.Builder builder = new AlertDialog.Builder(myContext);
        String items[]=myContext.getResources().getStringArray(R.array.choice);
        try {
            builder.setTitle("Choice one").setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(myContext, which, Toast.LENGTH_LONG).show();
                }
            }).setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
