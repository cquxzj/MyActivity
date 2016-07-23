package com.bbb.aaa.myactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String NAME = "name";
    Button mBtn1,mBtn2;
    EditText nameTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        nameTxt = (EditText) this.findViewById(R.id.nameTxt);
        mBtn1 =(Button)this.findViewById(R.id.btn1);
        mBtn2 =(Button)this.findViewById(R.id.btn2);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "hello toast", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(NAME,nameTxt.getText().toString());
               //startActivity(intent);
                startActivityForResult(intent, 10);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "hello toast", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra(NAME,nameTxt.getText().toString());
                //startActivity(intent);
                startActivityForResult(intent, 20);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // super.onActivityResult(requestCode, resultCode, data);
        String msg=data.getStringExtra("back");
        switch(requestCode){
            case 10:
                Toast.makeText(MainActivity.this, msg+"：from SecondActivity", Toast.LENGTH_LONG).show();
                break;
            case 20:
                Toast.makeText(MainActivity.this, msg +": from ThirdActivity", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

        Log.d(TAG, "onActivityResult: "+requestCode+","+resultCode);

    }


}
