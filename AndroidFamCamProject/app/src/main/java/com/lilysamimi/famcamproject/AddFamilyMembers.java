// This page was created by Lily Samimi


package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class AddFamilyMembers extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_family_members);

        Button button = (Button) findViewById(R.id.add_from_address_book);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog();
            }
        });

        /*
        FragmentManager fm = getFragmentManager();
        FragmentAccessAddress testDialog = new FragmentAccessAddress();
        testDialog.setRetainInstance(true);
        testDialog.show(fm, "fragment_name");*/
    }

    void showDialog() {
        DialogFragment newFragment = AddressBookAlertDialogFragment
                .newInstance(R.string.alert_dialog_address_book_buttons_title);
        newFragment.show(getFragmentManager(), "dialog");
    }

    public void doPositiveClick() {
        Intent intent = new Intent(this, AddFamilyMembersAddressBook.class);
        startActivity(intent);
        Log.i("FamCamProject", "Positive click!");
    }

    public void doNegativeClick() {
        Log.i("FamCamProject", "Negative click!");
    }

    public static class AddressBookAlertDialogFragment extends DialogFragment {

        public static AddressBookAlertDialogFragment newInstance(int title) {
            AddressBookAlertDialogFragment frag = new AddressBookAlertDialogFragment();
            Bundle args = new Bundle();
            args.putInt("title", title);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int title = getArguments().getInt("title");

            return new AlertDialog.Builder(getActivity())
                    .setTitle(title)
                    .setPositiveButton(R.string.alert_dialog_ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                    ((AddFamilyMembers) getActivity())
                                            .doPositiveClick();
                                }
                            })
                    .setNegativeButton(R.string.alert_dialog_cancel,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                    ((AddFamilyMembers) getActivity())
                                            .doNegativeClick();
                                }
                            }).create();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_family_members, menu);
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

    //public void startActivity(Intent intent) {
       // super.startActivity(intent);

        // When user clicks on add from address book we require 3 methods
        // 1.  pull contacts from address book and phone numbers
        // 2.  match these numbers to registered members in database
        // 3.if a match is found, bring in family member and display with add button
        // 4. if a match is not found display without add button
        //}

    public void openMyFamily(View view) {
        Intent intent= new Intent(this, ListviewMyFamily.class);
        startActivity(intent);
    };
    // When user clicks on finish, go to My Family page

    public void openAddFamilyAddress(View view) {


        //Intent intent= new Intent(this, AddFamilyMembersAddressBook.class);
        //startActivity(intent);
        //Commented out intent and replaced with dialog fragment.

       // FragmentManager fm = getFragmentManager();
       // FragmentAccessAddress testDialog = new FragmentAccessAddress();
       // testDialog.setRetainInstance(true);
       // testDialog.show(fm, "Confirm Access");
    };

}


