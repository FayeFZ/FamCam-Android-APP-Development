package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.app.FragmentManager;
import android.widget.Button;


public class NewUserLogin extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_login);

    // code for alert dialogfragment -- fei
     // When you click on the button submit, it will pop up and you can choose

        Button button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

/*
        FragmentManager fm = getFragmentManager();
        TestDialog testDialog = new TestDialog();
        testDialog.setRetainInstance(true);
        testDialog.show(fm, "fragment_name");


        */

        // I inserted the code above to add the fragment to this screen.- Mike
    }


    void showDialog() {
        DialogFragment newFragment = MyAlertDialogFragment
                .newInstance(R.string.alert_dialog_two_buttons_title);
        newFragment.show(getFragmentManager(), "dialog");
    }


    public void doPositiveClick() {
        Intent intent = new Intent(this, MakeProfile.class);
        startActivity(intent);
        //Log.i("FamCamProject", "Positive click!");
    }

    public void doNegativeClick() {
        //Log.i("FamCamProject", "Negative click!");
    }

    public static class MyAlertDialogFragment extends DialogFragment{

        public static MyAlertDialogFragment newInstance(int title){
            MyAlertDialogFragment frag = new MyAlertDialogFragment();
            Bundle args = new Bundle();
            args.putInt("title",title);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            int title = getArguments().getInt("title");

            return new AlertDialog.Builder(getActivity())
                    .setTitle(title)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                        int whichButton) {
                                    ((NewUserLogin)getActivity())
                                            .doPositiveClick();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                    ((NewUserLogin) getActivity())
                                            .doNegativeClick();
                                }
                            }).create();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_user_login, menu);
        return true;
    }

    /* (save for action bar later)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */

    /*
    public void openMakeProfile (View view) {
        //Intent intent = new Intent(this, MakeProfile.class);
        //startActivity(intent);
        // Commented out the intent that used to be here and replaced it with the dialog fragment


        FragmentManager fm = getFragmentManager();
        TestDialog testDialog = new TestDialog();
        testDialog.setRetainInstance(true);
        testDialog.show(fm, "Confirm Information");


        // I inserted the code above to add the fragment to this screen.- Mike

    }
    */


}
