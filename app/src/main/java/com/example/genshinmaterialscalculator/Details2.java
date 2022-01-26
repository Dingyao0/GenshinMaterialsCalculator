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

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Details2 extends AppCompatActivity {

    //    TabLayout tabLayout;
    private ViewPager viewPager;
    private ExpandableRelativeLayout mycontent;
    private View layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        layout = (View) findViewById(R.id.detailsBG);

//        tabLayout=findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        DatabaseHandler lstWeapons = new DatabaseHandler(this);
        ArrayList<Weapon> weaponsList = (ArrayList<Weapon>) lstWeapons.getAllWeapons();
        Log.d("hi", String.valueOf(weaponsList));
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Tab 1");
        arrayList.add("Tab 2");
        arrayList.add("Tab 3");

        prepareViewPager(viewPager, weaponsList);

    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<Weapon> arrayList) {

        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        MainFragment fragment = new MainFragment();

        for (int i = 0; i < arrayList.size(); i++) {
            Bundle bundle = new Bundle();
            bundle.putString("title", arrayList.get(i).getName());
            bundle.putString("WeaponSpecial", arrayList.get(i).getSDescription());
            bundle.putString("WeaponInGame", arrayList.get(i).getIDescription());
            bundle.putString("WeaponDamage", arrayList.get(i).getAttackValue());
            bundle.putString("WeaponSubStatValue", arrayList.get(i).getSubStatValue());
            bundle.putInt("WeaponImg", arrayList.get(i).getImage());
            bundle.putInt("WeaponSubStat", arrayList.get(i).getSubStat());
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, arrayList.get(i).getSDescription());
            fragment = new MainFragment();
        }
        Intent intent = getIntent();
        int ID = intent.getExtras().getInt("ID");
        viewPager.setAdapter(adapter);
        Log.d("id", String.valueOf(ID));
        viewPager.setCurrentItem(ID-1);
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

    public void show(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.details1:
                mycontent = (ExpandableRelativeLayout) findViewById(R.id.special);
                mycontent.toggle();
                break;
            case R.id.details2:
                mycontent = (ExpandableRelativeLayout) findViewById(R.id.inGame);
                mycontent.toggle();
                break;
            case R.id.moreDetails:
//                Intent intent = new Intent(this, com.example.genshinmaterialscalculator.Webview.class);
//                startActivity(intent);
                String value = "Hello world";
                Intent intent = new Intent(Details2.this, Webview.class);
                intent.putExtra("key", "w_1101");
                startActivity(intent);
                break;
        }

    }

}
