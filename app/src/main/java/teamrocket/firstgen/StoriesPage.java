package teamrocket.firstgen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class StoriesPage extends AppCompatActivity {
    private int mStoryImage;
    private String mScholarship;
    private String mStory;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_page);
        Bundle extras = getIntent().getExtras();
        mScholarship=extras.getString("Scholarship");
        mStoryImage=extras.getInt("StoryImage");
        mStory=extras.getString("Story");
        mName=extras.getString("Name");

        ImageView scholarImage=(ImageView)findViewById(R.id.scholar_image);
        scholarImage.setImageResource(mStoryImage);

        TextView scholarName=(TextView)findViewById(R.id.scholar_name);
        scholarName.setText(mName);

        TextView story=(TextView) findViewById(R.id.story);
        story.setText(mStory);

        TextView scholarship=(TextView)findViewById(R.id.scholarship_name);
        scholarship.setText(mScholarship);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(mName+"'s Story");

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
