package ahuja.shivam.findmyinstitute;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ahuja.shivam.findmyinstitute.R;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class Details_Fragment extends Fragment {


    //
    private TextView mCoursesOfferedTv;
    private TextView mContactUsTv;



    //new
    private android.support.v7.widget.Toolbar mInstituteName;
    private ImageView mInstituteImage;
    private TextView mInstituteDetail;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Base_Activity baseActivity;


    public Details_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        baseActivity=(Base_Activity)getActivity();
        baseActivity.getSupportActionBar().setTitle("Institute");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details_, container, false);
        mCoursesOfferedTv=(TextView)view.findViewById(R.id.courses_offered_tv);
       mContactUsTv=(TextView)view.findViewById(R.id.contact_us_tv);

        mInstituteImage = (ImageView) view.findViewById(R.id.institute_iv);
        mInstituteDetail = (TextView) view.findViewById(R.id.institute_detail_tv);
        //((Base_Activity) getActivity()).setSupportActionBar(mInstituteName);
        /*android.app.ActionBar actionBar = getActivity().getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);*/
        collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);

        Bundle bundle = getArguments();
        if (bundle != null) {
            collapsingToolbarLayout.setTitle(bundle.getString("INSTITUTENAME"));
            mInstituteDetail.setText(bundle.getString("INSTITUTEDETAILS"));

            Picasso.with(getActivity()).load(bundle.getString("INSTITUTEIMAGE")).error(R.mipmap.ic_launcher).into(mInstituteImage);
        }


      mCoursesOfferedTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Base_Activity base_activity=(Base_Activity) getActivity();
                base_activity.coursesOffered();
            }
        });

        mContactUsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Base_Activity base_activity = (Base_Activity) getActivity();
                base_activity.contactUs();
            }
        });

        dynamicToolbarcolour();
        toolbarTextAppearence();

        return view;
    }

    private void toolbarTextAppearence() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }

    private void dynamicToolbarcolour() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pikachu);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(getResources().getColor(R.color.secondarycolor)));
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(getResources().getColor(R.color.secondarydark)));


            }
        });


    }


}
