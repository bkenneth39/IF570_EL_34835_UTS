package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;


public class ProfilePage extends AppCompatActivity {
    private Toolbar toolbarprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        toolbarprofile =(Toolbar) findViewById(R.id.toolbarprofile);
        toolbarprofile.setTitle("Profile");

        toolbarprofile.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbarprofile.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}