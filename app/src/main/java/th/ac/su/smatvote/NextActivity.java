package th.ac.su.smatvote;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent i =getIntent();
        Button Text_Enter = (Button) findViewById(R.id.enter);
        Text_Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultTextView = findViewById(R.id.text);
                EditText numberEditText = findViewById(R.id.editTextNumber);
                String numText = numberEditText.getText().toString();
                int count=numText.length();
                if(count<13)
                    resultTextView.setText("กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก");
                else if(count>13)
                    resultTextView.setText("กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก");
                else if(count==13) {
                    resultTextView.setText("");
                    AlertDialog.Builder dialog = new AlertDialog.Builder(NextActivity.this);
                    dialog.setTitle("ผลการตรวจสอบสิทธิเลือกตั้ง");
                    boolean name =numText.equals("1111111111111");
                    if(name||numText.equals("2222222222222"))
                        dialog.setMessage("คุณเป็นผู้มีสิทธิเลือกตั้ง");
                    else
                        dialog.setMessage("คุณไม่มีสิทธิเลือกตั้ง");
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    dialog.show();
                }
            }
        });
    }
}