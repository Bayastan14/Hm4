package com.joma.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    NotesAdapter adapter;
Button sort;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView =view.findViewById(R.id.recycler);
        adapter = new NotesAdapter();
        recyclerView.setAdapter(adapter);
        sort = view.findViewById(R.id.btn_sort);

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("title");
        list.add("abc");
        adapter.setList(list);
        adapter.setList(list);
        list.add("hai");

        view.findViewById(R.id.btn_add).setOnClickListener(view1 -> {
            AddFragment addFragment = new AddFragment();

            EditText search = view.findViewById(R.id.search_field);
            Bundle bundle = new Bundle();
            bundle.putString("key", search.getText().toString());

            addFragment.setArguments(bundle);
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction().replace(R.id.main_container, new AddFragment())
                    .commit();
        });
    }
}