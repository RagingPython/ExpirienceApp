package shitycoders.expirienceapp;


import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EmptyactivitylayoutActivity extends AppCompatActivity implements View.OnClickListener {
    EditText in1;
    EditText in2;
    EditText newNote;
    EditText notes;
    TextView out;
    Button btnPlus;
    Button btnMinus;
    Button btnMult;
    Button btnDiv;
    Button btnAddNewNote;

    DbConnector db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emptyactivitylayout);
        in1 = (EditText) findViewById(R.id.value1);
        in2 = (EditText) findViewById(R.id.value2);
        newNote = (EditText) findViewById(R.id.addNote);
        notes = (EditText) findViewById(R.id.notes);
        out = (TextView) findViewById(R.id.textOut);
        btnPlus = (Button) findViewById(R.id.button_plus);
        btnMinus = (Button) findViewById(R.id.button_minus);
        btnMult = (Button) findViewById(R.id.button_mult);
        btnDiv = (Button) findViewById(R.id.button_div);
        btnAddNewNote = (Button) findViewById(R.id.buttonAdd);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnAddNewNote.setOnClickListener(this);
        db=new DbConnector(getApplicationContext());
        refreshNotes();
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
            case (R.id.buttonAdd):
                db.addRecord(newNote.getText().toString());
                refreshNotes();
                break;
        }
    }

    public void refreshNotes() {
        Cursor cur = db.readAll();
        notes.setText("");
        if (cur != null) {
            if (cur.getCount()>0) {
                cur.moveToFirst();
                do {
                    notes.append(cur.getString(0)+"\n");
                } while (cur.moveToNext());
            }
        }
    }
}
