package cl.vicentepc.miappprueba2.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.vicentepc.miappprueba2.UserClickListener;
import cl.vicentepc.miappprueba2.R;
import cl.vicentepc.miappprueba2.data.Queries;
import cl.vicentepc.miappprueba2.models.Client;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    private UserClickListener listener;

    private List<Client> clients = new Queries().clients();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_client, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public UsersAdapter(UserClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Client client = clients.get(position);
        holder.recyclerName.setText(client.getName());
        holder.recyclerAge.setText(String.valueOf(client.getAge()));
        holder.recyclerMyAnnoyance.setText(client.getAboutMyAnnoyance());
        holder.recyclerHomeTreatment.setText(client.getHomeTreatment());
    }

    public void add(Client client){
        clients.add(client);
        notifyDataSetChanged();
    }

    public void update(Client client) {
        clients.add(client);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return clients.size();
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
