package com.example.projetofinanceiro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projetofinanceiro.modelo.Movimento;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterMovimento extends RecyclerView.Adapter<AdapterMovimento.MyViewHolder> {

    private List<Movimento> listaMovimento;


    public AdapterMovimento(List<Movimento> lista ) {
        this.listaMovimento = lista;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView historico;
        TextView valor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id          = itemView.findViewById( R.id.txt_id );
            historico   = itemView.findViewById( R.id.txt_hist );
            valor       = itemView.findViewById(R.id.txt_val );
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from( parent.getContext() ).inflate( R.layout.lista_movimento, parent, false );
        return new MyViewHolder( itemLista );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Movimento movimento = listaMovimento.get( position );
        holder.id.setText( movimento.getId() );
        holder.historico.setText( movimento.getHistorico() );
        holder.valor.setText( String.valueOf( movimento.getValor() ) );
    }

    @Override
    public int getItemCount() {
        return listaMovimento.size();
    }
}
