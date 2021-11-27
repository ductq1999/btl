package com.ptit.btl.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ptit.btl.R;
import com.ptit.btl.model.Laptop;

import java.util.List;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.MyViewHolder>{

    private List<Laptop> laptopList;

    public interface OnItemClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }
    private OnItemClickListener onItemClickListener;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false));
    }

    public void setLaptopList(List<Laptop> laptopList) {
        this.laptopList = laptopList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopAdapter.MyViewHolder holder, int position) {
        Laptop laptop = laptopList.get(position);
        holder.ten_laptop.setText(laptop.getTen());
        holder.chip_laptop.setText(laptop.getChip());
        holder.gia_tri_laptop.setText(String.valueOf(laptop.getGiaTri()));
        holder.kich_thuoc_laptop.setText(String.valueOf(laptop.getKichThuoc()));
        holder.loai_laptop.setText(laptop.getLoai());
        holder.man_hinh_laptop.setText(laptop.getManHinh());
        holder.ram_laptop.setText(laptop.getRam());
    }

    @Override
    public int getItemCount() {
        if(laptopList == null) return 0;
        return laptopList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnLongClickListener {
        TextView ten_laptop, loai_laptop, gia_tri_laptop, kich_thuoc_laptop, man_hinh_laptop, chip_laptop, ram_laptop;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ten_laptop = itemView.findViewById(R.id.ten_laptop);
            loai_laptop = itemView.findViewById(R.id.loai_laptop);
            gia_tri_laptop = itemView.findViewById(R.id.gia_tri_laptop);
            kich_thuoc_laptop = itemView.findViewById(R.id.kich_thuoc_laptop);
            man_hinh_laptop = itemView.findViewById(R.id.man_hinh_laptop);
            chip_laptop = itemView.findViewById(R.id.chip_laptop);
            ram_laptop = itemView.findViewById(R.id.ram_laptop);
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
