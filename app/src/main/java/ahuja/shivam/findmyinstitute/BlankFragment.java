package ahuja.shivam.findmyinstitute;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ahuja.shivam.findmyinstitute.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    private ListView mFragmentListView;
    Base_Activity mContext;
    private ProgressDialog mProgressDialog;
    private Spinner mMySpinner;
    private ArrayList<DataPojoClass> mDataList;
    private FrameLayout mView;
    private FrameLayout mserverProblemView;
    private TextView mEmptyVw;
    private RecyclerView mrecyclerView;
    private LinearLayoutManager layoutManager;
     private RecyclerAdapter adapter;

    public BlankFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //intialising spinner

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Log.d("TAG","in oncreateview");
        mContext=(Base_Activity) getActivity();
        mContext.toolbar.setTitle(R.string.app_name);
        mProgressDialog=new ProgressDialog(mContext);
        mProgressDialog.setMessage("loading....");
        mProgressDialog.show();

        View view=inflater.inflate(R.layout.fragment_blank, container, false);
       // mFragmentListView=(ListView)view.findViewById(R.id.fragmentListView);
        mrecyclerView =
                (RecyclerView) view.findViewById(R.id.fragmentRecyclerview);

        layoutManager = new LinearLayoutManager(getActivity());
        mrecyclerView.setLayoutManager(layoutManager);



        //getAllData();  retrofit
        getInstituteArrayList();

         //spinner
        mMySpinner=(Spinner)view.findViewById(R.id.mySpinner);
       ArrayAdapter adapter= ArrayAdapter.createFromResource(mContext, R.array.city, R.layout.support_simple_spinner_dropdown_item);
        mMySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtvw = (TextView) view;
                if (txtvw != null) {
                    txtvw.setTextColor(getResources().getColor(R.color.white));
                    String string = txtvw.getText().toString();
                    Toast.makeText(mContext, string, Toast.LENGTH_LONG).show();
                }
                if (i==0)
                {
                    mEmptyVw.setVisibility(View.GONE);
                    mProgressDialog.setMessage("Loading....");
                    mProgressDialog.show();
                    getInstituteArrayList();
                }
                else if(i==1)
                { //banglore
                    mEmptyVw.setVisibility(View.GONE);
                    mProgressDialog.setMessage("Loading....");
                    mProgressDialog.show();
                    getBangloreList();
                }
                else if(i==2)
                { //Delhi
                    mEmptyVw.setVisibility(View.GONE);
                    mProgressDialog.setMessage("Loading....");
                    mProgressDialog.show();
                    getDelhiList();


                }
                else if(i==3)
                { //hyderabad
                    mEmptyVw.setVisibility(View.GONE);
                    mProgressDialog.setMessage("Loading....");
                    mProgressDialog.show();
                    getHyderabadInstituteList();

                }
                else if(i==4)
                {//chennai
                    mEmptyVw.setVisibility(View.GONE);
                    mProgressDialog.setMessage("Loading....");
                    mProgressDialog.show();
                    getChennaiInstituteList();
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(mContext, "u can select an item", Toast.LENGTH_LONG).show();
            }
        });
        mMySpinner.setAdapter(adapter);
        return view;
    }

    private void getHyderabadInstituteList() {
        RetrofitApiInterface retrofitApiInterface=RetrofitObjectBuilder.makeRetrofitApiInterfaceObject();
        Call<List<DataPojoClass>> call=retrofitApiInterface.getHyderabadInstituteList();
        call.enqueue(new Callback<List<DataPojoClass>>() {
            @Override
            public void onResponse(Response<List<DataPojoClass>> response, Retrofit retrofit) {
                mDataList=(ArrayList<DataPojoClass>) response.body();
               /* FragmentListViewAdapter fragmentListViewAdapter=new FragmentListViewAdapter(mContext,mDataList);
                mFragmentListView.setAdapter(fragmentListViewAdapter);*/
                if(mDataList!=null)
                {
                    if(mDataList.size()<1) {
                        mEmptyVw.setVisibility(View.VISIBLE);
                    }
                }
                adapter.dataSetChanged(mDataList);
                mProgressDialog.dismiss();

            }

            @Override
            public void onFailure(Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(mContext,"unable to load data from server", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getChennaiInstituteList() {
        RetrofitApiInterface retrofitApiInterface=RetrofitObjectBuilder.makeRetrofitApiInterfaceObject();
        Call<List<DataPojoClass>> call=retrofitApiInterface.getChennaiInstituteList();
        call.enqueue(new Callback<List<DataPojoClass>>() {
            @Override
            public void onResponse(Response<List<DataPojoClass>> response, Retrofit retrofit) {
                mDataList=(ArrayList<DataPojoClass>) response.body();
               /* FragmentListViewAdapter fragmentListViewAdapter=new FragmentListViewAdapter(mContext,mDataList);
                mFragmentListView.setAdapter(fragmentListViewAdapter);*/
                if(mDataList!=null)
                {
                    if(mDataList.size()<1) {
                        mEmptyVw.setVisibility(View.VISIBLE);
                    }
                }
                adapter.dataSetChanged(mDataList);
                mProgressDialog.dismiss();

            }

            @Override
            public void onFailure(Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(mContext,"unable to load data from server", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getDelhiList() {
        RetrofitApiInterface retrofitApiInterface=RetrofitObjectBuilder.makeRetrofitApiInterfaceObject();
        Call<List<DataPojoClass>> call=retrofitApiInterface.getDelhiInstituteList();
        call.enqueue(new Callback<List<DataPojoClass>>() {
            @Override
            public void onResponse(Response<List<DataPojoClass>> response, Retrofit retrofit) {
                mDataList=(ArrayList<DataPojoClass>) response.body();
               /* FragmentListViewAdapter fragmentListViewAdapter=new FragmentListViewAdapter(mContext,mDataList);
                mFragmentListView.setAdapter(fragmentListViewAdapter);*/
                if(mDataList!=null)
                {
                    if(mDataList.size()<1) {
                        mEmptyVw.setVisibility(View.VISIBLE);
                    }
                }
                adapter.dataSetChanged(mDataList);
                mProgressDialog.dismiss();

            }

            @Override
            public void onFailure(Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(mContext,"unable to load data from server", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getBangloreList() {
        RetrofitApiInterface retrofitApiInterface=RetrofitObjectBuilder.makeRetrofitApiInterfaceObject();
        Call<List<DataPojoClass>> call=retrofitApiInterface.getBangloreInstituteList();
        call.enqueue(new Callback<List<DataPojoClass>>() {
            @Override
            public void onResponse(Response<List<DataPojoClass>> response, Retrofit retrofit) {
                mDataList=(ArrayList<DataPojoClass>) response.body();
                if(mDataList!=null)
                {
                    if(mDataList.size()<1) {
                        mEmptyVw.setVisibility(View.VISIBLE);
                    }
                    }

               /* FragmentListViewAdapter fragmentListViewAdapter=new FragmentListViewAdapter(mContext,mDataList);
                mFragmentListView.setAdapter(fragmentListViewAdapter);*/
                adapter.dataSetChanged(mDataList);
                mProgressDialog.dismiss();

            }

            @Override
            public void onFailure(Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(mContext,"unable to load data from server", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mEmptyVw=(TextView)mContext.findViewById(R.id.emptyview);
       // mFragmentListView.setEmptyView(mEmptyVw);
        mMySpinner.setVisibility(View.INVISIBLE);
    }

    private void getInstituteArrayList() {
        RetrofitApiInterface retrofitApiInterface=RetrofitObjectBuilder.makeRetrofitApiInterfaceObject();
        Call<List<DataPojoClass>> call=retrofitApiInterface.getinstituteList();
        call.enqueue(new Callback<List<DataPojoClass>>() {
            @Override
            public void onResponse(Response<List<DataPojoClass>> response, Retrofit retrofit) {
                mDataList=(ArrayList<DataPojoClass>) response.body();
               /* FragmentListViewAdapter fragmentListViewAdapter=new FragmentListViewAdapter(mContext,mDataList);
                mFragmentListView.setAdapter(fragmentListViewAdapter);*/
                adapter = new RecyclerAdapter(mContext,mDataList);
                mrecyclerView.setAdapter(adapter);
                mMySpinner.setVisibility(View.VISIBLE);

                mProgressDialog.dismiss();

            }

            @Override
            public void onFailure(Throwable t) {
             mProgressDialog.dismiss();
                Toast.makeText(mContext,"unable to load data from server", Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public void onResume() {
        super.onResume();


        /*mFragmentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                mContext.replaceWithInstitute(mDataList.get(i));

            }
        });*/

    }
}
