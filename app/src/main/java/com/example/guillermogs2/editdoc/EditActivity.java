package com.example.guillermogs2.editdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditText edit_text;
    private EditText doc_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edit_text = findViewById(R.id.edit_text);
        doc_text = findViewById(R.id.edit_doc);

        // Step 1
        Intent intent = getIntent();
        if(intent != null){
            String text = intent.getStringExtra("text");
            String doc = intent.getStringExtra("doc");
            if(text != null){
                edit_text.setText(intent.getStringExtra("text"));
            }
            if(doc != null){
                doc_text.setText(intent.getStringExtra("doc"));
            }
        }
    }

    public void onSave(View view){
        //Step 2
        String new_text = edit_text.getText().toString();
        Intent data = new Intent();
        data.putExtra("text", new_text);
        new_text = doc_text.getText().toString();
        data.putExtra("doc", new_text);
        setResult(RESULT_OK, data);
        finish();
    }
}
