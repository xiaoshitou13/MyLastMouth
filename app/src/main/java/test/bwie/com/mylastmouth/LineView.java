package test.bwie.com.mylastmouth;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 白玉春 on 2017/10/8.
 */

public class LineView extends View{

    /**
     * 1. LinearGradient(float x0, float y0, float x1, float y1, int colors[], float positions[], TileMode tile)
     注：Android中计算x,y坐标都是以屏幕左上角为原点，向右为x+，向下为y+
     第一个参数为线性起点的x坐标
     第二个参数为线性起点的y坐标
     第三个参数为线性终点的x坐标
     第四个参数为线性终点的y坐标
     第五个参数为实现渐变效果的颜色的组合
     第六个参数为前面的颜色组合中的各颜色在渐变中占据的位置（比重），如果为空，则表示上述颜色的集合在渐变中均匀出现
     第七个参数为渲染器平铺的模式，一共有三种

     -CLAMP
     边缘拉伸
     -REPEAT
     在水平和垂直两个方向上重复，相邻图像没有间隙
     -MIRROR
     以镜像的方式在水平和垂直两个方向上重复，相邻图像有间隙

    2. public LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, TileMode tile)
     其他参数同上
     int color0表示渐变起始颜色
     int color1表示渐变终止颜色

     */
    private Paint paint;
    public static final int OFFSET = 5;
    private double mRandom;
    private float mcurrentHeight;
    private LinearGradient mLinearGradient;
    private int width;
    private int height;
    private int mRectWidth;
    private int mwidth;
    private int mheight;
    private int mrectwidth;

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initview(context);
    }

    private void initview(Context context) {
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mwidth = getMeasuredWidth();
        mheight = getMeasuredHeight();
        mrectwidth = (int) (mwidth*0.5/10);
        LinearGradient mLinearGradient = new LinearGradient(10,10,mrectwidth
                ,mheight,Color.BLACK,Color.WHITE, Shader.TileMode.CLAMP
        );

        paint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i = 0 ; i < 10 ; i++) {
            double mRandom = Math.random();
            float mcurrentheight = (float) (mheight * mRandom);
            float widths = (float) (mwidth * 0.4 /2 + OFFSET);
            canvas.drawRect(widths + i * mrectwidth, mcurrentheight,widths+(i+1)*mrectwidth,mheight,paint);
        }
        postInvalidateDelayed(100);
    }




}
