package teamrocket.firstgen;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int NUM_PAGES = 5;
    private int currentPage;
    private HeightWrappingViewPager vpStories;
    private Timer swipeTimer;
    private StoryPagerAdapter mStoryAdapter;
    private ScholarshipListAdapter mScholarshipAdapter;
    private List<Scholarship> scholarshipList;
    private List<Story> storyList;
    int[] mResources = {
            R.drawable.success_athena,
            R.drawable.success_ali,
            R.drawable.success_jenny,
            R.drawable.success_athena,
            R.drawable.success_ali
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Stories
        storyList=new ArrayList<Story>();
        getStories();
        vpStories = (HeightWrappingViewPager) findViewById(R.id.success_stories_view);
        mStoryAdapter = new StoryPagerAdapter(this, mResources,storyList);
        vpStories.setAdapter(mStoryAdapter);


        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                currentPage=currentPage%6;
                vpStories.setCurrentItem(currentPage++, true);
            }
        };

        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 800, 9000);


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
        /*cardList1.OnItemTouchListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainPage.this, ScholarshipPage.class);
                        intent.putExtra("SponsorImage", scholarshipList.get(position).getSponsorImage());
                        intent.putExtra("Amount", scholarshipList.get(position).getScholarship());
                        intent.putExtra("Deadline", scholarshipList.get(position).getDueDate());
                        intent.putExtra("Description",scholarshipList.get(position).getScholarshipDescription());
                        intent.putExtra("Sponsor",scholarshipList.get(position).getScholarshipName());startActivity(intent);
                    }
                });*/


        ImageView  about=(ImageView)findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainPage.this,AboutPage.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      /*  if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, ProfilePage.class);
            startActivity(intent);
        } else if (id == R.id.nav_scholarships) {
            Intent intent = new Intent(this, ScholarshipListPage.class);
            startActivity(intent);

        } else if (id == R.id.nav_stories) {
            Intent intent = new Intent(this, StoryListPage.class);
            startActivity(intent);

        } else if(id== R.id.nav_feedback){
            Intent intent = new Intent(this, FeedbackPage.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getScholarships(){
        Scholarship item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor1));
        item.setScholarshipName("Hispanic Scholarship Fund");
        item.setScholarshipDescription("Founded in 1975, the Hispanic Scholarship Fund provides scholarships to Latino students, as well as related support services. HSF seeks to give students all the tools they need to apply to college, do well in their course work, graduate, enter a profession, excel, help lead our nation going forward, and mentor the generations to come.As the nation’s largest not-for-profit organization supporting Hispanic American higher education, HSF has awarded over $430 million in scholarships and provides a range of ancillary programs for students, scholars, and their families. HSF further strives to make college education a top priority for every Latino family across the nation and to mobilize our community to proactively advance that goal – each individual, over a lifetime, in every way he/she can.For more information about the Hispanic Scholarship Fund please visit: www.HSF.net. ");
        item.setDueDate("12/19/2016");
        item.setScholarship("$30,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor2));
        item.setScholarshipName("United Negro College Fund");
        item.setScholarshipDescription("UNCF- the United Negro College Fund is the administrator of the Gates Millennium Scholar Program. The partnership with UNCF the Bill and Melinda Gates Foundation established the program in established in 1999, as a 1.6 billion dollar initiative funded grant.For more than seven decades, A mind is a terrible thing to waste.”® has remained at the heart of UNCF, enabling them to help more than 430,000 students and counting not just attend college, but thrive, graduate and become leaders.The approach to do this work is done in three ways: By awarding more than 10,000 students scholarships, worth more than $100 million, each year. By providing financial support to 37 historically black colleges and universities (HBCUs). And by serving as the nation’s leading advocate for the importance of minority education and community engagement.This three-pronged approach is powerful: Since our founding in 1944, we’ve helped to more than double the number of minorities attending college. The six-year graduation rate for UNCF African American scholarship recipients is 70 percent. This is 11 percentage points higher than the national average and 31 percentage points higher than the national average for all African Americans.To learn more about UNCF please visit their website at www.uncf.org.");

        item.setDueDate("11/17/2016");
        item.setScholarship("$15,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor3));
        item.setScholarshipName("Asian & Pacific Islander American Scholarship Fund (APIASF)");
        item.setScholarshipDescription("Based in Washington, D.C., the Asian & Pacific Islander American Scholarship Fund (APIASF) is the nation’s largest non-profit provider of college scholarships for Asian Americans and Pacific Islanders (AAPI). APIASF creates opportunities for students to access, complete, and succeed after post-secondary education; thereby developing future leaders who will excel in their careers, serve as role models in their communities, and will ultimately contribute to a more vibrant America. Since 2003, APIASF has distributed nearly $90 million in scholarships to AAPI students across the country and in the Pacific Islands. APIASF manages three scholarship programs: APIASF’s general scholarship, the APIASF Asian American and Native American Pacific Islander – Serving Institutions scholarship program and the Gates Millennium Scholars/Asian Pacific Islander Americans funded by a grant from the Bill & Melinda Gates Foundation.For information about the Asian & Pacific Islander American Scholarship Fund please visit: www.apiasf.org ");
        item.setDueDate("10/12/2016");
        item.setScholarship("$19,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor4));
        item.setScholarshipName("American Indian Graduate Center Scholars (AIGCS)");
        item.setScholarshipDescription("American Indian Graduate Center Scholars (AIGCS) was created in 2001 to partner in the administration of the Gates Millennium Scholars (GMS) Program. AIGCS is the American Indian and Alaska Native representative, performing outreach to qualified applicants, assisting in the execution and completion of GMS application and selection process, disbursing awards and providing student services to Gate Millennium Scholars, within the policies and metrics of the GMS Program. AIGCS is an associate of American Indian Graduate Center (AIGC), which was established in 1969 to build, promote and honor self-sustaining American Indian and Alaska Native communities through education and leadership. The founders’ vision of American Indian college graduates pursuing masters, doctoral and professional degrees in all fields of study has yielded over 15,000 scholarships totaling over $44 million. AIGC is the oldest and largest national provider of scholarships for American Indian and Alaska Native graduate students.For information about the American Indian Graduate Center Scholars please visit: www.aigcs.org");
        item.setDueDate("11/13/2016");
        item.setScholarship("$52,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor1));
        item.setScholarshipName("Hispanic Scholarship Fund");
        item.setScholarshipDescription("Founded in 1975, the Hispanic Scholarship Fund provides scholarships to Latino students, as well as related support services. HSF seeks to give students all the tools they need to apply to college, do well in their course work, graduate, enter a profession, excel, help lead our nation going forward, and mentor the generations to come.As the nation’s largest not-for-profit organization supporting Hispanic American higher education, HSF has awarded over $430 million in scholarships and provides a range of ancillary programs for students, scholars, and their families. HSF further strives to make college education a top priority for every Latino family across the nation and to mobilize our community to proactively advance that goal – each individual, over a lifetime, in every way he/she can.For more information about the Hispanic Scholarship Fund please visit: www.HSF.net.       ");
        item.setDueDate("11/30/2016");
        item.setScholarship("$10,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor2));
        item.setScholarshipName("United Negro College Fund");
        item.setScholarshipDescription("UNCF- the United Negro College Fund is the administrator of the Gates Millennium Scholar Program. The partnership with UNCF the Bill and Melinda Gates Foundation established the program in established in 1999, as a 1.6 billion dollar initiative funded grant.For more than seven decades, A mind is a terrible thing to waste.”® has remained at the heart of UNCF, enabling them to help more than 430,000 students and counting not just attend college, but thrive, graduate and become leaders.The approach to do this work is done in three ways: By awarding more than 10,000 students scholarships, worth more than $100 million, each year. By providing financial support to 37 historically black colleges and universities (HBCUs). And by serving as the nation’s leading advocate for the importance of minority education and community engagement.This three-pronged approach is powerful: Since our founding in 1944, we’ve helped to more than double the number of minorities attending college. The six-year graduation rate for UNCF African American scholarship recipients is 70 percent. This is 11 percentage points higher than the national average and 31 percentage points higher than the national average for all African Americans.To learn more about UNCF please visit their website at www.uncf.org." );
        item.setDueDate("10/18/2016");
        item.setScholarship("$45,000.00");
        scholarshipList.add(item);


        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor3));
        item.setScholarshipName("Asian & Pacific Islander American Scholarship Fund (APIASF)");
        item.setScholarshipDescription("Based in Washington, D.C., the Asian & Pacific Islander American Scholarship Fund (APIASF) is the nation’s largest non-profit provider of college scholarships for Asian Americans and Pacific Islanders (AAPI). APIASF creates opportunities for students to access, complete, and succeed after post-secondary education; thereby developing future leaders who will excel in their careers, serve as role models in their communities, and will ultimately contribute to a more vibrant America. Since 2003, APIASF has distributed nearly $90 million in scholarships to AAPI students across the country and in the Pacific Islands. APIASF manages three scholarship programs: APIASF’s general scholarship, the APIASF Asian American and Native American Pacific Islander – Serving Institutions scholarship program and the Gates Millennium Scholars/Asian Pacific Islander Americans funded by a grant from the Bill & Melinda Gates Foundation.For information about the Asian & Pacific Islander American Scholarship Fund please visit: www.apiasf.org        ");
        item.setDueDate("11/25/2016 ");
        item.setScholarship("$5,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor4));
        item.setScholarshipName("American Indian Graduate Center Scholars (AIGCS");
        item.setScholarshipDescription("American Indian Graduate Center Scholars (AIGCS) was created in 2001 to partner in the administration of the Gates Millennium Scholars (GMS) Program. AIGCS is the American Indian and Alaska Native representative, performing outreach to qualified applicants, assisting in the execution and completion of GMS application and selection process, disbursing awards and providing student services to Gate Millennium Scholars, within the policies and metrics of the GMS Program. AIGCS is an associate of American Indian Graduate Center (AIGC), which was established in 1969 to build, promote and honor self-sustaining American Indian and Alaska Native communities through education and leadership. The founders’ vision of American Indian college graduates pursuing masters, doctoral and professional degrees in all fields of study has yielded over 15,000 scholarships totaling over $44 million. AIGC is the oldest and largest national provider of scholarships for American Indian and Alaska Native graduate students.For information about the American Indian Graduate Center Scholars please visit: www.aigcs.org  ");
        item.setDueDate("02/19/2016,Friday ");
        item.setScholarship("$16,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor1));
        item.setScholarshipName("Hispanic Scholarship Fund");
        item.setScholarshipDescription("Founded in 1975, the Hispanic Scholarship Fund provides scholarships to Latino students, as well as related support services. HSF seeks to give students all the tools they need to apply to college, do well in their course work, graduate, enter a profession, excel, help lead our nation going forward, and mentor the generations to come.As the nation’s largest not-for-profit organization supporting Hispanic American higher education, HSF has awarded over $430 million in scholarships and provides a range of ancillary programs for students, scholars, and their families. HSF further strives to make college education a top priority for every Latino family across the nation and to mobilize our community to proactively advance that goal – each individual, over a lifetime, in every way he/she can.For more information about the Hispanic Scholarship Fund please visit: www.HSF.net.  ");
        item.setDueDate("10/16/2016,Friday ");
        item.setScholarship("$12,000.00");
        scholarshipList.add(item);

        item=new Scholarship();
        item.setSponsorImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.sponsor2));
        item.setScholarshipName("United Negro College Fund");
        item.setScholarshipDescription("UNCF- the United Negro College Fund is the administrator of the Gates Millennium Scholar Program. The partnership with UNCF the Bill and Melinda Gates Foundation established the program in established in 1999, as a 1.6 billion dollar initiative funded grant.For more than seven decades, A mind is a terrible thing to waste.”® has remained at the heart of UNCF, enabling them to help more than 430,000 students and counting not just attend college, but thrive, graduate and become leaders.The approach to do this work is done in three ways: By awarding more than 10,000 students scholarships, worth more than $100 million, each year. By providing financial support to 37 historically black colleges and universities (HBCUs). And by serving as the nation’s leading advocate for the importance of minority education and community engagement.This three-pronged approach is powerful: Since our founding in 1944, we’ve helped to more than double the number of minorities attending college. The six-year graduation rate for UNCF African American scholarship recipients is 70 percent. This is 11 percentage points higher than the national average and 31 percentage points higher than the national average for all African Americans.To learn more about UNCF please visit their website at www.uncf.org.        " );
        item.setDueDate("12/15/2016,Friday ");
        item.setScholarship("$50,000.00");
        scholarshipList.add(item);
    }

    private void getStories(){
        Story item=new Story();
        item.setImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.success_athena));

        item.setStoryImage(R.drawable.athena_txt);
        item.setName("Athena Miller");
        item.setScholarship("Asian & Pacific Islander American Scholarship Fund (APIASF)- 2015' Scholar");
        item.setStory("Athena Miller’s story is one which many students looking to pay for school can relate to and gain inspiration from. Like students of all ages, she found herself in the all-too-common conundrum of having college aspirations without the finances to make her dreams a reality. Most students aren’t independently wealthy, after all.\n" +
                "\n" +
                "However, Athena’s scholarship story is unique due to the fact that her search began later than that of a typical college student. One of her goals in life had always been to get a college degree. " +
                "\n" +
                "Like many thirty-somethings, she was on a tight budget and still had student loans from when she had originally attended college. Athena shared that, while it was helpful to attend classes, she was taking one or two at a time and began to become concerned at how long the process was taking. Plus, it was difficult to fit in a full-time job and taking care of her kids on top of classes.\n" +
                "\n" +
                "As a result, she shifted her goals, feeling that it was better for her to work toward her degree full-time, so she wouldn’t have to take night courses which would impact her kids. That’s exactly what Spivey set out to do.");
        storyList.add(item);

        item=new Story();
        item.setImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.success_ali));

        item.setStoryImage(
                R.drawable.ali_text);
        item.setName("Ali Yilmaz");
        item.setScholarship("Asian & Pacific Islander American Scholarship Fund (APIASF)- 2015' Scholar");
        item.setStory("Ali Yilmaz’s story is one which many students looking to pay for school can relate to and gain inspiration from. Like students of all ages, she found herself in the all-too-common conundrum of having college aspirations without the finances to make her dreams a reality. Most students aren’t independently wealthy, after all.\n" +
        "\n" +
                "However, Athena’s scholarship story is unique due to the fact that her search began later than that of a typical college student. One of her goals in life had always been to get a college degree. " +
                "\n" +
                "Like many thirty-somethings, she was on a tight budget and still had student loans from when she had originally attended college. Athena shared that, while it was helpful to attend classes, she was taking one or two at a time and began to become concerned at how long the process was taking. Plus, it was difficult to fit in a full-time job and taking care of her kids on top of classes.\n" +
                "\n" +
                "As a result, she shifted her goals, feeling that it was better for her to work toward her degree full-time, so she wouldn’t have to take night courses which would impact her kids. That’s exactly what Spivey set out to do.");
        storyList.add(item);

        item=new Story();
        item.setImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.success_jenny));

        item.setStoryImage(
                R.drawable.jenny_txt);
        item.setName("Jenny Sun");

        item.setScholarship("Asian & Pacific Islander American Scholarship Fund (APIASF)- 2015' Scholar");
        item.setStory("Jenny Sun’s story is one which many students looking to pay for school can relate to and gain inspiration from. Like students of all ages, she found herself in the all-too-common conundrum of having college aspirations without the finances to make her dreams a reality. Most students aren’t independently wealthy, after all.\n" +
        "\n" +
                "However, Athena’s scholarship story is unique due to the fact that her search began later than that of a typical college student. One of her goals in life had always been to get a college degree. " +
                "\n" +
                "Like many thirty-somethings, she was on a tight budget and still had student loans from when she had originally attended college. Athena shared that, while it was helpful to attend classes, she was taking one or two at a time and began to become concerned at how long the process was taking. Plus, it was difficult to fit in a full-time job and taking care of her kids on top of classes.\n" +
                "\n" +
                "As a result, she shifted her goals, feeling that it was better for her to work toward her degree full-time, so she wouldn’t have to take night courses which would impact her kids. That’s exactly what Spivey set out to do.");
        storyList.add(item);

        item=new Story();
        item.setImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.success_athena));
        item.setName("Athena Miller");
        item.setStoryImage(
                R.drawable.athena_txt);

        item.setScholarship("Asian & Pacific Islander American Scholarship Fund (APIASF)- 2015' Scholar");
        item.setStory("Athena Miller’s story is one which many students looking to pay for school can relate to and gain inspiration from. Like students of all ages, she found herself in the all-too-common conundrum of having college aspirations without the finances to make her dreams a reality. Most students aren’t independently wealthy, after all. " +
                "\n" +
                        "However, Athena’s scholarship story is unique due to the fact that her search began later than that of a typical college student. One of her goals in life had always been to get a college degree. " +
                        "\n" +
                        "Like many thirty-somethings, she was on a tight budget and still had student loans from when she had originally attended college. Athena shared that, while it was helpful to attend classes, she was taking one or two at a time and began to become concerned at how long the process was taking. Plus, it was difficult to fit in a full-time job and taking care of her kids on top of classes.\n" +
                        "\n" +
                        "As a result, she shifted her goals, feeling that it was better for her to work toward her degree full-time, so she wouldn’t have to take night courses which would impact her kids. That’s exactly what Spivey set out to do.");
        storyList.add(item);

        item=new Story();
        item.setImage(BitmapFactory.decodeResource(
                getResources(),
                R.drawable.success_ali));

        item.setStoryImage(
                R.drawable.ali_text);
        item.setName("Ali Yilmaz");

        item.setScholarship("Asian & Pacific Islander American Scholarship Fund (APIASF)- 2015' Scholar");
        item.setStory("Ali Yilmaz’s story is one which many students looking to pay for school can relate to and gain inspiration from. Like students of all ages, she found herself in the all-too-common conundrum of having college aspirations without the finances to make her dreams a reality. Most students aren’t independently wealthy, after all. " +
                "\n" +
                "However, Athena’s scholarship story is unique due to the fact that her search began later than that of a typical college student. One of her goals in life had always been to get a college degree. " +
                "\n" +
                "Like many thirty-somethings, she was on a tight budget and still had student loans from when she had originally attended college. Athena shared that, while it was helpful to attend classes, she was taking one or two at a time and began to become concerned at how long the process was taking. Plus, it was difficult to fit in a full-time job and taking care of her kids on top of classes.\n" +
                "\n" +
                "As a result, she shifted her goals, feeling that it was better for her to work toward her degree full-time, so she wouldn’t have to take night courses which would impact her kids. That’s exactly what Spivey set out to do.");
        storyList.add(item);

    }
}
