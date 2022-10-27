package com.hfad.bello.AdapterFolder;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hfad.bello.FragmentFolder.CalenderFragment;
import com.hfad.bello.FragmentFolder.ClubFragment;

public class VP_Adapter extends FragmentStateAdapter{

    public VP_Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==1)return new ClubFragment();
        else return new CalenderFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
