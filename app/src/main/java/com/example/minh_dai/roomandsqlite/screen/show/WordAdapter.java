package com.example.minh_dai.roomandsqlite.screen.show;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minh_dai.roomandsqlite.R;
import com.example.minh_dai.roomandsqlite.data.model.Word;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHodel> {

    private List<Word> mList;
    private Context mContext;

    public WordAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        Word word = mList.get(position);
        holder.mTextId.setText(String.valueOf(word.getId()));
        holder.mTextWord.setText(String.valueOf(word.getWord()));
    }

    public void setList(List<Word> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {

        private TextView mTextWord;
        private TextView mTextId;

        public ViewHodel(@NonNull View itemView) {
            super(itemView);
            mTextWord = itemView.findViewById(R.id.txtName);
            mTextId = itemView.findViewById(R.id.txtId);
        }
    }
}
