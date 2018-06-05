package cl.vicentepc.miappprueba2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.vicentepc.miappprueba2.models.Client;

public class ResultDataActivity extends AppCompatActivity {

    private TextView textViewResultName;
    private TextView textViewResultAge;
    private TextView textViewAboutMyAnnoyance;
    private TextView textViewHomeTreatment;

    private TextView listNames;
    private TextView listAges;
    private TextView listMyAnnoyances;
    private TextView listMyHomeTreatments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_data);

        textViewResultName = findViewById(R.id.textViewResultName);
        textViewResultAge = findViewById(R.id.textViewResultAge);
        textViewAboutMyAnnoyance = findViewById(R.id.textViewResultMyAnnoyance);
        textViewHomeTreatment = findViewById(R.id.textViewHomeTreatment);

        listNames = findViewById(R.id.listNames);
        listAges = findViewById(R.id.listAges);
        listMyAnnoyances = findViewById(R.id.listMyAnnoyances);
        listMyHomeTreatments = findViewById(R.id.listMyHomeTreatments);

        String resultName = getIntent().getStringExtra("name");
        int resultAge = getIntent().getIntExtra("age", 0);
        String resultAboutMyAnnoyance = getIntent().getStringExtra("myAnnoyance");
        String resultHomeTreatment = getIntent().getStringExtra("homeTreatment");

        textViewResultName.setText(resultName);
        textViewResultAge.setText(String.valueOf(resultAge));
        textViewAboutMyAnnoyance.setText(resultAboutMyAnnoyance);
        textViewHomeTreatment.setText(resultHomeTreatment);

        List<Client> clientList = Client.find(Client.class, "name='"+resultName.toString()+"'" );
        for(Client client : clientList){
            listNames.setText(client.getName().toString() + ", ");
            listAges.setText(String.valueOf(client.getAge()));
            listMyAnnoyances.setText(client.getAboutMyAnnoyance().toString());
            listMyHomeTreatments.setText(client.getHomeTreatment().toString());
        }
    }
}
