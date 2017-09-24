package shitycoders.expirienceapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class EmptyactivitylayoutActivity extends AppCompatActivity implements View.OnClickListener {
    EditText in1;
    EditText in2;
    EditText out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        in1 = (EditText) findViewById(R.id.value1);
        in2 = (EditText) findViewById(R.id.value2);
        out = (EditText) findViewById(R.id.valueOut);
        //Button btnPlus = (Button) findViewById(R.id.button_plus);;
        //Button btnMinus = (Button) findViewById(R.id.button_minus);;
        //Button btnMult = (Button) findViewById(R.id.button_mult);;
        //Button btnDiv = (Button) findViewById(R.id.button_div);;




        super.onCreate(savedInstanceState);
        setContentView(R.layout.emptyactivitylayout);
    }


    @Override
    public void onClick(View view) {
        int a1= Integer.parseInt(in1.getText().toString());
        int a2= Integer.parseInt(in2.getText().toString());
        switch (view.getId()) {
            case (R.id.button_plus):
                out.setText(a1+a2);
        }
    }
}
