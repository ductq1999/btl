package com.ptit.btl.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ptit.btl.R;
import com.ptit.btl.model.Hang;

import java.util.List;

public class HangAdapter extends RecyclerView.Adapter<HangAdapter.MyViewHolder> {

    private List<Hang> hangList;

    public interface OnItemClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }

    private OnItemClickListener onItemClickListener;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_hang, parent, false));
    }

    public void setHangList(List<Hang> hangList) {
        this.hangList = hangList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull HangAdapter.MyViewHolder holder, int position) {
        Hang hang = hangList.get(position);
        holder.ten_hang.setText(hang.getTen());
        holder.danh_gia_hang.setText(hang.getDanhGia());
    }

    @Override
    public int getItemCount() {
        if (hangList == null) return 0;
        return hangList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnLongClickListener {
        TextView ten_hang, danh_gia_hang;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ten_hang = itemView.findViewById(R.id.ten_hang);
            danh_gia_hang = itemView.findViewById(R.id.danh_gia_hang);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onClick(v, getAdapterPosition(), false);

        }

        @Override
        public boolean onLongClick(View v) {
            onItemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
}