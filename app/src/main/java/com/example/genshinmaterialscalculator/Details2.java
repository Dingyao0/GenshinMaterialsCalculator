package com.example.genshinmaterialscalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class Details2 extends AppCompatActivity {

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);

        viewPager = findViewById(R.id.view_pager);
        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<Weapon> weaponList = (ArrayList<Weapon>) db.getAllWeapons();

        prepareViewPager(viewPager, weaponList);

    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<Weapon> arrayList) {

        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        WeaponDetailsFragment fragment = new WeaponDetailsFragment();

        for (int i = 0; i < arrayList.size(); i++) {
            Bundle bundle = new Bundle();
            bundle.putString("title", arrayList.get(i).getName());
            bundle.putString("WeaponSpecial", arrayList.get(i).getSDescription());
            bundle.putString("WeaponInGame", arrayList.get(i).getIDescription());
            bundle.putString("WeaponDamage", arrayList.get(i).getAttackValue());
            bundle.putString("WeaponSubStatValue", arrayList.get(i).getSubStatValue());
            bundle.putInt("WeaponImg", arrayList.get(i).getImage());
            bundle.putInt("WeaponSubStat", arrayList.get(i).getSubStat());
            bundle.putString("Code", arrayList.get(i).getCode());
            bundle.putString("Rarity", arrayList.get(i).getRarity());
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, arrayList.get(i).getName());

            fragment = new WeaponDetailsFragment();

        }
        Intent intent = getIntent();
        int ID = intent.getExtras().getInt("ID");
        viewPager.setAdapter(adapter);
        Log.d("id", String.valueOf(ID));
        viewPager.setCurrentItem(ID - 1);
    }


    private class MainAdapter extends FragmentPagerAdapter {

        ArrayList<String> arrayList = new ArrayList<>();
        List<Fragment> fragmentList = new ArrayList<>();

        public void addFragment(Fragment fragment, String title) {

            fragmentList.add(fragment);
        }

        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return arrayList.get(position);
        }
    }


}
