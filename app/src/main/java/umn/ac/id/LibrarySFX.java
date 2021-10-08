package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.LinkedList;

public class LibrarySFX extends AppCompatActivity {
    SumberSFXAdapter sfxAdapter;
    LinkedList<SumberSFX> sfxes = new LinkedList<>();
    RecyclerView SfxList;
    Toolbar toolbarlibrary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_sfx);
        Intent goToLibrary = getIntent();
        String user_name = goToLibrary.getStringExtra("user");

//        if(user_name!=null){
//            ((username) this.getApplication()).setUsername(user_name);
//        } else if(user_name==null){
//            user_name = ((username) this.getApplication()).getUsername();
//        }


        toolbarlibrary = (Toolbar) findViewById(R.id.tooolbarlibrary);
        toolbarlibrary.setTitle(user_name);
        toolbarlibrary.inflateMenu(R.menu.menu_options);


        toolbarlibrary.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.go_profile:
                        Intent goprofile = new Intent(LibrarySFX.this, ProfilePage.class);
                        startActivity(goprofile);
                        return true;
                    case R.id.go_main:
                        Intent gomain = new Intent(LibrarySFX.this, MainActivity.class);
                        startActivity(gomain);
                        return true;
                    default:
                        return false;
                }
            }
        });

        Toast.makeText(getApplicationContext(), "Selamat Datang, " + user_name, Toast.LENGTH_LONG)
                .show();

        LoadSFXList();
        SfxList = (RecyclerView) findViewById(R.id.recyclerView);
        sfxAdapter = new SumberSFXAdapter(this, sfxes);
        SfxList.setAdapter(sfxAdapter);
        SfxList.setLayoutManager(new LinearLayoutManager(this));

    }

    public void LoadSFXList(){
        sfxes.add(new SumberSFX("Gun Shot", "Boom", Integer.toString(R.raw.gun),"SFX about gun shooting"));
        sfxes.add(new SumberSFX("Children Yay", "People", Integer.toString(R.raw.childrenyay),"SFX about children yay!"));
        sfxes.add(new SumberSFX("Dead Mario", "Game", Integer.toString(R.raw.deadmario),"Sound made when Mario dead"));
        sfxes.add(new SumberSFX("Game over", "Game", Integer.toString(R.raw.gameover),"This is the sound when you're suck playing game"));
        sfxes.add(new SumberSFX("Announcement", "Real-life", Integer.toString(R.raw.announcement),"Announcement in airport"));
        sfxes.add(new SumberSFX("David Gadgetin", "People", Integer.toString(R.raw.davidgadetin),"Your Favourite Tech Youtuber"));
        sfxes.add(new SumberSFX("Sheesh", "People", Integer.toString(R.raw.sheesh),"The sound of Sheeshhh!"));
    }


}