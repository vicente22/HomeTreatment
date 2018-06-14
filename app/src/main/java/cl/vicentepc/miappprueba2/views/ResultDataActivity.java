package cl.vicentepc.miappprueba2.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import cl.vicentepc.miappprueba2.R;

public class ResultDataActivity extends AppCompatActivity {

    private TextView textViewResultName;
    private TextView textViewResultAge;
    private TextView textViewAboutMyAnnoyance;
    private TextView textViewHomeTreatment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textViewResultName = findViewById(R.id.textViewResultName);
        textViewResultAge = findViewById(R.id.textViewResultAge);
        textViewAboutMyAnnoyance = findViewById(R.id.textViewResultMyAnnoyance);
        textViewHomeTreatment = findViewById(R.id.textViewHomeTreatment);

        String resultName = getIntent().getStringExtra("name");
        int resultAge = getIntent().getIntExtra("age", 0);
        String resultAboutMyAnnoyance = getIntent().getStringExtra("myAnnoyance");
        String resultHomeTreatment = getIntent().getStringExtra("homeTreatment");

        textViewResultName.setText(resultName);
        textViewResultAge.setText(String.valueOf(resultAge));
        textViewAboutMyAnnoyance.setText(resultAboutMyAnnoyance);
        textViewHomeTreatment.setText(resultHomeTreatment);

    }

}
