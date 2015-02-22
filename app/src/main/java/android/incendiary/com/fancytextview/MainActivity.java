package android.incendiary.com.fancytextview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView mListView = (ListView) findViewById(R.id.listview);
		mListView.setAdapter(new SampleAdapter(this));
		mListView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
		Intent intent = new Intent(this, CustomFontAct.class);
		intent.putExtra("selection", getChoice(i));
		startActivity(intent);
	}

	public int getChoice(int position) {
		switch (position) {
			case 0:
				return CustomFontAct.EXTRA_CHOICE_CUSTOM_FONT;
			case 1:
				return CustomFontAct.EXTRA_CHOICE_CUSTOM_GRADIENT;
			default:
				return CustomFontAct.EXTRA_CHOICE_CUSTOM_PATTERN;
		}
	}

	private class SampleAdapter extends ArrayAdapter<String> {

		public SampleAdapter(Context context) {
			super(context, android.R.layout.simple_list_item_1,
					new String[]{"Custom Font", "Gradient", "Pattern"});
		}
	}
}
