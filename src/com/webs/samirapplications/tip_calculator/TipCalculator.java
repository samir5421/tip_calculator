package com.webs.samirapplications.tip_calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
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
	private double numofpeople= 0;
	private double tipamount = 0;
	private double totaltopay = 0;
	private double perperson = 0;
	// Called when the activity is first created.
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initControls();
	}
	private void initControls()
	{
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
			{ calculate();} 
			{Toast.makeText(TipCalculator.this, R.string.short_notification_text, Toast.LENGTH_SHORT).show();}
		});

		btnreset.setOnClickListener(new Button.OnClickListener() 
		{ public void onClick (View v)
			{
				reset(); 
			}
		});
	}
	private void calculate()
	{
		
		if (Double.parseDouble(txtbillamount.getText().toString()) == Double.NaN && Double.parseDouble(txtpercentage.getText().toString()) == Double.NaN && Double.parseDouble(txtpeople.getText().toString()) == Double.NaN)
		{
			{Toast.makeText(TipCalculator.this, R.string.error, Toast.LENGTH_LONG).show();}
		}
		else if (Double.parseDouble(txtbillamount.getText().toString()) <= 0 || Double.parseDouble(txtpercentage.getText().toString()) <= 0 || Double.parseDouble(txtpeople.getText().toString()) <= 0)
		{
			{Toast.makeText(TipCalculator.this, R.string.error, Toast.LENGTH_LONG).show();}	
		}
		else
		{

			billamount=Double.parseDouble(txtbillamount.getText().toString());
			percentage=Double.parseDouble(txtpercentage.getText().toString());
			numofpeople=Double.parseDouble(txtpeople.getText().toString());
			tipamount=(billamount*percentage)/100;
			totaltopay=billamount+tipamount;
			perperson=totaltopay/numofpeople;
			txttipamount.setText((String)String.format("$%.2f", tipamount));
			txttotal.setText((String)String.format("$%.2f", totaltopay));
			txtperperson.setText((String)String.format("$%.2f", perperson));

		}
	}

	private void reset()
	{
		txtbillamount.setText("");
		txtpeople.setText("");
		txtpercentage.setText("");
		txtperperson.setText("");
		txttipamount.setText("");
		txttotal.setText("");
	}
}