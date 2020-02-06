package cn.skilled.peon;


import android.util.Log;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

public class EmptyClient extends WebSocketClient {

    private final static String TAG = "EmptyClient";

    public EmptyClient(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public EmptyClient(URI serverURI) {
        super(serverURI);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        send("Hello, it is me. Mario :)");
        Log.i(TAG, "new connection opened");
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        Log.i(TAG,"closed with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onMessage(String message) {
        Log.i(TAG,"received message: " + message);
    }

    @Override
    public void onMessage(ByteBuffer message) {
        Log.i(TAG,"received ByteBuffer");
    }

    @Override
    public void onError(Exception ex) {
        Log.e(TAG, "an error occurred:" + ex);
    }

}