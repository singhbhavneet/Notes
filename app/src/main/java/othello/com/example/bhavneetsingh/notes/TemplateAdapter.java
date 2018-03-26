package othello.com.example.bhavneetsingh.notes;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TemplateAdapter<T> extends ArrayAdapter<T>
{
    ArrayList<T>list;
   final ArrayList<T>filteredList=new ArrayList<>();
    Context context;
    public ArrayList<T> getList() {
        return list;
    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public InitAdapter getInitAdapter() {
        return initAdapter;
    }
    public Filter getFilter()
    {
        return new NamesFilter<T>(this,list,filteredList);
    }
    InitAdapter initAdapter;
    public TemplateAdapter(ArrayList<T> list, Context context,InitAdapter initAdapter) {
        super(context,R.layout.share_follow_list);
        this.list = list;
        this.context = context;
        this.initAdapter=initAdapter;
    }
    public int getCount()
    {
        return filteredList.size();

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      return  initAdapter.getView(position,convertView,parent,filteredList);
    }
    interface InitAdapter<T>{
        View getView(int position,View convertView,ViewGroup parent,ArrayList<T>list);

    }
}
