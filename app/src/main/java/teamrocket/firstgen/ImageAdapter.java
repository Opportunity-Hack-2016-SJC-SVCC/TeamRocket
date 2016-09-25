package teamrocket.firstgen;

import android.content.Intent;
import android.widget.BaseAdapter;

/**
 * Created by Tugce on 9/25/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ImageAdapter extends BaseAdapter{
    int [] result;
    Context context;
    List<Story> storyList;
    private static LayoutInflater inflater=null;
    public ImageAdapter(Context mContext, int[] imageList, List<Story> storyList) {
        // TODO Auto-generated constructor stub
        result=imageList;
        context=mContext;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.storyList=storyList;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.story_row, null);
        holder.img=(ImageView) rowView.findViewById(R.id.story_image);
        holder.img.setImageResource(result[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rowView.getContext(), StoriesPage.class);
                intent.putExtra("StoryImage", storyList.get(position).getStoryImage());
                intent.putExtra("Scholarship", storyList.get(position).getScholarship());
                intent.putExtra("Story", storyList.get(position).getStory());
                intent.putExtra("Name",storyList.get(position).getName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return rowView;
    }
}
