package teamrocket.firstgen;

import android.content.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;

public class LoginPage extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.LoginPage);

        // get the Intent that started this Activity
        Intent in = getIntent();

        // get the Bundle that stores the data of this Activity
        Bundle b = in.getExtras();

        // getting data from bundle
        String login = b.getString("login");
        EditText text = (EditText) findViewById(R.id.confirmation);
        if (login == null)
        {
            text.setVisibility(View.GONE);
        }
    }
}
