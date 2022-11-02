package com.hfad.bello.FragmentFolder;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hfad.bello.DataBase;
import com.hfad.bello.MainActivity;
import com.hfad.bello.R;

import java.io.File;

public class AuthenticationFragment extends Fragment {

    private EditText name;
    private EditText email;
    private EditText password;
    private Button signUp;
    private DataBase dataBase;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("Fragment","Opening");
        View view= inflater.inflate(R.layout.fragment_authentication, container, false);
        if(databaseexists())launchMainActivity();
        name=view.findViewById(R.id.name);
        email=view.findViewById(R.id.email);
        password=view.findViewById(R.id.Password);
        signUp=view.findViewById(R.id.signUp);

        //signUp Listener
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBase=new DataBase(getContext());
                dataBase.inserUsertData(email.getText().toString(),name.getText().toString(),password.getText().toString());
                launchMainActivity();
            }
        });
        return view;
    }

    private void launchMainActivity()
    {
        Intent intent=new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    private boolean databaseexists()
    {
        File db=getContext().getDatabasePath("BelloBase");
        if(db.exists()) return true;
        else {
            Log.e("DataBase exists","NOPE");return false;}
    }
}