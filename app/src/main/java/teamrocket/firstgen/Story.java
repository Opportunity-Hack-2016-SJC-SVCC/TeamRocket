package teamrocket.firstgen;

import android.graphics.Bitmap;

/**
 * Created by Tugce on 9/25/2016.
 */
public class Story {
    private String name;
    private Bitmap image;
    private int storyImage;
    private String scholarship;
    private String date;
    private String story;

    public void setName(String name) {
        this.name = name;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public void setStoryImage(int storyImage) {
        this.storyImage = storyImage;
    }

    public String getName() {
        return name;
    }

    public String getScholarship() {
        return scholarship;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getStoryImage() {
        return storyImage;
    }

    public String getDate() {
        return date;
    }

    public String getStory() {
        return story;
    }
}
