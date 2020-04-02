package com.example.myfirebaseproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextAuthorName;
    Spinner spinnerSubject;
    Button buttonAddAuthor;
    ListView listViewAuthor;
    TextView textView;
    ArrayList<Author>  authors;
    DatabaseReference databaseAuthor;

    public static final String AUTHOR_NAME="com.example.myfirebaseproject1.authorname";
    public static final String Author_Id="com.example.myfirebaseproject1.authorid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseAuthor= FirebaseDatabase.getInstance().getReference("authors");
        editTextAuthorName=(EditText) findViewById(R.id.editTextAuthorName);
        spinnerSubject=(Spinner) findViewById(R.id.spinnerSubject);
        listViewAuthor = (ListView) findViewById(R.id.listViewAuthor);
        textView=(TextView) findViewById(R.id.textView);
        buttonAddAuthor = (Button) findViewById(R.id.buttonAddAthor);

        authors = new ArrayList<Author>();

                buttonAddAuthor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String aname=editTextAuthorName.getText().toString().trim();
                        String asubject=spinnerSubject.getSelectedItem().toString();
                        if(!TextUtils.isEmpty(aname)){
                            String aid=databaseAuthor.push().getKey();

                            Author author=new Author(aid,aname,asubject);

                            databaseAuthor.child(aid).setValue(author);

                            editTextAuthorName.setText("");
                            Toast.makeText(getApplicationContext(),"Save Succsessfully ...",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"Enter Auth Name ...",Toast.LENGTH_LONG).show();
                            editTextAuthorName.setError("Enter Auth Name ..");
                            editTextAuthorName.setFocusable(true);
                        }
                    }
                });
    }
    @Override
    protected void onStart(){
        super.onStart();
        databaseAuthor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                authors.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Author author= postSnapshot.getValue(Author.class);
                    authors.add(author);
//                    Log.e("Value of authors===","=="+authors);
                }
                AuthorList authorList=new AuthorList(MainActivity.this,authors);
                listViewAuthor.setAdapter(authorList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
