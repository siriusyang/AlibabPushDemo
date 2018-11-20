package push.ihgdemo.com.ihgpush;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;

public class MainActivity extends AppCompatActivity {
    static TextView messageTextView;
    TextView devicesIdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageTextView = findViewById(R.id.messge);
        MainApplication.setMainActivity(this);

        devicesIdTextView = this.findViewById(R.id.deviceid_getdeviceid);

        if (null == PushServiceFactory.getCloudPushService()) {
            devicesIdTextView.setText(getResources().getString(R.string.env_init_fail));
        } else {
            devicesIdTextView.setText(getResources().getString(R.string.start_before_get) + PushServiceFactory.getCloudPushService().getDeviceId());
            Log.i("DeviceId:", devicesIdTextView.getText().toString());
        }
    }

    public void appendConsoleText(final String message) {

        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageTextView.append(message + "\n");
            }
        });

    }
}
