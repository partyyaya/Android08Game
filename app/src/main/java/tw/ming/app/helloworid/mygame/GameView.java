package tw.ming.app.helloworid.mygame;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Mac on 2017/8/12.
 */

public class GameView extends View {
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context);
        setBackgroundResource(R.drawable.bg);
    }
}
