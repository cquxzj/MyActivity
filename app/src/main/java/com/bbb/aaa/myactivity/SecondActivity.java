package com.bbb.aaa.myactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by lsx on 2016/7/22.
 */
public class SecondActivity extends AppCompatActivity {
    private TextView tv;
    private EditText mEditText;
    Button mBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String msg=getIntent().getStringExtra(MainActivity.NAME);
        tv = (TextView) this.findViewById(R.id.second_textView);
        mEditText = (EditText) this.findViewById(R.id.second_editText);
        mBtn = (Button) this.findViewById(R.id.second_btn);


        //Toast.makeText(SecondActivity.this, msg, Toast.LENGTH_SHORT).show();
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("back",mEditText.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        tv.setText("收到的消息："+msg);
    }
}
//public class SecondActivity extends Activity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
//    }
//}
