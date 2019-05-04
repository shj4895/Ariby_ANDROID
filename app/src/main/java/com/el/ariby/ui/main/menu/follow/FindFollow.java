package com.el.ariby.ui.main.menu.follow;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.el.ariby.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FindFollow extends AppCompatActivity {
    DatabaseReference ref;
    FirebaseDatabase database;
    EditText editTextFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_follow);

        final ListView listView;
        FollowAdapter adapter;

        adapter = new FollowAdapter();
        editTextFilter = findViewById(R.id.find);
        listView = findViewById(R.id.listview1);
        listView.setAdapter(adapter);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("user");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String nickname = snapshot.child("nickname").getValue().toString();
                    Log.d("nickname",nickname);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_circle_black_24dp),
                "Sam Smith", "I'm not the only one.\r\nStay with me.\r\n") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_circle_black_24dp),
                "Bryan Adams", "heaven.\r\nI do it for you.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_circle_black_24dp),
                "Eric Clapton", "Tears in heaven.\r\nChange the world.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_circle_black_24dp),
                "Gary Moore", "Still got the blues.\r\nOne day.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_circle_black_24dp),
                "Helloween", "A tale that wasn't right.\r\nI want out.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_circle_black_24dp),
                "Adele", "Hello.\r\nSomeone like you.") ;



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FollowItem item = (FollowItem) parent.getItemAtPosition(position) ;

                String titleStr = item.getNick() ;
                String descStr = item.getDescStr() ;
                Drawable iconDrawable = item.getIconDrawable() ;
            }
        });


        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String filterText = s.toString();
                ((FollowAdapter)listView.getAdapter()).getFilter().filter(filterText) ;
            }
        });
    }
}
