package cl.vicentepc.miappprueba2.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import cl.vicentepc.miappprueba2.R;
import cl.vicentepc.miappprueba2.adapters.UsersAdapter;
import cl.vicentepc.miappprueba2.data.Queries;
import cl.vicentepc.miappprueba2.models.User;
import cl.vicentepc.miappprueba2.views.register.RegisteredFragment;

public class DetailsTreatement extends AppCompatActivity{

    private UsersAdapter usersAdapter;

    private long user_id;

    private String nameText;
    private String ageText;
    private String myAnnoyanceText;
    private String homeTreatmentText;

    private User user;

    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextMyAnnoyance;
    private EditText editTextHomeTreatment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_treatement);

        user_id = getIntent().getLongExtra(RegisteredFragment.USER_ID, 0);

        user = new Queries().byId(user_id);

        Log.d("LONG", user.getName());
        Log.d("LONG", String.valueOf(user.getAge()));
        Log.d("LONG", user.getAboutMyAnnoyance());
        Log.d("LONG", user.getHomeTreatment());


        getSupportActionBar().setTitle(user.getName());

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextMyAnnoyance = findViewById(R.id.editTextAboutMyAnnoyance);
        editTextHomeTreatment = findViewById(R.id.editTextHomeTreatment);

    }

    @Override
    protected void onResume() {
        super.onResume();

        nameText = user.getName();
        ageText = String.valueOf(user.getAge());
        myAnnoyanceText = user.getAboutMyAnnoyance();
        homeTreatmentText = user.getHomeTreatment();


        if(nameText != null) {

            editTextName.setText(nameText);
            editTextAge.setText(ageText);
            editTextMyAnnoyance.setText(myAnnoyanceText);
            editTextHomeTreatment.setText(homeTreatmentText);

        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        nameText = editTextName.getText().toString();
        ageText = editTextAge.getText().toString();
        myAnnoyanceText = editTextMyAnnoyance.getText().toString();
        homeTreatmentText = editTextHomeTreatment.getText().toString();

        user.setName(nameText);
        user.setAge(Integer.parseInt(ageText));
        user.setAboutMyAnnoyance(myAnnoyanceText);
        user.setHomeTreatment(homeTreatmentText);

        user.save();

        Toast.makeText(DetailsTreatement.this, "TRATAMIENTO EDITADO CON EXITO", Toast.LENGTH_LONG).show();

    }

}
