package example.com.jellytoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.LayoutInflater;

import com.yalantis.jellytoolbar.listener.JellyListener;
import com.yalantis.jellytoolbar.widget.JellyToolbar;

public class MainActivity extends AppCompatActivity {
    private JellyToolbar toolbar;
    private AppCompatEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (JellyToolbar) findViewById(R.id.toolbar);
        toolbar.getToolbar().setLogo(R.mipmap.ic_logo);
        toolbar.setJellyListener(jellyListener);

        editText = (AppCompatEditText) LayoutInflater.from(this).inflate(R.layout.edit_text, null);
        editText.setBackgroundResource(android.R.color.transparent);
        toolbar.setContentView(editText);
    }
    private JellyListener jellyListener = new JellyListener() {
        @Override
        public void onCancelIconClicked() {
            if (TextUtils.isEmpty(editText.getText())) {
                toolbar.collapse();
            } else {
                editText.getText().clear();
            }
        }
    };
}
