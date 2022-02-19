package com.example.aplikasikalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText angkaPertama, angkaKedua;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angkaPertama = (EditText)findViewById(R.id.angka1);
        angkaKedua = (EditText)findViewById(R.id.angka2);
        hasil = (TextView)findViewById(R.id.textHasil);
    }

    public void operasiTambah(View v){
        if((angkaPertama.getText().length() > 0) && (angkaKedua.getText().length() > 0)){
            double result = operasiAritmatik("+");
            hasil.setText(Double.toString(result));
        } else {
            showAlert();
        }
    }

    public void operasiKurang(View v){
        if((angkaPertama.getText().length() > 0) && (angkaKedua.getText().length() > 0)){
            double result = operasiAritmatik("-");
            hasil.setText(Double.toString(result));
        } else {
            showAlert();
        }
    }

    public void operasiKali(View v){
        if((angkaPertama.getText().length() > 0) && (angkaKedua.getText().length() > 0)){
            double result = operasiAritmatik("x");
            hasil.setText(Double.toString(result));
        } else {
            showAlert();
        }
    }
    public void operasiBagi(View v){
        if((angkaPertama.getText().length() > 0) && (angkaKedua.getText().length() > 0)){
            if(angkaKedua.getText().toString().equals("0")){
                Toast.makeText(MainActivity.this, "Angka Pertama tidak boleh dibagi dengan 0", Toast.LENGTH_LONG).show();
            } else {
                double result = operasiAritmatik("/");
                hasil.setText(Double.toString(result));
            }
        } else {
            showAlert();
        }
    }

    public void operasiBersihkan(View v){
        angkaPertama.setText("");
        angkaKedua.setText("");
        hasil.setText("0.00");
    }

    public double operasiAritmatik(String operasi){
        double result = 0.00;
        double angka1 = Double.parseDouble(angkaPertama.getText().toString());
        double angka2 = Double.parseDouble(angkaKedua.getText().toString());
        switch (operasi){
            case "+" :
                result = angka1 + angka2;
                break;
            case "-" :
                result = angka1 - angka2;
                break;
            case "x":
                result = angka1 * angka2;
                break;
            case "/" :
                result = angka1 / angka2;
                break;
            default:
                result = 0.00;
                break;
        }
        return result;
    }

    public void showAlert(){
        Toast.makeText(MainActivity.this, "Mohon masukan Angka Pertama dan Kedua", Toast.LENGTH_LONG).show();
    }
}