package teamrocket.firstgen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ScholarshipPage extends AppCompatActivity {
    private int mSponsorImage;
    private String mSponsorName;
    private String mScholarshipDeadline;
    private String mScholarshipAmount;
    private String mSponsorDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarship_page);
        Bundle extras = getIntent().getExtras();
        mSponsorName=extras.getString("Sponsor");
        mSponsorImage=extras.getInt("SponsorImage");
        mScholarshipDeadline=extras.getString("Deadline");
        mScholarshipAmount=extras.getString("Amount");
        mSponsorDescription=extras.getString("Description");

        ImageView sponsorImage=(ImageView)findViewById(R.id.sponsor_image);
        sponsorImage.setImageResource(mSponsorImage);

        TextView sponsorName=(TextView)findViewById(R.id.sponsor_name);
        sponsorName.setText(mSponsorName);

        TextView scholarshipDeadline=(TextView) findViewById(R.id.deadline);
        scholarshipDeadline.setText(mScholarshipDeadline);

        TextView scholarshipAmount=(TextView)findViewById(R.id.scholarship_amount);
        scholarshipAmount.setText(mScholarshipAmount);

        TextView sponsorDescription=(TextView)findViewById(R.id.scholarship_description);
        sponsorDescription.setText(mSponsorDescription);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(mSponsorName+" Scholarship");

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
