package nl.cantstop.discountcheck;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView finalPrice;
    EditText priceEditText;
    EditText discountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        finalPrice = (TextView) findViewById(R.id.finalPrice);
        priceEditText = (EditText) findViewById(R.id.prizeEditText);
        discountEditText = (EditText) findViewById(R.id.discountEditText);

        Button calcButton = (Button) findViewById(R.id.calcBtn);
        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                calculateDiscountHandle();
            }
        });
    }

    public void calculateDiscountHandle(){
        if (priceEditText.getText().length() == 0 || discountEditText.getText().length() == 0) {
            return;
        }

        // get user values from the widget
        float price = Float.parseFloat(priceEditText.getText().toString());
        float discount = Float.parseFloat(discountEditText.getText().toString());

        float discountPrize = price - ((discount / 100) * price);
        finalPrice.setText("€"+ roundToTwoDecimals(discountPrize));
    }

    private String roundToTwoDecimals(float val){
        return String.format("%.2f", val);
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
}
