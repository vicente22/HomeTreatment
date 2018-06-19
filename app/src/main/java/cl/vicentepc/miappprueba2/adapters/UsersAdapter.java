package cl.vicentepc.miappprueba2.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.vicentepc.miappprueba2.UserClickListener;
import cl.vicentepc.miappprueba2.R;
import cl.vicentepc.miappprueba2.data.Queries;
import cl.vicentepc.miappprueba2.models.User;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    private List<User> users = new ArrayList<>();

    private UserClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public UsersAdapter(UserClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        User user = users.get(position);
        holder.recyclerName.setText(user.getName());
        holder.recyclerAge.setText(String.valueOf(user.getAge()));
        holder.recyclerMyAnnoyance.setText(user.getAboutMyAnnoyance());
        holder.recyclerHomeTreatment.setText(user.getHomeTreatment());

        holder.recyclerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User auxUser = users.get(holder.getAdapterPosition());
                listener.clickedID(auxUser.getId());

            }
        });

    }

    public void update() {
        users.clear();
        this.users.addAll(new Queries().users());
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView recyclerName;
        private TextView recyclerAge;
        private TextView recyclerMyAnnoyance;
        private TextView recyclerHomeTreatment;

        public ViewHolder(View itemView) {
            super(itemView);

            recyclerName = itemView.findViewById(R.id.recyclerName);
            recyclerAge = itemView.findViewById(R.id.recyclerAge);
            recyclerMyAnnoyance = itemView.findViewById(R.id.recyclerMyAnnoyance);
            recyclerHomeTreatment = itemView.findViewById(R.id.recyclerHomeTreatment);

        }
    }
}
