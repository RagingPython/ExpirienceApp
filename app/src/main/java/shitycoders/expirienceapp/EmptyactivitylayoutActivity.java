package shitycoders.expirienceapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EmptyactivitylayoutActivity extends AppCompatActivity implements View.OnClickListener {
    EditText in1;
    EditText in2;
    TextView out;
    Button btnPlus;
    Button btnMinus;
    Button btnMult;
    Button btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emptyactivitylayout);
        in1 = (EditText) findViewById(R.id.value1);
        in2 = (EditText) findViewById(R.id.value2);
        out = (TextView) findViewById(R.id.textOut);
        btnPlus = (Button) findViewById(R.id.button_plus);
        btnMinus = (Button) findViewById(R.id.button_minus);
        btnMult = (Button) findViewById(R.id.button_mult);
        btnDiv = (Button) findViewById(R.id.button_div);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        double a1;
        double a2;
        if (in1.getText().toString().equals("")!= true) {
            a1 = Double.parseDouble(in1.getText().toString());
        } else {a1=0;}
        if (in2.getText().toString().equals("")!= true) {
            a2 = Double.parseDouble(in2.getText().toString());
        } else {a2=0;}
        switch (view.getId()) {
            case (R.id.button_plus):
                out.setText(a1+a2+"");
                break;
            case (R.id.button_minus):
                out.setText(a1-a2+"");
                break;
            case (R.id.button_mult):
                out.setText(a1*a2+"");
                break;
            case (R.id.button_div):
                if (a2!=0) {
                    out.setText(a1 / a2 + "");
                } else {out.setText("Division by zero!");}
                break;
        }
    }
}
