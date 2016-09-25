package teamrocket.firstgen;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ScholarshipListPage extends AppCompatActivity {
    private ScholarshipListAdapter mScholarshipAdapter;
    private List<Scholarship> scholarshipList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarship_list_page);
        //Scholarship List
        RecyclerView cardList1 = (RecyclerView) findViewById(R.id.scholarships_list);
        cardList1.setHasFixedSize(true);
        scholarshipList = new ArrayList<Scholarship>();
        getScholarships();
        mScholarshipAdapter = new ScholarshipListAdapter(this, scholarshipList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        cardList1.setLayoutManager(llm);
        cardList1.setAdapter(mScholarshipAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Scholarships");

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

    private void getScholarships(){
        Scholarship item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor1));
        item.setScholarshipName("Hispanic Scholarship Fund");
        item.setScholarshipDescription("Founded in 1975, the Hispanic Scholarship Fund provides scholarships to Latino students, as well as related support services. HSF seeks to give students all the tools they need to apply to college, ...");
        item.setDueDate("12/19/2016");
        item.setScholarship("$30,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor2));
        item.setScholarshipName("United Negro College Fund");
        item.setScholarshipDescription("UNCF- the United Negro College Fund is the administrator of the Gates Millennium Scholar Program. The partnership with UNCF the Bill and Melinda Gates Foundation established the program...");
        item.setDueDate("11/17/2016");
        item.setScholarship("$15,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor3));
        item.setScholarshipName("Asian & Pacific Islander American Scholarship Fund (APIASF)");
        item.setScholarshipDescription("Based in Washington, D.C., the Asian & Pacific Islander American Scholarship Fund (APIASF) is the nation’s largest non-profit provider of college scholarships for Asian Americans...");
        item.setDueDate("10/12/2016");
        item.setScholarship("$19,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor4));
        item.setScholarshipName("American Indian Graduate Center Scholars (AIGCS)");
        item.setScholarshipDescription("American Indian Graduate Center Scholars (AIGCS) was created in 2001 to partner in the administration of the Gates Millennium Scholars (GMS) Program. AIGCS is...");
        item.setDueDate("11/13/2016");
        item.setScholarship("$52,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor1));
        item.setScholarshipName("Hispanic Scholarship Fund");
        item.setScholarshipDescription("Founded in 1975, the Hispanic Scholarship Fund provides scholarships to Latino students, as well as related support services. HSF seeks to give students all the tools they need to apply to college,...");
        item.setDueDate("11/30/2016");
        item.setScholarship("$10,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor2));
        item.setScholarshipName("United Negro College Fund");
        item.setScholarshipDescription("UNCF- the United Negro College Fund is the administrator of the Gates Millennium Scholar Program. The partnership with UNCF the Bill and Melinda Gates Foundation established the program...");
        item.setDueDate("10/18/2016");
        item.setScholarship("$45,000.00");
        scholarshipList.add(item);


        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor3));
        item.setScholarshipName("Asian & Pacific Islander American Scholarship Fund (APIASF)");
        item.setScholarshipDescription("Based in Washington, D.C., the Asian & Pacific Islander American Scholarship Fund (APIASF) is the nation’s largest non-profit provider of college scholarships for Asian Americans...");
        item.setDueDate("11/25/2016 ");
        item.setScholarship("$5,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor4));
        item.setScholarshipName("American Indian Graduate Center Scholars (AIGCS");
        item.setScholarshipDescription("American Indian Graduate Center Scholars (AIGCS) was created in 2001 to partner in the administration of the Gates Millennium Scholars (GMS) Program. AIGCS is...");
        item.setDueDate("02/19/2016,Friday ");
        item.setScholarship("$16,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor1));
        item.setScholarshipName("Hispanic Scholarship Fund");
        item.setScholarshipDescription("Founded in 1975, the Hispanic Scholarship Fund provides scholarships to Latino students, as well as related support services. HSF seeks to give students all the tools they need to apply to college,...");
        item.setDueDate("10/16/2016,Friday ");
        item.setScholarship("$12,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor2));
        item.setScholarshipName("United Negro College Fund");
        item.setScholarshipDescription("UNCF- the United Negro College Fund is the administrator of the Gates Millennium Scholar Program. The partnership with UNCF the Bill and Melinda Gates Foundation established the program...");
        item.setDueDate("12/15/2016,Friday ");
        item.setScholarship("$50,000.00");
        scholarshipList.add(item);
    }
}
