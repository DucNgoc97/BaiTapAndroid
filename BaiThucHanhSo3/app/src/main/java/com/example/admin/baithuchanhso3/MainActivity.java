package com.example.admin.baithuchanhso3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtname, txtage;
    Switch swgender;
    Button  btadd, btclear;
    LinearLayout liststudent;

    private View.OnClickListener onclick = new View.OnClickListener(){
        @Override
        public  void onClick(View v){
            if(v.getId()==R.id.btadd)
                btaddClick();
            if(v.getId()==R.id.btclear)
                btclearClick();
        }
    };
    private CompoundButton.OnCheckedChangeListener onchange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                swgender.setText("NAM");
            } else {
            swgender.setText("NỮ");
        }
        }
    };

    private void btaddClick() {
        if (txtname.getText().toString().isEmpty() ||
                txtage.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
        } else {
            String hoten = txtname.getText().toString().trim();
            int tuoi = Integer.parseInt(txtage.getText().toString().trim());
            boolean gioitinh = swgender.isChecked();


            final Student st = new Student(getApplicationContext(), hoten, tuoi, gioitinh);
            st.setText(st.toString());
            st.setPadding(10, 10, 10, 10);
            st.setTextColor(Color.BLACK);
            st.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student s = (Student) (v);
                    txtname.setText(s.getHoten());
                    txtage.setText(s.getTuoi() + "");
                    swgender.setText((s.isGioitinh()) ? "NAM" : "NỮ");
                    swgender.setChecked(s.isGioitinh());
                }
            });
            liststudent.addView(st);
        }
    }
    private void btclearClick() {
        liststudent.removeAllViews();
        txtname.setText("");
        txtage.setText("");
        swgender.setText("NỮ");
        swgender.setChecked(false);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname = findViewById(R.id.txtname);
        txtage = findViewById(R.id.txtage);
        swgender = findViewById(R.id.swgender);
        btadd = findViewById(R.id.btadd);
        btclear = findViewById(R.id.btclear);
        liststudent = findViewById(R.id.liststudent);
        
        btadd.setOnClickListener(onclick);
        btclear.setOnClickListener(onclick);
        swgender.setOnCheckedChangeListener(onchange);
    }
    
}
