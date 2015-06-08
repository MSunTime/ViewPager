package com.example.a_viewpager;


import java.util.ArrayList;
import java.util.List;

import android.app.ActivityGroup;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup implements OnClickListener {

	public ViewPager mViewPager;
	public PagerTabStrip mPagerTabStrip;
	public View view01, view02;
	public List<View> listView;
	public List<String> tablist;
	public Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	@SuppressWarnings("unused")
	public void initView() {
		mViewPager = (ViewPager)findViewById(R.id.vPager);
		mPagerTabStrip = (PagerTabStrip)findViewById(R.id.pagertab);
		mPagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.red));
		mPagerTabStrip.setDrawFullUnderline(false); 
		mPagerTabStrip.setBackgroundColor(getResources().getColor(R.color.white)); 
		mPagerTabStrip.setTextSpacing(100);           
		
		
		@SuppressWarnings("static-access")
		LayoutInflater mLayoutInflater = getLayoutInflater().from(this);
		
		listView = new ArrayList<View>();
		view01 = getLocalActivityManager().startActivity("activity01",
				new Intent(MainActivity.this, activity01.class)).getDecorView();
		view02 = getLocalActivityManager().startActivity("activity02", 
				new Intent(MainActivity.this, activity02.class )).getDecorView();
		
		listView.add(view01);
		listView.add(view02);
		
		tablist = new ArrayList<String>();
		tablist.add("第一个Activity");
		tablist.add("第二个Activity");
		
		PagerAdapter mPagerAdapter = new PagerAdapter() {
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return listView.size();
			}
			
			@Override  
            public void destroyItem(ViewGroup container, int position,  
                    Object object) {  
                container.removeView(listView.get(position));  
  
            }  
  
            @Override  
            public int getItemPosition(Object object) {  
  
                return super.getItemPosition(object);  
            }  
  
            @Override  
            public CharSequence getPageTitle(int position) {  
  
                return tablist.get(position);
  
            }  
  
            @Override  
            public Object instantiateItem(ViewGroup container, int position) {  
                container.addView(listView.get(position));         
                return listView.get(position);  
            } 
		};
		
		mViewPager.setAdapter(mPagerAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}
