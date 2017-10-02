package com.example.abiduzair.tabbed;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.abiduzair.tabbed.R.styleable.View;

public class StartStory extends Activity implements android.view.View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_story);
        Button button = (Button) findViewById(R.id.pushstart);
        button.setOnClickListener(this);

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
        Intent intent=new Intent(StartStory.this,MainActivity.class);
        intent.putExtra("e1",title.getText().toString());
        intent.putExtra("e2",story.getText().toString());
        startActivity(intent);
    }


}
