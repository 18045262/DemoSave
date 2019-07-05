package sg.edu.rp.c346.demosave;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onPause() {
        super.onPause();
        // step 1a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 1b: Obtain an instance of the SharedPreference Editor for update late
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1c: Add the key- value pair
        prefEdit.putString("greeting","Hello");

        //Step 1d: Call commit() to save the change into SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // String msg = "No greetings!";

        // Step 2a: Obtain an instance of the sharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 2b: Retrieve the saved data with the key "Greeting" from the SharePreference object
        String msg = prefs.getString("greeting","No greeting");

        Toast toast = Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
