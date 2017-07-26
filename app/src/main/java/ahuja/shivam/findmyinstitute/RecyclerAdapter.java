package ahuja.shivam.findmyinstitute;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ahuja.shivam.findmyinstitute.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by root on 28/5/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
   Base_Activity mContext;
    ArrayList<DataPojoClass> mDataList;
    RecyclerAdapter(Base_Activity context, ArrayList<DataPojoClass> arrayList)
   {
    this.mDataList=arrayList;
       this.mContext=context;
   }

    public class ViewHolder extends RecyclerView.ViewHolder
    {   TextView name;
        TextView location;
        TextView email;
        TextView fees;
        ImageView image;
        public ViewHolder(final View view)
        {
            super(view);
            name =(TextView)view.findViewById(R.id.institute_name);
            location=(TextView)view.findViewById(R.id.institute_location);
            email=(TextView)view.findViewById(R.id.institute_email);
            fees=(TextView)view.findViewById(R.id.institute_fees);
            image=(ImageView)view.findViewById(R.id.institute_image);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    mContext.replaceWithInstitute(mDataList.get(position));

                }
            });


        }

    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewholderobj, int position) {

        viewholderobj.name.setText(mDataList.get(position).getIName());
        viewholderobj.location.setText(mDataList.get(position).getICity());
        if(!String.valueOf(mDataList.get(position).getIEmailid()).trim().equals("null")) {
            viewholderobj.email.setText(String.valueOf(mDataList.get(position).getIEmailid()));
        }
        viewholderobj.fees.setText(String.valueOf(mDataList.get(position).getIFees()));
        Picasso.with(mContext).load(mDataList.get(position).getIImage()).error(R.mipmap.ic_launcher).into(viewholderobj.image);

    }

   public  void dataSetChanged(ArrayList<DataPojoClass> mDataList)
    {
this.mDataList=mDataList;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

}
