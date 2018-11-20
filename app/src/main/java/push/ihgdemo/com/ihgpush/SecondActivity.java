package push.ihgdemo.com.ihgpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.alibaba.sdk.android.push.AndroidPopupActivity;

import java.util.Map;

import static android.app.Notification.VISIBILITY_PUBLIC;

public class SecondActivity extends AndroidPopupActivity {
    static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 实现通知打开回调方法，获取通知相关信息
     *
     * @param title   标题
     * @param summary 内容
     * @param extMap  额外参数
     */
    @Override
    protected void onSysNoticeOpened(String title, String summary, Map<String, String> extMap) {
        Log.d(TAG, "OnPushSysNoticeOpened, title: " + title + ", content: " + summary);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this, "1")
                .setPriority(Notification.PRIORITY_DEFAULT)  //通知的优先级
                .setCategory(Notification.CATEGORY_MESSAGE)  //通知的类型
                .setTicker(title)
                .setContentTitle(title)
                .setContentText(summary)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.launcher)
                .setVisibility(VISIBILITY_PUBLIC)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.launcher))
                .setAutoCancel(true)
                .build();
        manager.notify(1, notification);
    }
}