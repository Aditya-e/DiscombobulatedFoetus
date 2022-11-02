package com.hfad.bello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.hfad.bello.FragmentFolder.AuthenticationFragment;

import java.io.File;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        //opening AuthenticationFragment if database exists(users is signed up)
        if (!databaseexists()) launchAuthenticationFragment();
        else launchMainActivity();
    }
    private boolean databaseexists()
    {
        File db=getApplicationContext().getDatabasePath("BelloBase");
        if(db.exists()) return true;
        else {
            Log.e("DataBase exists","NOPE");return false;}
    }

    //method to launch AuthenticationFragment
    private void launchAuthenticationFragment()
    {

        AuthenticationFragment authenticationFragment=new AuthenticationFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.constraint,authenticationFragment);
        transaction.commit();
    }
    //method to launch Main Activity
    private void launchMainActivity()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}