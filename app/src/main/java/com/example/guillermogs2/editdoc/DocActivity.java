package com.example.guillermogs2.editdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DocActivity extends AppCompatActivity {

    public static final int EDIT_TITLE = 0;

    // Model
    private String title = "Title", doc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et gravida mi. Praesent dapibus odio quis rhoncus elementum. Curabitur mattis porta nunc in auctor. Praesent eget orci et tortor pellentesque vehicula mollis non felis. Donec rutrum sagittis euismod. In non maximus arcu. Maecenas congue neque sed urna consequat posuere. Sed dapibus tellus nunc, vitae varius magna auctor eget. Etiam euismod eget risus vel pellentesque. Suspendisse potenti. Suspendisse posuere leo elit, in tincidunt odio placerat non. Aenean non enim eleifend libero rutrum vestibulum ac eu risus. Duis consequat nibh vel magna placerat varius. Nam vulputate nunc in varius placerat. Proin ex dui, condimentum vitae justo eget, maximus posuere ex.";

    // View
    private TextView title_view;
    private TextView doc_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        title_view = findViewById(R.id.title_view);
        doc_view = findViewById(R.id.doc_view);

        title_view.setText(title);
        doc_view.setText(doc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.option_edit_title:
                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("text",title);
                intent.putExtra("doc",doc);
                startActivityForResult(intent, EDIT_TITLE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // Step 3
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case EDIT_TITLE:
                if(resultCode == RESULT_OK){
                    title = data.getStringExtra("text");
                    doc = data.getStringExtra("doc");
                    title_view.setText(title);
                    doc_view.setText(doc);
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
}
