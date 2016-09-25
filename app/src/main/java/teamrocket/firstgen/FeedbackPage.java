package teamrocket.firstgen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class FeedbackPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_page);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            // getSupportActionBar().setTitle("johnsmith@johnsmith.com");
            toolbar.hideOverflowMenu();
            toolbar.setNavigationIcon(R.drawable.close);

            EditText feedbackText=(EditText) findViewById(R.id.feedback_text);
            feedbackText.setText("\n"+"====="+"\n"+"Please take a moment to review your experience with us. Your feedback will be helpful."+"\n"+
                    " =====");

            ImageView btnSend=(ImageView)findViewById(R.id.send);
            btnSend.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            if (item.getItemId() == android.R.id.home) {
                this.finish();
            }
            return super.onOptionsItemSelected(item);
        }
    }

