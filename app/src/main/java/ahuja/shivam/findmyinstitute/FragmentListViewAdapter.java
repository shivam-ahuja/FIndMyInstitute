package ahuja.shivam.findmyinstitute;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ahuja.shivam.findmyinstitute.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 Created by root on 4/4/17.
 */

public class FragmentListViewAdapter extends BaseAdapter {
   Context mContext;
    //ArrayList<DataDummy> mDataList;
    ArrayList<DataPojoClass> mDataList;
    LayoutInflater lif;
    public FragmentListViewAdapter(Context mContext, ArrayList<DataPojoClass> mDataList)
    {
        this.mContext=mContext;
        this.mDataList=mDataList;
        this.lif= LayoutInflater.from(mContext);
        Log.d("TAG","in On Create"+mDataList.size());
    }
    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder viewholderobj=null;
        if(view==null) {
         view=lif.inflate(R.layout.list_view_item_layout, viewGroup, false);
         viewholderobj=new ViewHolder(view);
            view.setTag(viewholderobj);
        }
        else {
            viewholderobj=(ViewHolder) view.getTag();
        }

        viewholderobj.name.setText(mDataList.get(i).getIName());
        viewholderobj.location.setText(mDataList.get(i).getICity());
        viewholderobj.email.setText(String.valueOf(mDataList.get(i).getIEmailid()));
        viewholderobj.fees.setText(String.valueOf(mDataList.get(i).getIFees()));
        Picasso.with(mContext).load(mDataList.get(i).getIImage()).error(R.mipmap.ic_launcher).into(viewholderobj.image);
        return view;
    }
}

class ViewHolder
{   TextView name;
    TextView location;
    TextView email;
    TextView fees;
    ImageView image;
    ViewHolder(View view)
    {
       name =(TextView)view.findViewById(R.id.institute_name);
       location=(TextView)view.findViewById(R.id.institute_location);
        email=(TextView)view.findViewById(R.id.institute_email);
       fees=(TextView)view.findViewById(R.id.institute_fees);
        image=(ImageView)view.findViewById(R.id.institute_image);

    }
}
