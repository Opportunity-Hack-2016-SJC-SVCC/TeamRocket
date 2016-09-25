package teamrocket.firstgen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProfilePage extends AppCompatActivity {

        private EditText f_name, l_name, city, email, major, ziptxt, gpatxt;
        private int zipcode;
        private double gpa;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile_page);

//        f_name = (EditText) findViewById(R.id.first_name);
//        l_name = (EditText) findViewById(R.id.last_name);
//        city = (EditText) findViewById(R.id.city_name);
//        email = (EditText) findViewById(R.id.email);
//        major = (EditText) findViewById(R.id.major);
//
//        ziptxt = (EditText) findViewById(R.id.zip_code);
//        zipcode = (Integer.parseInt(ziptxt.getText().toString()));
//        gpatxt = (EditText) findViewById(R.id.gpa);
//        gpa = (Double.parseDouble(gpatxt.getText().toString()));

        }

        public void onClickCancel(View view) {
            // cancel current input and go back to the previous data
        }

        public void onClickSave(View view) {
            // save current input
        }
}
