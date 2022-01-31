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

public class CharDetails extends AppCompatActivity {

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        viewPager = findViewById(R.id.view_pager);
        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<Character> charactersList = (ArrayList<Character>) db.getAllCharacter();
        prepareViewPager(viewPager, charactersList);
        db.close();
    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<Character> arrayList) {

        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        CharacterDetailsFragment fragment = new CharacterDetailsFragment();
        for (int i = 0; i < arrayList.size(); i++) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", arrayList.get(i).getId());
            Log.d("IDDD",arrayList.get(i).getName()+" "+arrayList.get(i).getId());
            bundle.putString("title", arrayList.get(i).getName());
            bundle.putString("CharInGame", arrayList.get(i).getIDescription());
            bundle.putString("CharDamage", arrayList.get(i).getAttackValue());
            bundle.putString("Health", arrayList.get(i).getHp());
            bundle.putString("Shield", arrayList.get(i).getDef());
            bundle.putString("CharSubStatValue", arrayList.get(i).getSecondaryStatValue());
            bundle.putInt("CharImg", arrayList.get(i).getImage());
            bundle.putInt("CharSubStat", arrayList.get(i).getSecondaryStat());
            bundle.putString("Code", arrayList.get(i).getCode());
            bundle.putString("Rarity", arrayList.get(i).getRarity());
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, arrayList.get(i).getName());
            fragment = new CharacterDetailsFragment();

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
