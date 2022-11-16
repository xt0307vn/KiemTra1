package com.example.kiemtra;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class CongAnAdapter extends RecyclerView.Adapter<CongAnAdapter.CongAnViewHolder> {

    List<CongAn> list;
    Context context;

    public CongAnAdapter(List<CongAn> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CongAnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_congan, parent, false);

        return new CongAnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CongAnViewHolder holder, int position) {
        CongAn congAn = list.get(position);
        if(congAn == null) {
            return;
        }
        holder.ten.setText(congAn.getTen());
        holder.noicongtac.setText(congAn.getNoicongtac());
        holder.sosao.setText(congAn.getSosao()+ "");
        holder.quocgia.setText(congAn.getQuocgia());
        holder.capbac.setText(congAn.getCapbac());

    }

    @Override
    public int getItemCount() {
        if(list != null) {
            return list.size();
        }
        return 0;
    }

    public class CongAnViewHolder extends RecyclerView.ViewHolder {
        TextView ten, capbac, quocgia, sosao, noicongtac;
        ImageView anh;


        public CongAnViewHolder(@NonNull View itemView) {
            super(itemView);

            ten = itemView.findViewById(R.id.ten);
            capbac = itemView.findViewById(R.id.capbac);
            quocgia = itemView.findViewById(R.id.quocgia);
            sosao = itemView.findViewById(R.id.sosao);
            noicongtac = itemView.findViewById(R.id.noicongtac);
            anh = itemView.findViewById(R.id.anh);

        }
    }
}
