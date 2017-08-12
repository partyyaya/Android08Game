package tw.ming.app.helloworid.mygame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class GameView extends View {
    private Bitmap bmpBall;
    private Resources res;
    private Paint paintBall;
    private boolean isInit;
    private int viewW, viewH;
    private float ballW, ballH, ballX, ballY, dx, dy;
    private Matrix matrix;

    private Timer timer;

    public GameView(Context context) {
        super(context);
        setBackgroundResource(R.drawable.bg);
        res = context.getResources();
        bmpBall = BitmapFactory.decodeResource(res,R.drawable.ball);
        paintBall = new Paint();
        paintBall.setAlpha(255);//透明度

        matrix = new Matrix();
        timer = new Timer();
    }
    private void init(){
        isInit = true;
        viewW = getWidth(); viewH = getHeight();
        ballW = viewW / 12f; ballH = ballW;
        dx = viewW / 256f; dy = viewH / 256f;

        matrix.reset();
        matrix.postScale(ballW / bmpBall.getWidth(), ballH / bmpBall.getHeight());
        bmpBall = Bitmap.createBitmap(bmpBall,0,0,
                bmpBall.getWidth(),bmpBall.getHeight(),
                matrix, false);
        timer.schedule(new BallTask(), 1000, 60);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();

        canvas.drawBitmap(bmpBall,ballX,ballY,paintBall);

    }

    private class BallTask extends TimerTask {
        @Override
        public void run() {
            ballX += dx;
            ballY += dy;
            postInvalidate();
        }
    }

}