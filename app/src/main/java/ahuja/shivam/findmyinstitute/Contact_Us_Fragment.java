package ahuja.shivam.findmyinstitute;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ahuja.shivam.findmyinstitute.R;


public class Contact_Us_Fragment extends Fragment implements View.OnClickListener {


    private TextView mPhoneTv;
    private TextView mEmailTv;
    private TextView mLocationTv;

    public Contact_Us_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Base_Activity mContext=(Base_Activity)getActivity();
        mContext.toolbar.setTitle("Contact Institute");
        View view= inflater.inflate(R.layout.fragment_contact__us_, container, false);
    Bundle bundle=getArguments();
        mPhoneTv=(TextView) view.findViewById(R.id.phone_tv);
        mEmailTv=(TextView)view.findViewById(R.id.email_tv);
        mLocationTv=(TextView)view.findViewById(R.id.location_tv);
        mPhoneTv.setText(bundle.getString("CONTACT_NO"));
        mEmailTv.setText(bundle.getString("EMAIL"));
        mLocationTv.setText(bundle.getString("ADDRESS"));
        mPhoneTv.setOnClickListener(this);
        mEmailTv.setOnClickListener(this);
        mLocationTv.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
       switch (v.getId())
        {
            case R.id.email_tv:
                Intent i =new Intent(Intent.ACTION_SEND);
                String to[]={mEmailTv.getText().toString()};
                i.putExtra(Intent.EXTRA_EMAIL,to);
                i.putExtra(Intent.EXTRA_TEXT,"query from findmyinstitute student");
                i.setData(Uri.parse("mailto:"));
                i.setType("message/*");
                startActivity(i);
                break;

                    }
                }

        }

