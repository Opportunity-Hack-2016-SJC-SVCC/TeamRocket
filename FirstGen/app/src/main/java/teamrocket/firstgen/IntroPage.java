package teamrocket.firstgen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

public class IntroPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);
    }
    public void onClickSignup(View view){

        Toast.makeText(this, "Signup clicked", Toast.LENGTH_LONG).show();
    }
    public void onClickLogin(View view){
        Intent intent = new Intent(this,MainPage.class);
        startActivity(intent);
        //Toast.makeText(this, "Login clicked", Toast.LENGTH_LONG).show();

    }

}
