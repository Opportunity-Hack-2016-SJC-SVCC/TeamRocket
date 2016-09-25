package teamrocket.firstgen;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class StoryListPage extends AppCompatActivity {
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
        setContentView(R.layout.activity_story_list_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Stories");

        ListView listView=(ListView) findViewById(R.id.story_list);
        storyList=new ArrayList<Story>();
        getStories();
        ImageAdapter adapter=new ImageAdapter(getApplicationContext(), mResources,storyList );
        listView.setAdapter(adapter);
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
