package com.example.android_train;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * @author 65667
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button, recycleButton, listButton;
    private EditText editText;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        recycleButton = findViewById(R.id.recycle_button);
        recycleButton.setOnClickListener(this);

        listButton = findViewById(R.id.list_button);
        listButton.setOnClickListener(this);

        editText = findViewById(R.id.edit_text);
        progressBar = findViewById(R.id.progress_bar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String input = editText.getText().toString();
                Log.e("AI", input);
//                Toast.makeText(MainActivity.this, input, Toast.LENGTH_SHORT).show();
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else{
                    progressBar.setVisibility(View.GONE);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("鬼魅一笑");
                builder.setMessage("澳子哥帅吗？");
                builder.setCancelable(false);
                builder.setPositiveButton("帅", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "人家都不好意思了呢！", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("巨丑", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "人家都不好意思了呢！", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
//                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
//                progressDialog.setMessage("内容");
//                progressDialog.setTitle("标题");
//                progressDialog.show();
                break;
            case R.id.recycle_button:
                Intent intent = new Intent(MainActivity.this, FruitRecycleActivity.class);
                startActivity(intent);
                break;
            case R.id.list_button:
                Intent intent1 = new Intent(MainActivity.this, FruitListActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }
}