package ahuja.shivam.findmyinstitute;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ahuja.shivam.findmyinstitute.R;


/**
  A simple {@link Fragment} subclass.
 */
public class Faq_Fragment extends Fragment {


    public Faq_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Base_Activity mContext=(Base_Activity)getActivity();
        mContext.toolbar.setTitle("FAQs");
        return inflater.inflate(R.layout.fragment_faq_, container, false);
    }

}
