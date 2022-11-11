//This fragment opens up when user clicks on addClub,it shows the layout to enter club name,and generate a unique code of the club
package com.hfad.bello.FragmentFolder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hfad.bello.R;
import com.hfad.bello.UniqueCode;

public class AddClubFragment extends Fragment {
    private Button uniqueCode;
    private EditText newClubName;
    private String code;
    private String a;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_club, container, false);
        uniqueCode=view.findViewById(R.id.uniqueCode);
        newClubName=view.findViewById(R.id.newClubName);

        uniqueCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef= database.getReference("Clubs");
                String code=newClubName.getText().toString();
                myRef.child(uniqueCode(code)).setValue("Admin 1");
            }
        });
        return view;
    }

    private String uniqueCode(String uid)
    {
        long time=System.currentTimeMillis();

        StringBuffer s=new StringBuffer(uid);
        while(time>0)
        {
            int n=(int)time%10;
            String c=Integer.toString(n);
            s=s.append(c);
            time/=10;
        }
        String code=s.toString();//code returns unique code in String type
        return code;
    }
}