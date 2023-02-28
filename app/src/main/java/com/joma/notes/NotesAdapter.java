package com.joma.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
private List<NoteModel> list = new ArrayList<>();
public void setList(List<NoteModel> list){
    list.clear();
    list.addAll(list);
    notifyDataSetChanged();
}

public void addItem(NoteModel title){
    list.clear();
    list.add(title);
    notifyItemInserted(list.size());
}

public void deleteItem(int pos){
    list.remove(pos);
 notifyItemRemoved(pos);
}



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView desc;

        ImageView delete;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            desc = itemView.findViewById(R.id.item_desc);
            delete = itemView.findViewById(R.id.item_delete);


        }
        public void bind(int pos){
            title.setText(list.get(pos).getTitle());
            desc.setText(list.get(pos).getDesc());
            delete.setOnClickListener(view -> {
list.remove(pos);
notifyItemRemoved(pos);
            });
        }
    }

}
