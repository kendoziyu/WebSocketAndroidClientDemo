package cn.skilled.peon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "MainActivity";

    private Button mConnectBtn;

    private TextView mStatusTv;

    private WebSocketClient mWebSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConnectBtn = findViewById(R.id.connect_btn);
        mStatusTv = findViewById(R.id.status_tv);

        mConnectBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.connect_btn:
                try {
                    mWebSocketClient = new EmptyClient(new URI("ws://192.168.1.142:8887"), new Draft_6455());
                    mWebSocketClient.connect();
                } catch (Exception e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
                break;
        }
    }
}
