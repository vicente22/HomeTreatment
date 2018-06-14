package cl.vicentepc.miappprueba2.views;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cl.vicentepc.miappprueba2.R;
import cl.vicentepc.miappprueba2.UserClickListener;
import cl.vicentepc.miappprueba2.adapters.UsersAdapter;
import cl.vicentepc.miappprueba2.details.DetailsTreatement;
import cl.vicentepc.miappprueba2.models.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisteredFragment extends Fragment implements UserClickListener {

    private RecyclerView recyclerViewResult;

    private TextView textViewHomeTreatmentList;

    private Button showAllBtn;

    private Button hideAllBtn;

    private UsersAdapter adapter;

    public static final String USER_ID = "cl.vicentepc.miappprueba2.views.main.KEY.USER_ID";

    private boolean hideShow;

    public RegisteredFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registered, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showAllBtn = view.findViewById(R.id.showAllBtn);

        hideAllBtn = view.findViewById(R.id.hideAllBtn);

        recyclerViewResult = view.findViewById(R.id.recyclerViewResult);
        recyclerViewResult.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewResult.setLayoutManager(layoutManager);

        adapter = new UsersAdapter(this);
        recyclerViewResult.setAdapter(adapter);

        hideShow = true;

        if (hideShow == true) {

            showAllBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    hideShow = false;
                    recyclerViewResult.setVisibility(View.VISIBLE);
                    showAllBtn.setVisibility(View.INVISIBLE);
                    hideAllBtn.setVisibility(View.VISIBLE);

                }
            });

        } else if (hideShow == false) {

            hideShow = true;
            hideAllBtn.setVisibility(View.INVISIBLE);
            showAllBtn.setVisibility(View.VISIBLE);

        }
        hideAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hideShow = true;
                recyclerViewResult.setVisibility(View.INVISIBLE);
                hideAllBtn.setVisibility(View.INVISIBLE);
                showAllBtn.setVisibility(View.VISIBLE);

            }
        });

    }

    public void updateList(User user) {
        adapter.update(user);
        Log.e("USER", user.getName());
    }

    @Override
    public void clickedID(long id) {

        //Toast.makeText(getContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(getActivity(), DetailsTreatement.class);
        myIntent.putExtra(USER_ID, id);
        startActivity(myIntent);

    }

}
