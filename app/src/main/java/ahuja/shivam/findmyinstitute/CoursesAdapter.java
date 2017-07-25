package ahuja.shivam.findmyinstitute;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ahuja.shivam.findmyinstitute.R;

import java.util.ArrayList;

/**
 * Created by root on 7/5/17.
 */

public class CoursesAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<CoursePOJOClass> mArrayList;
    LayoutInflater lif;
    CoursesAdapter(ArrayList<CoursePOJOClass> arrayList, Context context)
    {
        this.mArrayList=arrayList;
        this.mContext=context;
        lif= LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=lif.inflate(R.layout.courses_offered_itemview,parent,false);
        }
        final TextView coursename=(TextView)convertView.findViewById(R.id.course_name_tv);
        final TextView coursedetail=(TextView)convertView.findViewById(R.id.course_detail_tv);
        final ImageView dropdowniv=(ImageView) convertView.findViewById(R.id.dropdown_iv);
        final LinearLayout mLinearLayout = (LinearLayout) convertView.findViewById(R.id.courses_offered_itemview_linearlayout);
        dropdowniv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coursedetail.getVisibility()== View.GONE)
                {
                    Toast.makeText(mContext,"setting visible", Toast.LENGTH_LONG).show();
                    coursedetail.setVisibility(View.VISIBLE);
                    dropdowniv.setImageResource(R.drawable.ic_arrow_drop_up_black_24px);
                }
               else{ coursedetail.setVisibility(View.GONE);
               dropdowniv.setImageResource(R.drawable.ic_arrow_drop_down_black_24px);
               }
            }
        });
        coursename.setText(mArrayList.get(position).getCourse());
        coursedetail.setText(mArrayList.get(position).getCourseDetail());
        return convertView;
    }
}
