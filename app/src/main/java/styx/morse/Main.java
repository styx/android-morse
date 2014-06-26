package styx.morse;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Main extends Activity {
    private TextView text_result;
    private String text_encoded = "";
    private String current_lang = "en";

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
        process();
    }

    public void buttonBackspaceHandler(View view) {
        final int text_encoded_len = text_encoded.length();
        if ( text_encoded_len > 0) {
            text_encoded = text_encoded.substring(0, text_encoded_len - 1);
        }
        process();
    }

    public void buttonDotHandler(View view) {
        text_encoded += ".";
        process();
    }

    public void buttonDashHandler(View view) {
        text_encoded += "-";
        process();
    }

    public void buttonClearHandler(View view) {
        text_encoded = "";
        text_result.setText("");
    }

    public void buttonLangHandler(View view) {
        if(current_lang.equals("en"))
            current_lang = "ru";
        else
            current_lang = "en";
        process();
    }

    public void buttonCopyHandler(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Decoded Morse", text_result.getText());
        clipboard.setPrimaryClip(clip);
    }

    private void process() {
        text_result.setText(Transcoder.decode(current_lang, text_encoded));
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
