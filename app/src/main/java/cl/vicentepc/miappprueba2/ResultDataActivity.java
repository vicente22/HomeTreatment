package cl.vicentepc.miappprueba2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.vicentepc.miappprueba2.models.Client;

public class ResultDataActivity extends AppCompatActivity {

    private TextView textViewResultName;
    private TextView textViewResultAge;
    private TextView textViewAboutMyAnnoyance;
    private TextView textViewHomeTreatment;

    private Button showAllBtn;

    private ListView listViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_data);

        textViewResultName = findViewById(R.id.textViewResultName);
        textViewResultAge = findViewById(R.id.textViewResultAge);
        textViewAboutMyAnnoyance = findViewById(R.id.textViewResultMyAnnoyance);
        textViewHomeTreatment = findViewById(R.id.textViewHomeTreatment);

        showAllBtn = findViewById(R.id.showAllBtn);

        listViewResult = findViewById(R.id.listViewResult);

        String resultName = getIntent().getStringExtra("name");
        int resultAge = getIntent().getIntExtra("age", 0);
        String resultAboutMyAnnoyance = getIntent().getStringExtra("myAnnoyance");
        String resultHomeTreatment = getIntent().getStringExtra("homeTreatment");

        textViewResultName.setText(resultName);
        textViewResultAge.setText(String.valueOf(resultAge));
        textViewAboutMyAnnoyance.setText(resultAboutMyAnnoyance);
        textViewHomeTreatment.setText(resultHomeTreatment);

        showAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewResult.setVisibility(View.VISIBLE);
                chargeMyListview();
            }
        });

    }

    public void chargeMyListview(){
        List<Client> clientList = Client.listAll(Client.class);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < clientList.size(); i++) {
            Client result = clientList.get(i);
            Log.d("DATOS", "Nombre: " + result.getName() + ", Edad: " + String.valueOf(result.getAge()) + ", Malestar: " + result.getAboutMyAnnoyance() + ", Tratamiento: " + result.getHomeTreatment());
            list.add("Nombre: " + result.getName() + ", Edad: " + String.valueOf(result.getAge()) + ", Malestar: " + result.getAboutMyAnnoyance() + ", Tratamiento: " + result.getHomeTreatment());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listViewResult.setAdapter(adapter);
    }

}
