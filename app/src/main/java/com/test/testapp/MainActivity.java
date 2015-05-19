package com.test.testapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, zeroButton;
    Button plusButton, minusButton, muplityButton, divideButton, equalsButton, decimalButton, clearButton, historyButton;

    TextView resultTextView, currentOperationTv;
    float result;
    String currentOperation;
    String temp = "";
    int operator;
    String num1String = "";
    String num2String = "";
    boolean forSecondOperand = false;
    MyDatabaseHelper myDatabaseHelper;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneButton = (Button) findViewById(R.id.oneBtn);
        twoButton = (Button) findViewById(R.id.TwoBtn);
        threeButton = (Button) findViewById(R.id.ThreeBtn);
        fourButton = (Button) findViewById(R.id.fourBtn);
        fiveButton = (Button) findViewById(R.id.FiveBtn);
        sixButton = (Button) findViewById(R.id.sixBtn);
        sevenButton = (Button) findViewById(R.id.sevenBtn);

        eightButton = (Button) findViewById(R.id.eightBtn);
        nineButton = (Button) findViewById(R.id.nineBtn);
        zeroButton = (Button) findViewById(R.id.zeroBtn);
        plusButton = (Button) findViewById(R.id.plusBtn);
        minusButton = (Button) findViewById(R.id.minusBtn);
        divideButton = (Button) findViewById(R.id.divideBtn);
        muplityButton = (Button) findViewById(R.id.multiplyBtn);

        equalsButton = (Button) findViewById(R.id.equalsBtn);
        decimalButton = (Button) findViewById(R.id.decimalBtn);

        resultTextView = (TextView) findViewById(R.id.resultTv);
        currentOperationTv = (TextView) findViewById(R.id.currentOperation);
        clearButton = (Button) findViewById(R.id.clearBtn);
        historyButton = (Button) findViewById(R.id.historyBtn);


        oneButton.setOnClickListener(onClickListener);
        twoButton.setOnClickListener(onClickListener);
        threeButton.setOnClickListener(onClickListener);
        fourButton.setOnClickListener(onClickListener);
        fiveButton.setOnClickListener(onClickListener);
        sixButton.setOnClickListener(onClickListener);
        sevenButton.setOnClickListener(onClickListener);
        eightButton.setOnClickListener(onClickListener);
        nineButton.setOnClickListener(onClickListener);
        zeroButton.setOnClickListener(onClickListener);

        plusButton.setOnClickListener(onClickListener);
        minusButton.setOnClickListener(onClickListener);
        muplityButton.setOnClickListener(onClickListener);
        divideButton.setOnClickListener(onClickListener);
        equalsButton.setOnClickListener(onClickListener);
        decimalButton.setOnClickListener(onClickListener);
        clearButton.setOnClickListener(onClickListener);
        historyButton.setOnClickListener(onClickListener);

        myDatabaseHelper = new MyDatabaseHelper(this);

        if (getIntent().hasExtra(Intent.EXTRA_TEXT)) {
            String history = getIntent().getStringExtra(Intent.EXTRA_TEXT);
            String[] strings = history.split("=");
            resultTextView.setText(strings[1]);
            currentOperationTv.setText(strings[0]);
            num1String = strings[1];
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.oneBtn:

                    currentOperation = "1";

                    if (forSecondOperand) {
                        num2String += currentOperation;

                    } else {
                        temp += currentOperation;
                        result = Float.valueOf(temp);
                    }

                    currentOperationTv.append(currentOperation);
                    break;
                case R.id.TwoBtn:

                    currentOperation = "2";

                    if (forSecondOperand) {
                        num2String += currentOperation;

                    } else {
                        temp += currentOperation;
                        result = Float.valueOf(temp);
                    }

                    currentOperationTv.append(currentOperation);
                    break;

                case R.id.ThreeBtn:

                    currentOperation = "3";

                    if (forSecondOperand) {
                        num2String += currentOperation;

                    } else {
                        temp += currentOperation;
                        result = Float.valueOf(temp);
                    }

                    currentOperationTv.append(currentOperation);

                    break;
                case R.id.fourBtn:

                    currentOperation = "4";

                    if (forSecondOperand) {
                        num2String += currentOperation;
                    } else {
                        temp += currentOperation;
                        result = Float.valueOf(temp);
                    }

                    currentOperationTv.append(currentOperation);

                    break;
                case R.id.FiveBtn:
                    currentOperation = "5";

                    if (forSecondOperand) {
                        num2String += currentOperation;

                    } else {
                        temp += currentOperation;
                        result = Float.valueOf(temp);
                    }

                    currentOperationTv.append(currentOperation);

                    break;

                case R.id.sixBtn:

                    currentOperation = "6";

                    if (forSecondOperand) {
                        num2String += currentOperation;

                    } else {
                        temp += currentOperation;
                        result = Float.valueOf(temp);
                    }

                    currentOperationTv.append(currentOperation);
                    break;

                case R.id.sevenBtn:
                    currentOperation = "7";

                    if (forSecondOperand) {
                        num2String += currentOperation;

                    } else {
                        temp += currentOperation;
                        result = Float.valueOf(temp);
                    }
                    currentOperationTv.append(currentOperation);

                    break;
                case R.id.eightBtn:
                    currentOperation = "8";

                    if (forSecondOperand) {
                        num2String += currentOperation;

                    } else {
                        temp += currentOperation;
                        result = Float.valueOf(temp);
                    }

                    currentOperationTv.append(currentOperation);

                    break;
                case R.id.nineBtn:

                    currentOperation = "9";

                    if (forSecondOperand) {
                        num2String += currentOperation;

                    } else {
                        temp += currentOperation;
                        result = Float.valueOf(temp);
                    }

                    currentOperationTv.append(currentOperation);
                    break;

                case R.id.zeroBtn:

                    currentOperation = "0";

                    if (forSecondOperand) {
                        num2String += currentOperation;

                    } else {
                        temp += currentOperation;
                        result = Float.valueOf(temp);
                    }

                    currentOperationTv.append(currentOperation);
                    break;

                case R.id.plusBtn:

                    operator = 1;
                    currentOperation = "+";

                    if(forSecondOperand) {
                        result = getresult(operator);
                    }

                    forSecondOperand = true;


                    num1String = String.valueOf(result);
                    num2String = "";
                    temp = "";

                    currentOperationTv.append(currentOperation);
                    break;

                case R.id.minusBtn:


                    operator = 2;
                    currentOperation = "-";

                    if(forSecondOperand) {
                        result = getresult(operator);
                    }
                    forSecondOperand = true;

                    num1String = String.valueOf(result);
                    num2String = "";
                    temp = "";

                    currentOperationTv.append(currentOperation);
                    break;

                case R.id.divideBtn:

                    operator = 3;
                    currentOperation = "/";

                    if(forSecondOperand) {
                        result = getresult(operator);
                    }
                    forSecondOperand = true;


                    num1String = String.valueOf(result);
                    num2String = "";
                    temp = "";

                    currentOperationTv.append(currentOperation);
                    break;

                case R.id.multiplyBtn:

                    operator = 4;
                    currentOperation = "*";
                    if(forSecondOperand) {
                        result = getresult(operator);
                    }
                    forSecondOperand = true;

                    num1String = String.valueOf(result);
                    num2String = "";
                    temp = "";

                    currentOperationTv.append(currentOperation);

                    break;

                case R.id.decimalBtn:

                    currentOperation = ".";

                    if (forSecondOperand) {
                        num2String += currentOperation;
                    }
                    currentOperationTv.append(currentOperation);
                    break;

                case R.id.clearBtn:
                    currentOperation = "";
                    forSecondOperand = false;
                    currentOperationTv.setText(currentOperation);
                    num2String = "";
                    num1String = "";
                    result = 0;
                    temp = "";
                    break;

                case R.id.historyBtn:

                    Intent intent = new Intent(MainActivity.this, SecondTestAppActivity.class);
                    startActivity(intent);

                    break;

                case R.id.equalsBtn:

                    result = getresult(operator);

                    resultTextView.setText("" + result);

                    ContentValues values = new ContentValues();
                    values.put(DatabaseContract.HistoryEntry.COLUMN_HISTORY_COMPLETE, currentOperationTv.getText().toString());
                    values.put(DatabaseContract.HistoryEntry.COLUMN_HISTORY_RESULT, resultTextView.getText().toString());
                    SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                    long id = db.insert(DatabaseContract.HistoryEntry.TABLE_NAME, null, values);

                    Log.i(TAG, "Inserted Id: " + id);

                    num1String = "";
                    num1String += resultTextView.getText().toString();
                    num2String = "";

                    break;

            }
        }
    };

    private float getresult(int operator) {
        float returnedresult = 0;

        float operand1 = result;
        float operand2 = Float.valueOf(num2String);

        Log.i(TAG, " Operand1: " + operand1 + " Operand2: " + operand2);

        switch (operator) {

            case 1:
                returnedresult = operand1 + operand2;
                return returnedresult;
            case 2:
                returnedresult = operand1 - operand2;
                return returnedresult;
            case 3:

                returnedresult = operand1 / operand2;
                return returnedresult;

            case 4:
                returnedresult = operand1 * operand2;
                return returnedresult;
            default:
                return returnedresult;
        }
    }
}
