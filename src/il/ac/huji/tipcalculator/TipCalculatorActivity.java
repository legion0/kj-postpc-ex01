package il.ac.huji.tipcalculator;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	private final double TIP_PERCENT = 0.12;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);

		Button button = (Button) findViewById(R.id.btnCalculate);
		button.setOnClickListener(calculateTipListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

	private OnClickListener calculateTipListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			EditText billAmountE = (EditText) findViewById(R.id.edtBillAmount);
			String billAmountS = billAmountE.getText().toString();
			Log.v("EditText", billAmountS);
			if (!"".equals(billAmountS)) {
				Double billAmount = Double.parseDouble(billAmountS);
				Double tip = billAmount * TIP_PERCENT;
				CheckBox chkRound = (CheckBox) findViewById(R.id.chkRound);
				Locale locale = Locale.getDefault();
				String tipStr;
				if (chkRound.isChecked())
					tipStr = String.format(locale, "$%d", (int)Math.round(tip));
				else
					tipStr = String.format(locale, "$%.2f", tip);
				TextView txtTipResult = (TextView) findViewById(R.id.txtTipResult);
				txtTipResult.setText(tipStr);
			}
		};
	};
}
