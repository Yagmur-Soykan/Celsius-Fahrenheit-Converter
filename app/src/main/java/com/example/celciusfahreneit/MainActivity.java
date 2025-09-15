package com.example.celciusfahreneit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private TextView result;
    private EditText input;
    private RadioButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.textView);
        input  = (EditText)findViewById(R.id.editText);
        btn = (RadioButton)findViewById(R.id.radioButton1);
    }

    public void buttonPressed(View v){

        double number = Double.parseDouble(input.getText().toString());
        /*Double.parseDouble() metodunu kullanabilmek için içeriğin bir String olması gereklidir.
         Bu metod bir String değerini alır ve onu bir double değerine dönüştürür.
         Bu nedenle, önce getText() ile Editable bir nesne alınır, sonra toString() ile bu Editable
         nesnesi bir Stringe dönüştürülür ve son olarak Double.parseDouble() ile bu String bir double değerine çevrilir.*/

        double math;

        if(btn.isChecked()) /* Celcius girdi Fahreneit'e çevir */
        {
            math = 1.8*(number) + 32;
            result.setVisibility(View.VISIBLE);
            result.setText(number + "C " + "= " + String.valueOf(math) + "F");
        }

        else /* Fahreneit girdi Celcius'a çevir */
        {

            math = (number-32) / 1.8;
            result.setVisibility(View.VISIBLE);
            result.setText(number + "F " + "= " + String.valueOf(math) + "C");
        }


        /*Java'da bir TextView nesnesine bir double değeri doğrudan atamak mümkün değildir.
         Bunun yerine, double değerini bir String'e dönüştürmelisiniz.

         toString() yöntemi double türünde değil, Object sınıfında tanımlıdır.
         Bu nedenle, toString() yöntemini doğrudan bir double değişkenine çağıramazsınız.*/

    }
}