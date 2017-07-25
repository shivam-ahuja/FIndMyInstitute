package ahuja.shivam.findmyinstitute;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ahuja.shivam.findmyinstitute.R;

public class Introduction_Activity extends Activity {
        // Splash screen timer
        private static int SPLASH_TIME_OUT = 3000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_introduction_);

            new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    Intent i = new Intent(Introduction_Activity.this, Base_Activity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }

    }
