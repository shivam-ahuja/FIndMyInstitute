package ahuja.shivam.findmyinstitute;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import ahuja.shivam.findmyinstitute.R;

import java.util.ArrayList;


/**
  A simple {@link Fragment} subclass.
 */
public class List_Of_Courses_Fragment extends Fragment {


    private ListView mCourseListView;

    public List_Of_Courses_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Base_Activity mContext=(Base_Activity)getActivity();
        mContext.toolbar.setTitle("Courses Offered");
        View view= inflater.inflate(R.layout.fragment_list__of__courses_, container, false);
        mCourseListView=(ListView) view.findViewById(R.id.course_listview);
        Bundle bundle=getArguments();
        ArrayList<CoursePOJOClass> coursePOJOClasses=new ArrayList<CoursePOJOClass>();

        if(bundle.getString("COURSE1NAME")!=null)
        {CoursePOJOClass coursePOJOClass=new CoursePOJOClass();
         coursePOJOClass.setCourse(bundle.getString("COURSE1NAME"));
            coursePOJOClass.setCourseDetail(bundle.getString("COURSE1DETAIL"));
            coursePOJOClasses.add(coursePOJOClass);
        }
        if(bundle.getString("COURSE2NAME")!=null)
        {CoursePOJOClass coursePOJOClass=new CoursePOJOClass();
            coursePOJOClass.setCourse(bundle.getString("COURSE2NAME"));
            coursePOJOClass.setCourseDetail(bundle.getString("COURSE2DETAIL"));
            coursePOJOClasses.add(coursePOJOClass);
        }
        if(bundle.getString("COURSE3NAME")!=null)
        {CoursePOJOClass coursePOJOClass=new CoursePOJOClass();
            coursePOJOClass.setCourse(bundle.getString("COURSE3NAME"));
            coursePOJOClass.setCourseDetail(bundle.getString("COURSE3DETAIL"));
            coursePOJOClasses.add(coursePOJOClass);
        }
       // mCourseListView.setEmptyView();
        CoursesAdapter coursesAdapter=new CoursesAdapter(coursePOJOClasses,getActivity());
        mCourseListView.setAdapter(coursesAdapter);

        return view;

    }

}
