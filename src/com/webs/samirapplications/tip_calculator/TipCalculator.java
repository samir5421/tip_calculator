package com.webs.samirapplications.tip_calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.text.method.DialerKeyListener;
import android.view.View;

import java.lang.Double;


public class TipCalculator extends Activity
{
	private EditText txtbillamount;
	private EditText txtpeople;
	private EditText txtpercentage;
	private TextView txtperperson;
	private TextView txttipamount;
	private TextView txttotal;
	private Button btncalculate;
	private Button btnreset;
	private double billamount = 0; 
	private double percentage = 0;
	private double numofpeople = 0;
	private double tipamount = 0;
	private double totaltopay = 0;
	private double perperson = 0;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initControls();
	}
	private void initControls()
	{
		try{
		txtbillamount = (EditText)findViewById(R.id.txtbillamount);
		txtpeople = (EditText)findViewById(R.id.txtpeople);
		txtpercentage = (EditText)findViewById(R.id.txtpercentage);
		txtperperson=(TextView)findViewById(R.id.txtperperson);
		txttipamount=(TextView)findViewById(R.id.txttipamount);
		txttotal=(TextView)findViewById(R.id.txttotal);
		btncalculate = (Button)findViewById(R.id.btncalculate);
		btnreset = (Button)findViewById(R.id.btnreset);


		btncalculate.setOnClickListener(new Button.OnClickListener() 
		{ 
			public void onClick (View v)
			{ test();} 
		});

		btnreset.setOnClickListener(new Button.OnClickListener() 
		{ public void onClick (View v)
			{
				reset(); 
			}
		});
		}
		catch (Exception e){
			error();
		}
	}
	private void test()
	{

			try{
			billamount=Double.parseDouble(txtbillamount.getText().toString());
			percentage=Double.parseDouble(txtpercentage.getText().toString());
			numofpeople=Double.parseDouble(txtpeople.getText().toString());
			doCalc();
			}
			catch(NumberFormatException e){
				error();	
			}

		}
	
	public void doCalc(){
		if(txtbillamount.getText() == null || txtpercentage.getText() == null || txtpeople.getText() == null){
			error();
		}
		else if (Double.parseDouble(txtbillamount.getText().toString()) == Double.NaN && Double.parseDouble(txtpercentage.getText().toString()) == Double.NaN && Double.parseDouble(txtpeople.getText().toString()) == Double.NaN)
		{
			error();
		}
		else if (Double.parseDouble(txtbillamount.getText().toString()) <= 0 || Double.parseDouble(txtpercentage.getText().toString()) <= 0 || Double.parseDouble(txtpeople.getText().toString()) <= 0)
		{
			error();
		}
		else
		{
		tipamount=(billamount*percentage)/100;
		totaltopay=billamount+tipamount;
		perperson=totaltopay/numofpeople;
		txttipamount.setText((String)String.format("$%.2f", tipamount));
		txttotal.setText((String)String.format("$%.2f", totaltopay));
		txtperperson.setText((String)String.format("$%.2f", perperson));
		}
	}

	private void reset(){
		txtbillamount.setText("");
		txtpeople.setText("");
		txtpercentage.setText("");
		txtperperson.setText("");
		txttipamount.setText("");
		txttotal.setText("");
	}
	public void error(){
		{Toast.makeText(TipCalculator.this, R.string.error, Toast.LENGTH_LONG).show();}	
	}
}