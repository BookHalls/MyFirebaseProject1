package com.example.myfirebaseproject1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AuthorList extends ArrayAdapter<Author> {
    private Activity context;
    List<Author> authors;
    public AuthorList(Activity context,List<Author> authors){
        super(context,R.layout.layout_author_list,authors);
        this.context = context;
        this.authors=authors;
    }

    @Override
    public View getView(int position , View convertView, ViewGroup parent){
        LayoutInflater inflater= context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_author_list,null,true);
        TextView textViewAuthorName=(TextView) listViewItem.findViewById(R.id.textViewAuthorName);
        TextView textViewSubject = (TextView) listViewItem.findViewById(R.id.textViewSubject);

        Author author= authors.get(position);
        textViewAuthorName.setText(author.getAuthoreName());
        textViewSubject.setText(author.getAuthorSubject());

    return listViewItem;
    }
}
