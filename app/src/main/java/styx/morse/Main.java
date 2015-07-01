package styx.morse;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends ActionBarActivity {
    private TextView text_result;
    private String text_encoded = "";
    private String current_lang = "en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_result = (TextView) findViewById(R.id.text_result);

        text_result.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                buttonCopyHandler(v);
            }
        });

        showToast(R.string.hint_copy);
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

        showToast(R.string.hint_copied);
    }

    private void showToast(int resource_id) {
        Context context = getApplicationContext();
        String text = getString(resource_id);
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    private void process() {
        text_result.setText(Transcoder.decode(current_lang, text_encoded));
    }

}
