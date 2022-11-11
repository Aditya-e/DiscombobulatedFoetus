package com.hfad.bello.FragmentFolder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.AppCompatImageButton;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.hfad.bello.DataBase;
import com.hfad.bello.JoinAddClub;
import com.hfad.bello.R;

import java.util.ArrayList;
import java.util.List;

public class ClubFragment extends Fragment {

    private ListView clubListView;
    private Toolbar toolbar;
    private ImageButton joinClub,newClub;
    List clubList=new ArrayList();
    private ArrayAdapter arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_club, container, false);
        clubListView=view.findViewById(R.id.clubList);
        toolbar=view.findViewById(R.id.toolbar);
        joinClub=view.findViewById(R.id.joinClub);
        newClub=view.findViewById(R.id.newClub);

        //Opening add club fragment on clicking new Club button
        newClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(), JoinAddClub.class);
                intent.putExtra("clubInformation","1");
                startActivity(intent);
            }
        });

        joinClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(), JoinAddClub.class);
                intent.putExtra("clubInformation","0");
                startActivity(intent);

//                AddClubFragment addClubFragment=new AddClubFragment();
//                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.linearLayoutMain,addClubFragment);
//                transaction.commit();
            }
        });


        SQLiteOpenHelper helper=new DataBase(getContext());
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("BelloBase",new String[]{"CLUBS"},null,null,null,null,null);
        String name=cursor.getString(0);
        clubList.add(name);
        while(cursor.moveToNext())
        {
            name=cursor.getString(0);
            clubList.add(name);
        }

        arrayAdapter=new ArrayAdapter(getContext(),R.layout.club_name_sample,clubList);
        clubListView.setAdapter(arrayAdapter);
        return view;
    }
}