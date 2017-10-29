package com.example.abiduzair.tabbed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static com.example.abiduzair.tabbed.R.styleable.View;

public class StartStory extends Activity implements android.view.View.OnClickListener {
//private Button mFirebaseBtn;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_story);
        Button button = (Button) findViewById(R.id.pushstart);
        button.setOnClickListener(this);
        mDatabase= FirebaseDatabase.getInstance().getReference();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)

    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        EditText title = (EditText)findViewById(R.id.titlestart);
        EditText story = (EditText)findViewById(R.id.storystart);
//        File file = new File(Environment.getExternalStorageDirectory()+"/Cookstorys");
//        String filename = file.toString()+ "/"+"cookstories.csv";
        String entry=title.getText().toString()+","+story.getText().toString()+"\n";
        HashMap<String,String> dataMap=new HashMap<>();

        dataMap.put("Story",story.getText().toString().trim());
        dataMap.put("Title",title.getText().toString().trim());
        stories s = new stories(title.getText().toString().trim(), story.getText().toString().trim());

        //mDatabase.child("users").setValue(s);
        mDatabase.push().setValue(s);
//        try {
//                if(!file.exists()){
//                    file.mkdir();
//                    file.mkdirs();
//                    file.createNewFile();
//                    Toast.makeText(StartStory.this,"File does not exist",Toast.LENGTH_SHORT).show();
//                }
//                FileOutputStream out = openFileOutput(filename,Context.MODE_PRIVATE);
//                out.write(entry.getBytes());
//                out.close();
//            Toast.makeText(StartStory.this,"Story created",Toast.LENGTH_SHORT).show();
//            }
//            catch(Exception e){
//                Toast.makeText(StartStory.this,"Error creating story",Toast.LENGTH_SHORT).show();
//                e.printStackTrace();
//            }
        //Toast.makeText(StartStory.this,"Story done",Toast.LENGTH_SHORT).show();
        String filename = "cookstorys.csv";
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(entry.getBytes());
            outputStream.close();
           // Toast.makeText(StartStory.this, "file created", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent=new Intent(StartStory.this,MainActivity.class);
        intent.putExtra("e1",title.getText().toString());
        intent.putExtra("e2",story.getText().toString());
        startActivity(intent);
    }


}
