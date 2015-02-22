package android.incendiary.com.fancytextview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by esa on 22/02/15, with awesomeness
 */
public class CustomFontAct extends ActionBarActivity {

	public static final int EXTRA_CHOICE_CUSTOM_FONT = 0x1;
	public static final int EXTRA_CHOICE_CUSTOM_GRADIENT = 0x2;
	public static final int EXTRA_CHOICE_CUSTOM_PATTERN = 0x3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textview);

		int selection = getIntent().getExtras().getInt("selection");

		TextView textView = (TextView) findViewById(R.id.textview);

		switch (selection) {
			case EXTRA_CHOICE_CUSTOM_FONT:
				Typeface typeface = Typeface.createFromAsset(getAssets(), "Stink on the Death.ttf");
				textView.setTypeface(typeface);
				textView.setText("Custom Font");
				break;

			case EXTRA_CHOICE_CUSTOM_GRADIENT:
				Shader shader = new LinearGradient(0, 0, 0, textView.getTextSize(), Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
				textView.getPaint().setShader(shader);
				textView.setText("Gradient");
				break;

			case EXTRA_CHOICE_CUSTOM_PATTERN:
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cheetah);
				shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
				textView.getPaint().setShader(shader);
				textView.setText("Cheetah Pattern");
				break;
		}
	}
}
