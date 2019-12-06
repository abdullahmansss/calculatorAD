package softagi.e.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView resultText, resultTextTwo;
    String op;
    int first = 0,second = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews()
    {
        resultText = findViewById(R.id.result_field);
        resultTextTwo = findViewById(R.id.result_field_two);
    }

    public void numbers(View view)
    {
        Button button = (Button) view;
        if (op != null)
        {
            resultTextTwo.append(button.getText().toString());
        } else
            {
                resultText.append(button.getText().toString());
            }
    }

    public void operators(View view)
    {
        if (op == null)
        {
            first = Integer.parseInt(resultText.getText().toString());
            Button button = (Button) view;
            op = button.getText().toString();
            resultText.append(op);
        } else
            {
                Toast.makeText(this, "op is already choosen", Toast.LENGTH_SHORT).show();
            }
    }

    public void equal(View view)
    {
        if (second == 0)
        {
            second = Integer.parseInt(resultTextTwo.getText().toString());
            resultText.append(resultTextTwo.getText());

            switch (op)
            {
                case "+":
                    resultTextTwo.setText(String.valueOf(first + second));
                    break;
                case "-":
                    resultTextTwo.setText(String.valueOf(first - second));
                    break;
                case "×":
                    resultTextTwo.setText(String.valueOf(first * second));
                    break;
                case "÷":
                    resultTextTwo.setText(String.valueOf(first / second));
                    break;
            }
        } else
            {
                Toast.makeText(this, "enter any number", Toast.LENGTH_SHORT).show();
            }
    }

    public void reset(View view)
    {
        resultText.setText("");
        resultTextTwo.setText("");
        op = null;
        first = 0;
        second = 0;
    }
}