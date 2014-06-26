package styx.morse;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {
    private TextView text_result;
    private Button button_space;
    private Button button_backspace;
    private Button button_dot;
    private Button button_dash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_result = (TextView) findViewById(R.id.text_result);
        button_space = (Button) findViewById(R.id.button_clear);
        button_backspace = (Button) findViewById(R.id.button_clear);
        button_dot = (Button) findViewById(R.id.button_clear);
        button_dash = (Button) findViewById(R.id.button_clear);

//        button_clear.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//
//            }
//        });
    }

    public void buttonClearHandler(View view) {
       text_result.setText("");
    }

    public void buttonCopyHandler(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Decoded Morse", text_result.getText());
        clipboard.setPrimaryClip(clip);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
