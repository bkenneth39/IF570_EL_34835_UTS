package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.w3c.dom.Text;

public class DetailSFX extends AppCompatActivity {
    private TextView judulsfx;
    private TextView genresfx;
    private TextView deskripsisfx;
    private MediaPlayer sfxplayer;
    private Toolbar toolbardetail;
    private int audioURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sfx);

        judulsfx = (TextView) findViewById(R.id.judulsfx);
        genresfx = (TextView) findViewById(R.id.genresfx);
        deskripsisfx = (TextView) findViewById(R.id.deskripsisfx);
        toolbardetail = (Toolbar) findViewById(R.id.toolbardetail);

        toolbardetail.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbardetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(sfxplayer!=null){
                   sfxplayer.stop();
               }

                finish();
            }
        });

        Intent goToDetail = getIntent();
        Bundle bundleSFX = goToDetail.getExtras();
        SumberSFX sumbersfx = (SumberSFX) bundleSFX.getSerializable("DetailSFX");

        judulsfx.setText(sumbersfx.getJudulsfx());
        genresfx.setText(sumbersfx.getGenresfx());
        deskripsisfx.setText(sumbersfx.getDeskripsisfx());

        toolbardetail.setTitle(sumbersfx.getJudulsfx());

        audioURI = Integer.parseInt(sumbersfx.getAudioURI());


    }

//    @Override
//    public void onBackPressed(){
//        sfxplayer.stop();
//        super.onBackPressed();
//    }
    public void playSFX(View view){
        if (sfxplayer == null) {
            sfxplayer = MediaPlayer.create(this, audioURI);
        }
        sfxplayer.start();
    }
}