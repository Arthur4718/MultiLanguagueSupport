package devarthur4718.com.multilanguagesupport;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);


        showMyDialog();
    }

    private void showMyDialog() {


        final String[] listItems = {"English", "Português","Espanõl"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SampleActivity.this);
        mBuilder.setTitle("Choose Language...");

        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(which == 0){

                    setLocale("en");
                    recreate();
                }else if(which == 1){

                    setLocale("pt-br");
                    recreate();

                }else if(which == 2){
                    setLocale("es");
                    recreate();
                }


                //dismiss alert
                dialog.dismiss();


            }
        });




    }

    private void setLocale(String lang) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();

        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics() );

        //Sade data to

    }
}
