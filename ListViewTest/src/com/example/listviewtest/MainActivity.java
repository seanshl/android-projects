package com.example.listviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private List<Fruit> fruitList = new ArrayList<Fruit> ();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.initFruit();

		FruitAdapter adapter = new FruitAdapter(this, R.layout.fruit_item, fruitList);

		ListView listView = (ListView)this.findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Fruit fruit = fruitList.get(position);
				Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void initFruit() {
		Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
		fruitList.add(apple);
		Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
		fruitList.add(banana);
		Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
		fruitList.add(orange);
		Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
		fruitList.add(watermelon);
		Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
		fruitList.add(pear);
		Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
		fruitList.add(grape);
		Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
		fruitList.add(pineapple);
		Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
		fruitList.add(strawberry);
		Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
		fruitList.add(cherry);
		Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
		fruitList.add(mango);
	}
}
