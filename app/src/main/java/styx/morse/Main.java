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
    private String text_encoded = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_result = (TextView) findViewById(R.id.text_result);


//        button_clear.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//
//            }
//        });
    }

    public void buttonSpaceHandler(View view) {
        text_encoded += " ";
        decode();
    }

    public void buttonBackspaceHandler(View view) {
        final int text_encoded_len = text_encoded.length();
        if ( text_encoded_len > 0) {
            text_encoded = text_encoded.substring(0, text_encoded_len - 1);
        }
        decode();
    }

    public void buttonDotHandler(View view) {
        text_encoded += ".";
        decode();
    }

    public void buttonDashHandler(View view) {
        text_encoded += "-";
        decode();
    }

    public void buttonClearHandler(View view) {
        text_encoded = "";
        text_result.setText("");
    }

    public void buttonCopyHandler(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Decoded Morse", text_result.getText());
        clipboard.setPrimaryClip(clip);
    }

    private void decode() {
        text_result.setText(text_encoded);
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
