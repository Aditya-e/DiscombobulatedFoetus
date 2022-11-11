package com.hfad.bello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.hfad.bello.FragmentFolder.AddClubFragment;
import com.hfad.bello.FragmentFolder.ClubFragment;
import com.hfad.bello.FragmentFolder.JoinClubFragment;

public class JoinAddClub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_add_club);
        Intent intent=getIntent();
        String fragment=intent.getStringExtra("clubInformation");

        if(fragment.equals("1"))
        {
                AddClubFragment addClubFragment=new AddClubFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.join_add_linearLayout,addClubFragment);
                transaction.commit();
        }
        else{
            JoinClubFragment joinClubFragment=new JoinClubFragment();
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.join_add_linearLayout,joinClubFragment);
            transaction.commit();
        }
    }
}