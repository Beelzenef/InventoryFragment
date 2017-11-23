package com.example.inventoryfragment.ui.about;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.inventoryfragment.R;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutActivity extends AppCompatActivity {

    View aboutPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.about_icon_github)
                .addGroup("Encuentrame en la red")
                .addEmail("elena.guzbla@gmail.com")
                .addWebsite("http://about.me/Beelzenef/")
                .addFacebook("elena.guzmanblanco")
                .addTwitter("Beelzenef_")
                .addYoutube("BeelzenefTV")
                .addPlayStore("com.geekstorming.inventory")
                .addInstagram("beelzenef_")
                .addGitHub("beelzenef")
                .create();

        setContentView(aboutPage);
    }
}
