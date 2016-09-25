package teamrocket.firstgen;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tugce on 9/25/2016.
 */
class StoryPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    int [] mResources;
    List<Story> mStoryList;

    public StoryPagerAdapter(Context context, int [] resources, List<Story> storyList) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResources=resources;
        mStoryList=storyList;
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final View itemView = mLayoutInflater.inflate(R.layout.story_view, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.story);
        imageView.setImageResource(mResources[position]);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(itemView.getContext(), StoriesPage.class);
                intent.putExtra("StoryImage", mStoryList.get(position).getStoryImage());
                intent.putExtra("Scholarship", mStoryList.get(position).getScholarship());
                intent.putExtra("Story", mStoryList.get(position).getStory());
                intent.putExtra("Name",mStoryList.get(position).getName());
                mContext.startActivity(intent);
            }
        });

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
