package com.example.ameer.calcass2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
public String number1="" , number2="" , ans="",input="0";int num1=0; int num2=0;String memory="0";
public char opp ;Boolean flag=true;
    int counter = 0;//counter of opperations,
    int anss=0,negativcounter=0;
public   TextView InputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void RemoveFirstZero(){
        if(input.length()==1){
        if(input.charAt(0)=='0'){
        input="";}}
    }
public void onClick(View v) {

    InputText  = (TextView) findViewById(R.id.InputText);
    if(input.length()>=3&&input.charAt(input.length()-1)=='0'&&input.charAt(input.length()-2)=='÷'){

      Toast.makeText(this,"Don't divide At Zero!",Toast.LENGTH_SHORT).show();
        InputText.setText("Error!");input="0";counter=0;
    }
 else if (v.getId() == R.id.Zero) {RemoveFirstZero();
        input = input + "0";
    InputText.setText(input);
    } else if (v.getId() == R.id.One) {RemoveFirstZero();
        input = input + "1";
        InputText.setText(input);
    } else if (v.getId() == R.id.Two) {RemoveFirstZero();
        input = input + "2";
        InputText.setText(input);
    } else if (v.getId() == R.id.Three) {RemoveFirstZero();
        input = input + "3";
        InputText.setText(input);
    } else if (v.getId() == R.id.Four) {RemoveFirstZero();
        input = input + "4";
        InputText.setText(input);
    } else if (v.getId() == R.id.Five) {RemoveFirstZero();
        input = input + "5";
        InputText.setText(input);
    } else if (v.getId() == R.id.Six) {RemoveFirstZero();
        input = input + "6";
        InputText.setText(input);
    } else if (v.getId() == R.id.Seven) {RemoveFirstZero();
        input = input + "7";
        InputText.setText(input);
    } else if (v.getId() == R.id.Eight) {RemoveFirstZero();
        input = input + "8";
        InputText.setText(input);
    } else if (v.getId() == R.id.Nine) {RemoveFirstZero();
        input = input + "9";
        InputText.setText(input);
    }
else if(v.getId()==R.id.Plus){
        input= input + '+';
      if(RemoveExtraOperation()){
           counter=1;}

      else{
counter++;
        if(counter==1) {
            InputText.setText(input);
        }
        else {
            Seperate();
        }}}

    else if(v.getId()==R.id.Mul){
        input = input + 'x';
        if(RemoveExtraOperation()){
            counter=1;}
        else{
        counter++;
        if(counter==1){
            InputText.setText(input);
        }else{
            Seperate();
    }}}

    else if(v.getId()==R.id.Minus){
        input = input + '-';
        if(RemoveExtraOperation()){
            counter=1;}
        else{
            counter++;
            if(counter==1){
                InputText.setText(input);
            }else{
                Seperate();
            }}
    }
    else if(v.getId()==R.id.Divide){
        input = input + '÷';
        if(RemoveExtraOperation()){
            counter=1;}
        else{
            counter++;
            if(counter==1){
                InputText.setText(input);
            }else{
                Seperate();
            }}

    }
else if(v.getId()==R.id.Equal){
        if(isOperation(input.charAt(input.length()-1))==false){
        for(int j =1; j<input.length();j++){
            if(isOperation(input.charAt(j))){
                number1 = input.substring(0,j);
                number2 = input.substring(j+1,input.length());
                anss= calculateIt(Integer.parseInt(number1),input.charAt(j),Integer.parseInt(number2));
                InputText.setText(String.valueOf(anss));
                input = String.valueOf(anss)+"";
                counter=0;
                break;
            }else continue;}}
    }
    else if (v.getId()==R.id.C){
        input="0";InputText.setText("0");counter=0;anss=0;number1="";number2="";}

else if(v.getId()==R.id.Back){
        if(input.length()==1){input="0";InputText.setText(input);counter=0;anss=0;number1="";number2="";

        }else{
            if(isOperation(input.charAt(input.length()-1))){counter--;}
        input=input.substring(0,input.length()-1);InputText.setText(input);


    }}
    else if(v.getId()==R.id.N){
        if(input.charAt(0)!='0'){
        if(negativcounter%2==0){
        input = '-' + input;
        InputText.setText(input);negativcounter++;}
        else{
            input = input.substring(1,input.length());
           InputText.setText(input);negativcounter++;
        }

    }}
    else if(v.getId()==R.id.M) {
        if(isOperation(input.charAt(input.length()-1))){
            memory = input.substring(0,input.length()-1);

        }
else {
        for (int i = 1; i < input.length(); i++) {
            if (isOperation(input.charAt(i))) {
                memory = input.substring(i+1,input.length());
                flag = false;
                break;
            }

        }

        if (flag == true) {
            memory = input;
        }}}

else if(v.getId()==R.id.MR){
        if(input=="0"){
            input=memory;InputText.setText(input);
        }else{
           input = InputText.getText().toString() +memory;

            InputText.setText(input);
         }}

else if(v.getId()==R.id.MC){
        memory="0";
    }

}

public void Seperate(){//this functin seperates the string characters untll find operation sign, before the sign is first num and after it is the second

    for(int i =1; i<input.length();i++){
        if(isOperation(input.charAt(i))){
            number1 = input.substring(0,i);
            number2 = input.substring(i+1,input.length()-1);
            anss= calculateIt(Integer.parseInt(number1),input.charAt(i),Integer.parseInt(number2));
            InputText.setText(String.valueOf(anss)+input.charAt(input.length()-1));
            input = String.valueOf(anss)+input.charAt(input.length()-1);counter=1;
            break;}}}

public boolean RemoveExtraOperation(){// forexample if you first press + oper, and you changed your oper and press x it should take x instead of + amd s on
    if(isOperation(input.charAt(input.length()-1))&&isOperation(input.charAt(input.length()-2))){
        input= input.substring(0,input.length()-2)+input.charAt(input.length()-1);

        InputText.setText(input);return true;
    }
    else return false;
}

    public int calculateIt(int x,char op,int y){
        double inf = Double.POSITIVE_INFINITY;
        switch(op){
            case'+':return x+y;
            case'-':return x-y;
            case'x':return x*y;
            case'÷':{
                if(y!=0)
                return x/y;

            }
            default:  return (int)inf;


        }}

    public boolean isOperation(char x){//to check if the char is an operation
        if (x=='+'||x=='-'||x=='x'||x=='÷')
            return true;
        return false;
    }
    public boolean isDigit(char number){//to check if the char is an digit
        if((number>='0'&&number<='9'))
            return true;
        return false;
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
}
