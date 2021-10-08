package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginUser extends AppCompatActivity {
    private EditText inputName;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        inputName = findViewById(R.id.inputName);
        nextButton = findViewById(R.id.btnNext);

        nextButton.setOnClickListener(new View.OnClickListener() {

            Intent goToLibrary = new Intent(LoginUser.this, LibrarySFX.class);
            @Override
            public void onClick(View view) {
                String input = inputName.getText().toString();
                if(input.isEmpty()){
                    inputName.setError("Harap diisi");
                } else {
                    goToLibrary.putExtra("user",input);
                    startActivity(goToLibrary);
                }

            }
        });

    }
}