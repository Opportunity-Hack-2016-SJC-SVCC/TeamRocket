package teamrocket.firstgen;

/**
 * Created by Tugce on 9/25/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class ScholarshipListAdapter extends RecyclerView.Adapter<ScholarshipListAdapter.MyViewHolder>  implements View.OnClickListener{
    private Context mContext;
    private List<Scholarship> scholarshipList;
    private int position=0;

    @Override
    public void onClick(View view) {

        Intent intent=new Intent(mContext, ScholarshipPage.class);
        intent.putExtra("SponsorImage", scholarshipList.get(position).getSponsorImage());
        intent.putExtra("Amount", scholarshipList.get(position).getScholarship());
        intent.putExtra("Deadline", scholarshipList.get(position).getDueDate());
        intent.putExtra("Description",scholarshipList.get(position).getScholarshipDescription());
        intent.putExtra("Sponsor",scholarshipList.get(position).getScholarshipName());
        mContext.startActivity(intent);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title,description,dueDate,scholarship;

        public MyViewHolder(View view) {
            super(view);
            image=(ImageView) view.findViewById(R.id.sponsor_image);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.scholarship_description);
            dueDate = (TextView) view.findViewById(R.id.due_date);
            scholarship = (TextView) view.findViewById(R.id.scholarship_amount);
        }
    }

    public ScholarshipListAdapter(Context mContext, List<Scholarship> scholarshipList) {
        this.mContext = mContext;
        this.scholarshipList = scholarshipList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scholarship_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Scholarship item = scholarshipList.get(position);
        holder.image.setImageBitmap(item.getSponsorImage());
        holder.title.setText(item.getScholarshipName());
        holder.description.setText(item.getScholarshipDescription().substring(0,300));
        holder.dueDate.setText(item.getDueDate());
        holder.scholarship.setText(item.getScholarship());
        this.position=position;

    }

    @Override
    public int getItemCount() {
        return scholarshipList.size();
    }


}