package ahuja.shivam.findmyinstitute;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import ahuja.shivam.findmyinstitute.R;

import static ahuja.shivam.findmyinstitute.R.styleable.AppCompatTheme_dialogTheme;

//contains nav bar
public class Base_Activity extends AppCompatActivity
        implements android.support.design.widget.NavigationView.OnNavigationItemSelectedListener {
    private FragmentManager mFragManager;
    private FragmentTransaction mFragTransaction;
    private Details_Fragment mDetailsFragment;
    private List_Of_Courses_Fragment mListOfCoursesFragment;
    private Contact_Us_Fragment mContactUsFragment;
    private Faq_Fragment mFaqFragment;
    android.support.v7.widget.Toolbar toolbar;

    private BlankFragment mInstituteListFragment;
    private DataPojoClass minstituteData;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_base_activity);

        //fragments work
        mFragManager=getFragmentManager();
        mInstituteListFragment= new BlankFragment();
        mFragTransaction=mFragManager.beginTransaction();
        mFragTransaction.add(R.id.content_base,mInstituteListFragment);
        mFragTransaction.commit();


        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

      if (id== R.id.home) {
          mFragManager.popBackStack("Institute", FragmentManager.POP_BACK_STACK_INCLUSIVE);

      }
       else if (id == R.id.about_us) {
          AlertDialog.Builder adb=new AlertDialog.Builder(this);
          adb.setMessage(getResources().getString(R.string.about_us));
          adb.setNeutralButton("Nice!", null);
          AlertDialog ad=adb.create();
          ad.show();

        } else if (id == R.id.nav_share) {
          Intent intent=new Intent(Intent.ACTION_SEND);
          intent.putExtra(Intent.EXTRA_TEXT,"www.app_link.com");
          intent.setType("text/plain");
          startActivity(intent);


        } else if (id == R.id.nav_rateus) {
          AlertDialog.Builder adb=new AlertDialog.Builder(this,AppCompatTheme_dialogTheme);
          final View view=getLayoutInflater().inflate(R.layout.ratingbarlayout,null);

          adb.setView(view);
          final AlertDialog alertDialog=adb.create();
          alertDialog.show();
          final RatingBar rtbar=(RatingBar)view.findViewById(R.id.rating_bar);

          view.findViewById(R.id.rating_bar_submit_btn).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  float rating =rtbar.getRating();
              Toast.makeText(Base_Activity.this, String.valueOf(rating)+" successfully submitted", Toast.LENGTH_LONG).show();
                  alertDialog.dismiss();
              }
          });
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    void replaceWithInstitute(DataPojoClass institutedata)
    { this.minstituteData=institutedata;
        mFragTransaction=mFragManager.beginTransaction();
        if(mDetailsFragment==null) {
            mDetailsFragment = new Details_Fragment();
        }
        Bundle bundle=new Bundle();
        bundle.putString("INSTITUTEIMAGE",institutedata.getIImage());
        bundle.putString("INSTITUTENAME",institutedata.getIName());
        bundle.putString("INSTITUTEDETAILS",institutedata.getIDetails());
        mDetailsFragment.setArguments(bundle);
        Toast.makeText(Base_Activity.this, String.valueOf(position), Toast.LENGTH_LONG).show();
        mFragTransaction.replace(R.id.content_base,mDetailsFragment);  //dilip fragment to be added here
        mFragTransaction.addToBackStack("Institute");
        mFragTransaction.commit();
    }

    public void coursesOffered() {
        mFragTransaction=mFragManager.beginTransaction();
        if(mListOfCoursesFragment==null) {
            mListOfCoursesFragment = new List_Of_Courses_Fragment();
        }
        Bundle bundle=new Bundle();
        bundle.putString("COURSE1NAME",minstituteData.getICourse1());
        bundle.putString("COURSE1DETAIL",minstituteData.getICourse1Detail());
        bundle.putString("COURSE2NAME",minstituteData.getICourse2());
        bundle.putString("COURSE2DETAIL",minstituteData.getICouse2Detail());
        bundle.putString("COURSE3NAME",minstituteData.getICourse3());
        bundle.putString("COURSE3DETAIL",minstituteData.getICouse3Detail());
        mListOfCoursesFragment.setArguments(bundle);
        Toast.makeText(Base_Activity.this, String.valueOf(position), Toast.LENGTH_LONG).show();
        mFragTransaction.replace(R.id.content_base,mListOfCoursesFragment);  //List of courses fragment
        mFragTransaction.addToBackStack(null);
        mFragTransaction.commit();
    }

    public void contactUs() {
        mFragTransaction=mFragManager.beginTransaction();
        if(mContactUsFragment==null) {
            mContactUsFragment = new Contact_Us_Fragment();
        }
        Bundle bundle=new Bundle();
        bundle.putString("EMAIL",minstituteData.getIEmailid());
        bundle.putString("CONTACT_NO",minstituteData.getIPhoneno());
        bundle.putString("ADDRESS",minstituteData.getIAddress());
        mContactUsFragment.setArguments(bundle);
        Toast.makeText(Base_Activity.this, String.valueOf(position), Toast.LENGTH_LONG).show();
        mFragTransaction.replace(R.id.content_base,mContactUsFragment);  //dilip fragment to be added here
        mFragTransaction.addToBackStack(null);
        mFragTransaction.commit();
    }

    public void faq() {
        mFragTransaction=mFragManager.beginTransaction();
        if(mFaqFragment==null) {
            mFaqFragment = new Faq_Fragment();
        }
        Bundle bundle=new Bundle();
        bundle.putInt("POSITION",position);
        mFaqFragment.setArguments(bundle);
        Toast.makeText(Base_Activity.this, String.valueOf(position), Toast.LENGTH_LONG).show();
        mFragTransaction.replace(R.id.content_base,mFaqFragment);  //dilip fragment to be added here
        mFragTransaction.addToBackStack(null);
        mFragTransaction.commit();
    }

}
