package com.example.mahasiswapc.database.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mahasiswapc.database.Edit_data;
import com.example.mahasiswapc.database.R;
import com.example.mahasiswapc.database.entity.sekolah;
import com.example.mahasiswapc.database.ui.main.MainContact;

import java.util.List;

public class Adapter extends  RecyclerView.Adapter<Adapter.ViewHolder>{
    Context context;
    List<sekolah> list;
    MainContact.hapus view;
    public Adapter(Context context, List<sekolah> list, MainContact.hapus view) {
        this.view = view;
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_user, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final sekolah data = list.get(i);
        viewHolder.TV_1.setText(data.getName());
        viewHolder.TV_2.setText(data.getAddress());
        viewHolder.TV_3.setText(data.getSiswa());
        viewHolder.TV_4.setText(data.getGuru());
        viewHolder.btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.deleteData(data);
            }
        });
        viewHolder.btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(context, Edit_data.class);
                x.putExtra("nama", data.getName());
                x.putExtra("alamat", data.getAddress());
                x.putExtra("siswa", data.getSiswa());
                x.putExtra("guru", data.getGuru());
                x.putExtra("id", data.getId());
                x.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(x);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TV_1, TV_2, TV_3, TV_4;
        Button btn_1, btn_2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TV_1 = itemView.findViewById(R.id.tv_item_nama);
            TV_2 = itemView.findViewById(R.id.tv_item_alamat);
            TV_3 = itemView.findViewById(R.id.tv_item_jml_siswa);
            TV_4 = itemView.findViewById(R.id.tv_item_jml_guru);
            btn_1 = itemView.findViewById(R.id.btn_hapus);
            btn_2 = itemView.findViewById(R.id.btn_edit);
        }
    }
}
