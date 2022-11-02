//This fragment opens up when user clicks on addClub,it shows the layout to enter club name,and generate a unique code of the club
package com.hfad.bello.FragmentFolder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.bello.R;

public class AddClubFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_club, container, false);
        return view;
    }
}