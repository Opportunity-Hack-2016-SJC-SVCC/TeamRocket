package teamrocket.firstgen;

import android.graphics.Bitmap;

/**
 * Created by Tugce on 9/25/2016.
 */
public class Scholarship  {
    private String scholarshipName= null;
    private String scholarshipDescription=null;
    private String scholarship=null;
    private String dueDate=null;
    private Bitmap sponsorImage;

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public void setScholarshipDescription(String scholarshipDescription) {
        this.scholarshipDescription = scholarshipDescription;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setSponsorImage(Bitmap sponsorImage) {
        this.sponsorImage = sponsorImage;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public String getScholarshipDescription() {
        return scholarshipDescription;
    }

    public String getScholarship() {
        return scholarship;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Bitmap getSponsorImage() {
        return sponsorImage;
    }
}


