package com.lawyer.mashowra;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

public class CustomListViewAdapter extends ArrayAdapter<Book> {

	private Activity activity;

	public CustomListViewAdapter(Activity activity, int resource, List<Book> books) {
		super(activity, resource, books);
		this.activity = activity;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		LayoutInflater inflater = (LayoutInflater) activity
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		// If holder not exist then locate all view from UI file.
		if (convertView == null) {
			// inflate UI from XML file
			convertView = inflater.inflate(R.layout.item_listview, parent, false);
			// get all UI view
			holder = new ViewHolder(convertView);
			// set tag for holder
			convertView.setTag(holder);
		} else {
			// if holder created, get tag from view
			holder = (ViewHolder) convertView.getTag();
		}

		Book book = getItem(position);
		
		holder.title.setText(book.getTitle());
		holder.body.setText(book.getBody());
		holder.time.setText(book.getTime());
		holder.url.setText(book.getUrl());
		Picasso.with(activity).load(book.getImageUrl()).into(holder.image);
		
		return convertView;
	}

	private static class ViewHolder {
		private TextView title;
		private TextView body;
		private TextView time;
		private TextView url;
		private ImageView image;

		public ViewHolder(View v) {
			title = (TextView) v.findViewById(R.id.title);
			image = (ImageView) v.findViewById(R.id.thumbnail);
			body = (TextView) v.findViewById(R.id.body);
			time = (TextView) v.findViewById(R.id.time);
			url = (TextView) v.findViewById(R.id.url);
		}
	}

}
