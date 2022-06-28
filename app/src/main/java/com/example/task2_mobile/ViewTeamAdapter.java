package com.example.task2_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task2_mobile.data.remote.NbaTeamItemResponseItem;
import com.example.task2_mobile.databinding.ItemNbaTeamBinding;

import java.util.List;

public class ViewTeamAdapter extends RecyclerView.Adapter<ViewTeamAdapter.ViewHolder> {

    private final List<NbaTeamItemResponseItem> nbaTeamItems;

    public ViewTeamAdapter(List<NbaTeamItemResponseItem> eachItems){
        this.nbaTeamItems = eachItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNbaTeamBinding binding = ItemNbaTeamBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(nbaTeamItems.get(position));
    }

    @Override
    public int getItemCount() {
        return nbaTeamItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ItemNbaTeamBinding binding;

        public ViewHolder(@NonNull ItemNbaTeamBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(NbaTeamItemResponseItem nbaTeamItem){
            binding.tvName.setText(nbaTeamItem.getName());
            Glide.with(binding.getRoot())
                    .load(nbaTeamItem.getLogo())
                    .into(binding.ivLogo);
        }
    }
}
