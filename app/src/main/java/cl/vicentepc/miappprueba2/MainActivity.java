package cl.vicentepc.miappprueba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cl.vicentepc.miappprueba2.models.Client;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextAboutMyAnnoyance;
    private EditText editTextHomeTreatment;
    private Button completeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextAboutMyAnnoyance = findViewById(R.id.editTextAboutMyAnnoyance);
        editTextHomeTreatment = findViewById(R.id.editTextHomeTreatment);

        completeBtn = findViewById(R.id.completeBtn);

        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                int age = Integer.parseInt(editTextAge.getText().toString());
                String myAnnoyance = editTextAboutMyAnnoyance.getText().toString();
                String homeTreatment = editTextHomeTreatment.getText().toString();
                if (editTextName.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "CAMPO NOMBRE ESTÁ VACÍO(*)", Toast.LENGTH_LONG).show();
                } else if (editTextAge.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "CAMPO EDAD ESTÁ VACÍO(*)", Toast.LENGTH_LONG).show();
                } else if (editTextAboutMyAnnoyance.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "CAMPO MALESTAR ESTÁ VACÍO(*)", Toast.LENGTH_LONG).show();
                } else if (editTextHomeTreatment.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "CAMPO TRATAMIENTO ESTÁ VACÍO(*)", Toast.LENGTH_LONG).show();
                } else {
                    Client client = new Client(name, age, myAnnoyance, homeTreatment);
                    client.save();
                    Toast.makeText(MainActivity.this,"Tratamiento guardado", Toast.LENGTH_SHORT).show();
                }
                List<Client> clientList = Client.find(Client.class, "");
                for(Client client : clientList){
                    Log.d("NOMBRES", client.getName());
                }
                Toast.makeText(MainActivity.this, "Formulario completado", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ResultDataActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                intent.putExtra("myAnnoyance", myAnnoyance);
                intent.putExtra("homeTreatment", homeTreatment);
                startActivity(intent);
            }
        });
        /*Añadir un dato
        Favorite favoriteList2 = new Favorite("www.google.cl", true);
        favoriteList2.save();*/
    }
}
