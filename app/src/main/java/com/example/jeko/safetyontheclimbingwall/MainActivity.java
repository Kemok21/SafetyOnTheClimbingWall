package com.example.jeko.safetyontheclimbingwall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks how many correct answers the user gave
     * and calls the appropriate Toast
     */
    public void result(View v) {
        EditText nameEditText = findViewById(R.id.edit_name_et);
        String name = nameEditText.getText().toString();
        if (name.length() != 0) {
            int rightAnswers = oneAnswer() + twoAnswer() + threeAnswer() + fourAnswer() +
                    radioAnswer((RadioButton) findViewById(R.id.five_que4_rb)) +
                    radioAnswer((RadioButton) findViewById(R.id.six_que1_rb));
            if (rightAnswers == 6)
                Toast.makeText(this, getString(R.string.correct, name), Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, getString(R.string.wrong, name, rightAnswers), Toast.LENGTH_LONG).show();
        } else Toast.makeText(this, getString(R.string.notName), Toast.LENGTH_SHORT).show();
    }

    /**
     * Checking the third question with EditText
     * @return 1 or 0
     */
    protected int threeAnswer() {
        EditText threeAnswerET = findViewById(R.id.three_que_et);
        String answer = threeAnswerET.getText().toString();
        if (answer.compareToIgnoreCase(getString(R.string.threeQueAns1)) == 0)
            return 1;
        else return 0;
    }
    /**
     * Checking the first question with CheckBox
     * @return 1 or 0
     */
    protected int oneAnswer() {
        CheckBox oneQue1 = findViewById(R.id.one_que1_cb);
        CheckBox oneQue2 = findViewById(R.id.one_que2_cb);
        CheckBox oneQue3 = findViewById(R.id.one_que3_cb);
        CheckBox oneQue4 = findViewById(R.id.one_que4_cb);

        if (oneQue1.isChecked() && oneQue2.isChecked() && !oneQue3.isChecked() && oneQue4.isChecked())
            return 1;
        else return 0;
    }
    /**
     * Checking the second question with CheckBox
     * @return 1 or 0
     */
    protected int twoAnswer() {
        CheckBox twoQue1 = findViewById(R.id.two_que1_cb);
        CheckBox twoQue2 = findViewById(R.id.two_que2_cb);
        CheckBox twoQue3 = findViewById(R.id.two_que3_cb);
        CheckBox twoQue4 = findViewById(R.id.two_que4_cb);

        if (twoQue1.isChecked() && twoQue2.isChecked() && twoQue3.isChecked() && twoQue4.isChecked())
            return 1;
        else return 0;
    }
    /**
     * Checking the fourth question with CheckBox
     * @return 1 or 0
     */
    protected int fourAnswer() {
        CheckBox fourQue1 = findViewById(R.id.four_que1_cb);
        CheckBox fourQue2 = findViewById(R.id.four_que2_cb);
        CheckBox fourQue3 = findViewById(R.id.four_que3_cb);

        if (fourQue1.isChecked() && fourQue2.isChecked() && !fourQue3.isChecked())
            return 1;
        else return 0;
    }
    /**
     * Checking the fifth and sixth question with RadioButton
     * @return 1 or 0
     */
    protected int radioAnswer(RadioButton rightAnswer) {
        if (rightAnswer.isChecked())
            return 1;
        else return 0;
    }
}
